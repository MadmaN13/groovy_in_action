package chapter4_collections.lists

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
myList = ['a', 'b', 'c']
// not obvious
assert myList.isCase('a')
// implicit syntax
assert 'b' in myList
// containment classifier
def candidate = 'c'
switch(candidate){
    case myList : assert true; break
    default : assert false
}
// interception filter
assert ['x','a','z'].grep(myList) == ['a']
myList = []
// empty list is Boolean.FALSE
if (myList) assert false

// concatenate list elements into string
// list can contain mixture of types
def expr = ''
for (i in [1,'*',5]){
    expr += i
}
assert expr == '1*5'