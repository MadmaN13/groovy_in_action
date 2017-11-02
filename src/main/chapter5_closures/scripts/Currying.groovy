package chapter5_closures.scripts

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
// Currying is a sense of partial application
def mult = { x, y -> return x * y }
// creates new closure, applying parameters left to right
def twoTimes = mult.curry(2)
assert twoTimes(5) == 10

// more evident alternative
twoTimes = { y -> mult 2, y }
assert twoTimes(5) == 10

// currying with closures as parameters
def configurator = { format, filter, line ->
    filter(line) ? format(line) : null
}
def appender = { config, append, line ->
    def out = config(line)
    if (out) append(out)
}

// applying logic
// result of the closure call can be used in string superposition
def dateFormatter = { line -> "${new Date()}: $line" }
def debugFilter = { line -> line.contains('debug') }
def consoleAppender = { line -> println line }

def myConf = configurator.curry(dateFormatter, debugFilter)
def myLog = appender.curry(myConf, consoleAppender)

myLog('here is some debug message')
myLog('this will not be printed')