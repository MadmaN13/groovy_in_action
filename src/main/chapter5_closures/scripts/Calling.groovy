package chapter5_closures.scripts

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
def adder = { x, y -> return x+y }
assert adder(4, 3) == 7
// implicit call
assert adder.call(2, 6) == 8

def benchmark(int repeat, Closure worker) {
    def start = System.nanoTime()
    repeat.times { worker(it) }
    def stop = System.nanoTime()
    return stop - start
}
def slow = benchmark(10000) { (int) it / 2 }
def fast = benchmark(10000) { it.intdiv(2) }
assert fast * 2 < slow

// with default values
adder = { x, y=5 -> return x+y }
assert adder(4, 3) == 7
assert adder(7) == 12
assert adder.call(7) == 12

adder.curry()