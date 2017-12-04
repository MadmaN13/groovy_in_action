package chapter6_control_struct.conditions

if (true) assert true
else assert false
if (1) {
    assert true
} else {
    assert false
}
if ('nonempty') assert true
else if (['x']) assert false
else assert false
if (0) assert false
else if ([]) assert false
else assert true

// conditional ?:
def result = (1==1) ? 'ok' : 'failed'
assert result == 'ok'
result = 'non empty' ? 10 : ['x']
assert result == 10

// elvis
def argument = "given"
def standard = "default"
def value = argument ?: standard
assert value == "given"