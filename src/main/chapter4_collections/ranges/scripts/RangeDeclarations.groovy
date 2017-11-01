/**
 * Created by NM.Rabotaev on 24.10.2017.
 */
assert (0..10).contains(0)
assert (0..10).contains(5)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

// half-inclusive range does not contain right boundary
assert (0..<10).contains(9)
assert (0..<10).contains(10) == false

def a = 0..10
assert a instanceof Range
assert a.contains(5)

a = new IntRange(0,10)
assert a.contains(5)

assert (0.0..1.0).contains(1.0)
assert (0.0..1.0).containsWithinBounds(0.5)

// Date is usable with ranges beacuse next() (plus 1 day) and previous() (minus 1 day) are overridden for them
// the same is for String
def today = new Date()
def yesterday = today - 1
assert (yesterday..today).size() == 2

assert ('a'..'c').contains('b')
def log = ''
for (element in 5..9){
    log += element
}
assert log == '56789'

log = ''
for (element in 9..5){
    log += element
}

assert log == '98765'
log = ''
(9..<5).each { element ->
    log += element
}
assert log == '9876'

// Ranges are objects
def result = ''
(5..9).each { element ->
    result += element
}
assert result == '56789'
assert 5 in 0..10
// same as in operator
assert (0..10).isCase(5)
def age = 36
switch(age){
    case 16..20 : insuranceRate = 0.05 ; break
    case 21..50 : insuranceRate = 0.06 ; break
    case 51..65 : insuranceRate = 0.07 ; break
    default: throw new IllegalArgumentException()
}
assert insuranceRate == 0.06
def ages = [20, 36, 42, 56]
def midage = 21..50
assert ages.grep(midage) == [36, 42]

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')
def worklog = ''
for (day in mon..fri) {
    worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '
