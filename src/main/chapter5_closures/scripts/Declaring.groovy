package chapter5_closures.scripts

import chapter5_closures.MultiMethodSample
import chapter5_closures.SizeFilter

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
// A closure is a piece of code wrapped up as an object
log = ''
(1..10).each{ counter -> log += counter }
assert log == '12345678910'

// it is a closure keyword
log = ''
(1..10).each{ log += it }
assert log == '12345678910'

// use as parameter
log = ''
(1..10).each({ log += it })
assert log == '12345678910'

// direct assignment
def printer = { line -> println line }

// structural style
def Closure getPrinter() {
    return { line -> println line }
}

// NOTE: Being objects, closures can also be returned from a method

// Referring to methods as closures
SizeFilter filter6 = new SizeFilter(limit:6)
SizeFilter filter5 = new SizeFilter(limit:5)
// omg, omg, some magic!
Closure sizeUpTo6 = filter6.&sizeUpTo
def words = ['long string', 'medium', 'short', 'tiny']
assert 'medium' == words.find (sizeUpTo6)
assert 'short' == words.find (filter5.&sizeUpTo)

// multimethod example - runtime overload resolution
MultiMethodSample instance = new MultiMethodSample()
Closure multi = instance.&mysteryMethod
assert 10 == multi ('string arg')
assert 3 == multi (['list', 'of', 'values'])
assert 14 == multi (6, 8)
