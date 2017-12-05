class ClassWithTypedAndUntypedMethods {
    // public is default
    // return type is not used for dispatch
    // args are of type Object
    static main(args) {
        def some = new ClassWithTypedAndUntypedMethods()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypedMethod()
        combinedMethod()
    }
    void publicVoidMethod() { }
    def publicUntypedMethod() {
        return 'hi'
    }
    String publicTypedMethod() {
        return 'ho'
    }
    private static final void combinedMethod() { }
}
