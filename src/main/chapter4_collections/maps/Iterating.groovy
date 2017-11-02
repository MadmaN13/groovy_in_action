package chapter4_collections.maps

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
def myMap = [a:1, b:2, c:3]
def store = ''

// Map’s each method uses closures in two ways: passing one parameter into the closure
// means that it’s an entry, and passing two parameters means it’s a key and a value.
// java style
myMap.each { entry ->
    store += entry.key
    store += entry.value
}
assert store == 'a1b2c3'

store = ''
// first arg is key, second is value (names can differ from traditional key,value)
myMap.each { key, value ->
    store += key
    store += value
}
assert store == 'a1b2c3'
store = ''

// iterate only over keys
for (key in myMap.keySet()) {
    store += key
}
assert store == 'abc'
store = ''

// iterate only over values
for (value in myMap.values()) {
    store += value
}
assert store == '123'