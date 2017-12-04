// while is the same as in Java, with that difference, that it uses groovy truth in evaluating the execution condition
def list = [1,2,3]
// list asBoolean() for list returns isEmpty()
while (list) {
    list.remove(0)
}
assert list == []
while (list.size() < 3) list << list.size()+1
assert list == [1,2,3]

// NOTE: no built-in do{} while(condition) in groovy
