package chapter4_collections.lists

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
// list also can by nested (alternative for multidimensional Java arrays)
assert [1,[2,3]].flatten() == [1,2,3]
assert [1,2,3].intersect([4,3,1])== [3,1]
// empty intersection
assert [1,2,3].disjoint([4,5,6])

// list as stack
list = [1,2,3]
popped = list.pop()
assert popped == 3
assert list == [1,2]

assert [1,2].reverse() == [2,1]

// sorting
assert [3,1,2].sort() == [1,2,3]
def list = [ [1,0], [0,1,2] ]
// NOTE: spaceship operator a<=>b (a less than b(-1), a equals b(0), a greater than b(1)) is same as compareTo()
list = list.sort { a,b -> a[0] <=> b[0] }
assert list == [ [0,1,2], [1,0] ]
list = list.sort { item -> item.size() }
// removal by index and value is from java
assert list == [ [1,0], [0,1,2] ]
list = ['a','b','c']
list.remove(2)
assert list == ['a','b']
list.remove('b')
assert list == ['a']

list = ['a','b','b','c']
list.removeAll(['b','c'])

// map()
assert list == ['a']
def doubled = [1,2,3].collect{ item ->
    item*2
}

// find all elements satisfying to closure condition
assert doubled == [2,4,6]
def odd = [1,2,3].findAll{ item ->
    item % 2 == 1
}
assert odd == [1,3]

// no condition = false (returns empty list)
def same = [1,2,3].findAll{true}
assert same == [1,2,3]

// making list with unique elements (java.util.Set alternative)
def x = [1,1,1,2,2]
// via java
assert [1,2] == new HashSet(x).toList()
// g-style
assert [1,2] == x.unique()

// removing nulls
x = [1,null,1]
assert [1,1] == x.findAll{it!=null}
assert [1,1] == x.grep{it}