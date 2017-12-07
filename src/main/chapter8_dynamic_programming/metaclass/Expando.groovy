package chapter8_dynamic_programming.metaclass

// classique
def boxer = new groovy.util.Expando()
boxer.takeThis = 'ouch!'
boxer.fightBack = { times -> takeThis * times }
assert boxer.fightBack(3) == 'ouch!ouch!ouch!'

// meta
assert String.metaClass =~ /MetaClassImpl/
String.metaClass.low = {-> delegate.toLowerCase() }
assert String.metaClass =~ /Expando/
assert "DiErK".low() == "dierk"

String.metaClass.printMe = {->println delegate}
"hello".printMe()