package chapter4_collections.lists

/**
 * Created by NM.Rabotaev on 01.11.2017.
 */
// Querying
def list = [1, 2, 3]
assert list.first() == 1
// list = head (first element) and tail (all elements but the first)
assert list.head() == 1
assert list.tail() == [2, 3]
assert list.last() == 3
// the number of element entrance in the list
assert list.count(2) == 1
assert list.max() == 3
assert list.min() == 1
def even = list.find { item ->
    item % 2 == 0
}
assert even == 2
// condition is true for any element
assert list.every { item -> item < 5 }
// condition is true for at least one element
assert list.any { item -> item < 2 }

// Iterating
def store = ''
list.each { item ->
    store += item
}
assert store == '123'
store = ''
list.reverseEach { item ->
    store += item
}
assert store == '321'
store = ''
list.eachWithIndex { item, index ->
    store += "$index:$item "
}
assert store == '0:1 1:2 2:3 '

// Accumulating
// add separator
assert list.join('-') == '1-2-3'
result = list.inject(0) { clinks, guests ->
    clinks + guests
}
assert result == 0 + 1 + 2 + 3
assert list.sum() == 6
factorial = list.inject(1) { fac, item ->
    fac * item
}
assert factorial == 1 * 1 * 2 * 3

// see also permutations, take, transpose, and withIndex methods
list.asImmutable()
list.asSynchronized()
assert [[1],[2],[3]] == list.collate(1)
//list.collectMany {true}
list << ['a','b'] << ['kek','lol']
list.combinations().forEach{println it}

list = [1,2,3]
list.dropWhile {it !=2 } == [2,3]
list.dropWhile {it !=3 } == [3]

// divide into numbers and non-numbers
def divided = ['1', '1.0', 'a', 'b'].groupBy { it.isNumber() }
assert divided[true] == ['1', '1.0']
assert divided[false] == ['a', 'b']