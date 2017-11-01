package chapter4_collections.lists

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
//---------------------------Explicit operations with overloaded subscript operator----------------------------
myList = ['a','b','c','d','e','f']
// getAt()
assert myList[0..2] == ['a','b','c']
assert myList[0,2,4] == ['a','c','e']
// putAt()
myList[0..2] = ['x','y','z']
assert myList == ['x','y','z','d','e','f']
// removing elements
myList[3..5] = []
assert myList == ['x','y','z']
// add several elements by index
myList[1..1] = [0, 1, 2]
assert myList == ['x', 0, 1, 2, 'z']
// ------------------------------------------Implicit operations-----------------------------------------------
myList = []
myList += 'a'
assert myList == ['a']

myList += ['b','c']
assert myList == ['a','b','c']

myList = []
// adding by left "right" operator (>> will not work)
myList << 'a' << 'b'
assert myList == ['a','b']
assert myList - ['b'] == ['a']
// multiply list by n = concatenation(+) of copy for n times
// NOTE: equals method on lists tests that two collections have equal elements
assert myList * 2 == ['a','b','a','b']
