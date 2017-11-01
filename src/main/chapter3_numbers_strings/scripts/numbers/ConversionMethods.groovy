/**
 * Created by NM.Rabotaev on 23.10.2017.
 */
assert 1 == (-1).abs()
assert 2 == 2.5.toInteger() // conversion
assert 2 == 2.5 as Integer // enforced coercion
assert 2 == (int) 2.5 // cast
assert 3 == 2.5f.round()
assert 3.142 == Math.PI.round(3)
assert 4 == 4.5f.trunc()
assert 2.718 == Math.E.trunc(3)
assert '2.718'.isNumber() // String methods

// Want String -> Integer?
// Use these:
assert 5 == '5'.toInteger()
assert 5 == '5' as Integer
// (!!!) Do not use cast:
assert 53 == (int) '5' // dec Unicode(5) = 53
assert '6 times' == 6 + ' times' // Number + String