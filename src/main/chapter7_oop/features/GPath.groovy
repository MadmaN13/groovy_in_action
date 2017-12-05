package chapter7_oop.features

this.class.methods.name.grep(~/get.*/).sort().each {println it}

// .name = list.collect{ item -> item?.property } (shorthand for .* operator)
//The spread-dot operator is needed whenever a method should be
//applied to all elements of the list rather than to the list itself. It is equivalent to
//list.collect{ item -> item?.member }

// equivalent java getter-style
//this.getClass().getMethods().each {it.getName()}

class Invoice {
    List items
    Date date
}
class LineItem {
    Product product
    int count
    int total() {
        return product.dollar * count
    }
}
class Product {
    String name
    def dollar
}
def ulcDate = Date.parse('yyyy-MM-dd', '2015-01-01')
def otherDate = Date.parse('yyyy-MM-dd', '2015-02-02')
def ulc = new Product(dollar:1499, name:'ULC')
def ve = new Product(dollar:499, name:'Visual Editor')
def invoices = [
        new Invoice(date:ulcDate, items: [
                new LineItem(count:5, product:ulc),
                new LineItem(count:1, product:ve)
        ]),
        new Invoice(date:otherDate, items: [
                new LineItem(count:4, product:ve)
        ])
]
def allItems = invoices.items.flatten()
assert [5*1499, 499, 4*499] == allItems*.total()
assert ['ULC'] == allItems.grep{it.total() > 7000}.product.name

def searchDates = invoices.grep{
    it.items.any{it.product == ulc}
}.date*.toString()
assert [ulcDate.toString()] == searchDates

