package chapter7_oop.beans

// Java
public class JavaBean implements java.io.Serializable {
    private String myprop;
    public String getMyprop(){
        return myprop;
    }
    public void setMyprop(String value){
        myprop = value;
    }
}

// Groovy equivalent
class GroovyBean implements Serializable {
    String myprop
}

// properties declaring
class MyBean implements Serializable {
    def untyped
    String typed
    def item1, item2
    def assigned = 'default value'
}
def bean = new MyBean()
assert 'default value' == bean.getAssigned()
bean.setUntyped('some value')
assert 'some value' == bean.getUntyped()
bean = new MyBean(typed:'another value')
assert 'another value' == bean.getTyped()

// calling accessors is uniform
class MrBean {
    String firstname, lastname
    String getName(){
        return "$firstname $lastname"
    }
}
def mrBean = new MrBean(firstname: 'Rowan')
mrBean.lastname = 'Atkinson'
assert 'Rowan Atkinson' == mrBean.name

// direct access with .@
class DoublerBean {
    // inside class scope references to field are resolved as field access
    public value
    void setValue(value){
        this.value = value
    }
    def getValue(){
        value * 2
    }
}
def doublerBean = new DoublerBean(value: 100)
// outside the class scope references to field are resolved as property access (via get())
assert 200 == doublerBean.value
// outside the class field for field access can be used .@
assert 100 == doublerBean.@value
