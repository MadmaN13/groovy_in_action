package chapter4_collections.lists

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
List myList = [1, 2, 3]
assert myList.size() == 3
assert myList[0] == 1
// by default implicit declaration
assert myList instanceof ArrayList

List emptyList = []
assert emptyList.size() == 0

// all java collections and collective datatypes are expanded by groovy wrapper with toList()
List longList = (0..1000).toList()
assert longList[555] == 555
// and even Strings
List stringList = 'Hello'.toList()
assert stringList[0] == 'H'

List explicitList = new ArrayList()
explicitList.addAll(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10

// can be declared explicitly
explicitList = new LinkedList(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10