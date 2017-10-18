/**
 * Created by NM.Rabotaev on 18.10.2017.
 */

// ------------------------List------------------------
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
assert roman[4] == 'IV'

// auto expansion
roman[8] = 'VIII'
assert roman.size() == 9

// -------------------------Map-------------------------
def http = [
        100 : 'CONTINUE',
        200 : 'OK',
        400 : 'BAD REQUEST'
]
assert http[200] == 'OK'
// expansion
http[500] = 'INTERNAL SERVER ERROR'
// reassignment
assert http.size() == 4
http[400] = 'NEW BAD REQUEST'
assert http[400] == 'NEW BAD REQUEST'

// -------------------------Range-------------------------
def x = 1..10
assert  x.contains(5)
assert !x.contains(15)
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert x.reverse() == 10..1


