package chapter8_dynamic_programming.metaclass

def move(string, distance) {
    string.collect { (it as char) + distance as char }.join()
}
String.metaClass {
    shift = -1
    encode {-> move delegate, shift }
    decode {-> move delegate, -shift }
    getCode {-> encode() }
    getOrig {-> decode() }
}
assert "IBM".encode() == "HAL"
assert "HAL".orig == "IBM"
def ibm = "IBM"
ibm.shift = 7
assert ibm.code == "PIT"

// adding static method
Integer.metaClass.static.answer = {-> 42}
assert Integer.answer() == 42