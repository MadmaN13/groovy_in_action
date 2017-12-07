package chapter8_dynamic_programming.metaclass

// class meta class
class MyGroovy1 { }
def before = new MyGroovy1()
// meta data and behaviour are available only for instances created after adding
MyGroovy1.metaClass.myProp = "MyGroovy prop"
MyGroovy1.metaClass.test = {-> myProp }
def after = new MyGroovy1()
try {
    before.test()
    assert false, "should throw MME"
} catch(mme) { }
assert after.test() == "MyGroovy prop"

// instance meta class
class MyGroovy2 { }
def myGroovy = new MyGroovy2()
myGroovy.metaClass.myProp = "MyGroovy prop"
myGroovy.metaClass.test = {-> myProp }
try {
    new MyGroovy2().test()
    assert false, "should throw MME"
} catch(mme) { }
assert myGroovy.test() == "MyGroovy prop"