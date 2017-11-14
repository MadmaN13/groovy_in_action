package chapter6_control_struct.truth
//  Type            | Truth criterion
//Boolean           |   Corresponding Boolean value is true
//Matcher           |   Matcher has a match
//Collection        |   Collection is nonempty
//Map               |   Map is nonempty
//String, GString   |   String is nonempty
//Number, Character |   Value is nonzero
//None of the above |   Object reference is non-null

assert true
assert !false
assert ('a' =~ /./)
assert !('a' =~ /b/)
assert [1]
assert ![]
Iterator iter = [1].iterator()
assert iter
iter.next()
assert !iter
assert ['a':1]
assert ![:]
assert 'a'
assert !''

assert 1
assert 1.1
assert 1.2f
assert 1.3g
assert 2L
assert 3G
assert !0
assert ! null
assert new Object()
class AlwaysFalse {
    boolean asBoolean() { false }
}
assert ! new AlwaysFalse()