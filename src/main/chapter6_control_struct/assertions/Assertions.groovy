// instrumenting assertions with error messages
input = new File('no such file')
assert input.exists() , "cannot find '$input.name'"
assert input.canRead() , "cannot read '$input.canonicalPath'"
println input.text

// some best practices:
// Before writing an assertion, let your code fail, and see whether any other
// thrown exception is good enough.
// ■ When writing an assertion, let it fail the first time, and see whether the failure
// message is sufficient. If not, add a message. Let it fail again to verify that the
// message is now good enough.
// ■ If you feel you need an assertion to clarify or protect your code, add it regardless
// of the previous rules.
// ■ If you feel you need a message to clarify the meaning or purpose of your assertion,
//        add it regardless of the previous rules.


// example of use in inline unit tests
def host = /\/\/([a-zA-Z0-9-]+(\.[a-zA-Z0-9-])*?)(:|\/)/
assertHost 'http://a.b.c:8080/bla', host, 'a.b.c'
assertHost 'http://a.b.c/bla', host, 'a.b.c'
assertHost 'http://127.0.0.1:8080/bla', host, '127.0.0.1'
assertHost 'http://t-online.de/bla', host, 't-online.de'
assertHost 'http://T-online.de/bla', host, 'T-online.de'
def assertHost (candidate, regex, expected) {
    candidate.eachMatch(regex) {
        assert it[1] == expected
    }
}
