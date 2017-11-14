package chapter5_closures

class Mother {

    def prop = 'prop'
    def method(){ 'method' }

    Closure birth (param) {
        def local = 'local'
        def closure = {
            [ this, prop, method(), local, param ]
        }
        return closure
    }
}
