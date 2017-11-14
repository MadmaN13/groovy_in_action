package chapter5_closures.scripts

import chapter5_closures.Mother

// var is accessible for r/w from enclosing area
// NOTE: {} show the declaration time(birthday), not execution
// closure has the reference to birthday context which allows to change var x at execution time
def x = 0
10.times {
    x++
}
assert x == 10

//delegate examples
Mother julia = new Mother()
def closure = julia.birth('param')
def context = closure.call()
assert context[0] == julia
assert context[1, 2] == ['prop', 'method']
assert context[3, 4] == ['local', 'param' ]
assert closure.thisObject == julia
assert closure.owner == julia
assert closure.delegate == julia
assert closure.resolveStrategy == Closure.OWNER_FIRST

// GDK with() uses delegate
def map = [:]
map.with { // delegate is now map
    a = 1 // same as map.a = 1
    b = 2 // same as map.b = 2
}
assert map == [a:1, b:2]

// accumulator example in groovy
def foo(n) {
  return {n += it}
}
def accumulator = foo(1)
assert accumulator(2) == 3
assert accumulator(1) == 4

// NOTE: return from closure end only current closure evaluation
// for example: using List.each, returning early from the
// closure doesn’t return early from the each method—the closure will still be called
// again with the next element in the list.