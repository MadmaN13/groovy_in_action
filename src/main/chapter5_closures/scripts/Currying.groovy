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

// for closures compositions use >> and <<
def fourTimes = twoTimes >> twoTimes
def eightTimes = twoTimes << fourTimes

assert eightTimes(1) == twoTimes(fourTimes(1))

// caching results with memoize()
def fib
fib = { it < 2 ? 1 : fib(it-1) + fib(it-2) }
fib = fib.memoize()
assert fib(40) == 165_580_141
// tail-recursive calls can lead to mem leak - use trampoline() to avoid
def last
last = { it.size() == 1 ? it.head() : last.trampoline(it.tail()) }
last = last.trampoline()
assert last(0..10_000) == 10_000

// NOTE: trampoline() is for closures only
// for methods use @TailRecursive
// also supports clone, writeTo(Writer) methods

// inCase() implementation for grep and switch
def odd = { it % 2 == 1}
assert [1,2,3].grep(odd) == [1, 3]
switch(10) {
    case odd : assert false
}
if (2 in odd) assert false

