package chapter8_dynamic_programming

//implement
//Object propertyMissing(String name)
//to catch all access to nonexisting properties.

// simple example
class PropPretender {
    def propertyMissing(String name) {
        "accessed $name"
    }
}
def bounce = new PropPretender()
assert bounce.hello == 'accessed hello'

// changing hook logic at runtime
class DynamicPretender {
    Closure whatToDo = { name -> "accessed $name"}
    def propertyMissing(String name) {
        whatToDo(name)
    }
}
def one = new DynamicPretender()
assert one.hello == 'accessed hello'
one.whatToDo = { name -> name.size() }
assert one.hello == 5

// NOTE: Once you’ve implemented getProperty(), every property will be
// found and thus propertyMissing() will no longer be called.