package chapter7_oop

class VendorWithCtor {
    String name, product
    VendorWithCtor(name, product) {
        this.name = name
        this.product = product
    }
}

// calling constructor
// explicit
def first = new VendorWithCtor('Canoo','ULC')
// implicit
// NOTE: does not work for abstract class and interface (available only for statically typed refs)
def second = ['Canoo','ULC'] as VendorWithCtor
VendorWithCtor third = ['Canoo','ULC']

// implicit default constructor used with named parameters
// becomes unavailable when explicit constructor with args enabled
class SimpleVendor {
    String name, product
}
new SimpleVendor()
new SimpleVendor(name: 'Canoo')
new SimpleVendor(product: 'ULC')
new SimpleVendor(name: 'Canoo', product: 'ULC')
def vendor = new SimpleVendor(name: 'Canoo')
assert 'Canoo' == vendor.name