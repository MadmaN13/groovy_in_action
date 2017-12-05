package chapter7_oop

def oracle(Object o) { return 'object' }
def oracle(String o) { return 'string' }
Object x = 1
Object y = 'foo'
assert 'object' == oracle(x)
assert 'string' == oracle(y)

// can selectively override methods with multimethods
class Equalizer {
    boolean equals(Equalizer e){
        return true
    }
}
Object same = new Equalizer()
Object other = new Object()
assert new Equalizer().equals( same )
assert ! new Equalizer().equals( other )
