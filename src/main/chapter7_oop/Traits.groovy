package chapter7_oop

trait HasId {
    long id
}
trait HasVersion {
    long version
}
trait Persistent {
    // default impl
    boolean save() { println "saving ${this.dump()}" }
}
trait Entity implements Persistent, HasId, HasVersion {
    // overriding
    boolean save() {
        version++
        Persistent.super.save()
    }
}
class IntrusivePublication implements Entity {
    String title
}
class IntrusiveBook extends IntrusivePublication {
    String isbn
}
Entity gina = new IntrusiveBook(id:1, version:1, title:"gina", isbn:"111111")
gina.save()
assert gina.version == 2

// flexible runtime behavior with coercion
class Publication {
    String title
}
class Book extends Publication {
    String isbn
}
Entity regina = new Book(title:"gina", isbn:"111111") as Entity
regina.id = 1
regina.version = 1

regina.save()
assert regina.version == 2