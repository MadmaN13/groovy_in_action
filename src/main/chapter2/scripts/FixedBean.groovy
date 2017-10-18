package chapter2.scripts

import groovy.transform.Immutable

/**
 * Created by NM.Rabotaev on 13.10.2017.
 */
@Immutable class FixedBook {
    String title
}
def gina = new FixedBook('Groovy in Action')
def regina = new FixedBook('Groovy in Action')

assert gina.title == 'Groovy in Action'
assert gina == regina

try {
    gina.title = "Ooops!"
    assert false, "should not reach here"
}
catch (ReadOnlyPropertyException expected) {
    println "Expected error: '$expected.message'"
}