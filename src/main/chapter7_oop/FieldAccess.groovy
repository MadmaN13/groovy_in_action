//overriding the get method means to override the dot-fieldname
//operator. Overriding the set method overrides the field-assignment operator.
class PretendFieldCounter {
    public count = 0
    Object get (String name) {
        return 'pretend value'
    }
    void set (String name, Object value) {
        count++
    }
}
def pretender = new PretendFieldCounter()
assert pretender.isNoField == 'pretend value'
assert pretender.count == 0
pretender.isNoFieldEither = 'just to increase counter'
assert pretender.count == 1
