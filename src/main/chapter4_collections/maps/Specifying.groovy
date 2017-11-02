package chapter4_collections.maps

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
def myMap = [a:1, b:2, c:3]
// by default
assert myMap instanceof LinkedHashMap
assert myMap.size() == 3
assert myMap['a'] == 1

def emptyMap = [:]
assert emptyMap.size() == 0
// can be initialized explicitly via java.util.Map impl
def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
assert explicitMap['a'] == 1
def composed = [x:'y', *:myMap]
assert composed == [x:'y', a:1, b:2, c:3]