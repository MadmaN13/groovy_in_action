package chapter8_dynamic_programming.metaclass

MetaClass mc = String.metaClass
final Object[] NO_ARGS = []
assert 1 == mc.respondsTo("toString", NO_ARGS).size()
assert 3 == mc.properties.size()
assert 76 == mc.methods.size()
assert 251 == mc.metaMethods.size()
assert "" == mc.invokeMethod("","toString", NO_ARGS)
assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
assert "" == mc.invokeConstructor(NO_ARGS)
