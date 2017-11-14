package chapter1.scripts

/**
 * Created by NM.Rabotaev on 03.11.2017.
 */
def repeat = 1000000
def constant = 1
repeat.times {
    println "($it) Printing constant value: $constant"
    Thread.sleep(1000)
}
