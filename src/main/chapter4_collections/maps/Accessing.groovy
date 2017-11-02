package chapter4_collections.maps

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
def myMap = [a:1, b:2, c:3]
assert myMap['a'] == 1
assert myMap.a == 1
assert myMap.get('a') == 1

// with default value
assert myMap.get('a',0) == 1

assert myMap['d'] == null
assert myMap.d == null
assert myMap.get('d') == null

assert myMap.get('d',0) == 0
assert myMap.d == 0
myMap['d'] = 1

assert myMap.d == 1
myMap.d = 2
assert myMap.d == 2