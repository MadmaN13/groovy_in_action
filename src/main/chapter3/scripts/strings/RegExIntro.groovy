/**
 * Created by NM.Rabotaev on 23.10.2017.
 */
def twister = 'she sells sea shells at the sea shore of seychelles'
// twister must contain a substring of size 3
// that starts with s and ends with a
assert twister =~ /s.a/
def finder = (twister =~ /s.a/)
assert finder instanceof java.util.regex.Matcher
// twister must contain only words delimited by single spaces
assert twister ==~ /(\w+ \w+)*/
def WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)
assert matches instanceof java.lang.Boolean
assert !(twister ==~ /s.e/)
def wordsByX = twister.replaceAll(WORD, 'x')
assert wordsByX == 'x x x x x x x x x x'
def words = twister.split(/ /)
assert words.size() == 10
assert words[0] == 'she'

def myFairStringy = 'The rain in Spain stays mainly in the plain!'
// words that end with 'ain': \b\w*ain\b
def wordEnding = /\w*ain/
def rhyme = /\b$wordEnding\b/
def found = ''
// uses String.eachMatch(pattern)
myFairStringy.eachMatch(rhyme) { match ->
    found += match + ' '
}
assert found == 'rain Spain plain '
found = ''
// uses Matcher.each()
// the =~ find operator and the ==~ match operator
//      ||
//      ||
//      \/
(myFairStringy =~ rhyme).each { match ->
    found += match + ' '
}
assert found == 'rain Spain plain '
// String.replaceAll() with closure
// "it" is reserved word
def cloze = myFairStringy.replaceAll(rhyme){ it-'ain'+'___' }
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'

// easy access to matcher result
def matcher = 'a b c' =~ /\S/
assert matcher[0] == 'a'
assert matcher[1..2] == ['b','c']
assert matcher.size() == 3

// iterating over group matcher results
def groupMatcher = 'a b c' =~ /\S/
assert groupMatcher[0] == 'a'
assert groupMatcher[1..2] == ['b','c']
assert groupMatcher.size() == 3

// naming match results meaningfully
def mapMatcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/
    mapMatcher.each { full, key, value ->
    assert full.size() == 3
    assert key.size() == 1 // a,b,c
    assert value.size() == 1 // 1,2,3
}


