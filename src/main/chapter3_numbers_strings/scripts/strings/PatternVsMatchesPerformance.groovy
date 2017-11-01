/**
 * Created by NM.Rabotaev on 23.10.2017.
 */
def twister = 'she sells sea shells at the sea shore of seychelles\''

// word starts and end with the same letter
def regex = /\b(\w)\w*\1\b/
def many = 100 * 1000

def implicitAtLeastTwiceSlowerThanPredefined = 0

checkPerformance = {
    start = System.nanoTime()
    many.times {
        // this is implicit find() call - evaluates at runtime
        twister =~ regex
    }
    timeImplicit = System.nanoTime() - start

    start = System.nanoTime()
    // this is precompiled Pattern - runs quicker
    pattern = ~regex
    many.times {
        pattern.matcher(twister)
    }
    timePredef = System.nanoTime() - start

    nanosInSecond = 1000000000
//    println 'Time implicit = ' + timeImplicit/nanosInSecond
//    println 'Time predefined = ' + timePredef/nanosInSecond
    if (timeImplicit > timePredef * 2) implicitGraterThanPredefined++
}

// now run 100 times to check performance stability
def times = 1000
times.times {checkPerformance()}
println "Implicit at least twice slower than predefined = " +
        "$implicitAtLeastTwiceSlowerThanPredefined out of $times"
