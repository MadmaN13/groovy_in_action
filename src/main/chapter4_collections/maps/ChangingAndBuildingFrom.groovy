package chapter4_collections.maps

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
def myMap = [a:1, b:2, c:3]
myMap.clear()
assert myMap.isEmpty()

myMap = [a:1, b:2, c:3]
myMap.remove('a')
assert myMap.size() == 2

assert [a:1] + [b:2] == [a:1, b:2]
myMap = [a:1, b:2, c:3]
def abMap = myMap.subMap(['a', 'b'])
assert abMap.size() == 2

abMap = myMap.findAll { entry -> entry.value < 3 }
assert abMap.size() == 2
assert abMap.a == 1

def found = myMap.find { entry -> entry.value < 2 }
assert found.key == 'a'
assert found.value == 1

def doubled = myMap.collect { entry -> entry.value *= 2 }
assert doubled instanceof List
assert doubled.every { item -> item % 2 == 0 }

// adds all closure results directly to this collection, passed as parameter
def addTo = []
myMap.collect(addTo) { entry -> entry.value *= 2 }
assert addTo instanceof List
assert addTo.every { item -> item % 2 == 0 }
