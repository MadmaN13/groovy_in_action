package chapter7_oop
// NOTE: When
//the reference before ?. operator is a null reference, the evaluation of the current
//expression stops, and null is returned.
def map = [a:[b:[c:1]]]
assert map.a.b.c == 1
if (map && map.a && map.a.x){
    assert map.a.x.c == null
}
try {
    assert map.a.x.c == null
} catch (NullPointerException ignore){
}
assert map?.a?.x?.c == null
