package chapter8_dynamic_programming.metaclass

class InspectMe {
    int outer(){
        return inner()
    }
    private int inner(){
        return 1
    }
}
def tracer = new TracingInterceptor(writer: new StringWriter())
def proxyMetaClass = groovy.lang.ProxyMetaClass.getInstance(InspectMe)
proxyMetaClass.interceptor = tracer
InspectMe inspectMe = new InspectMe()
inspectMe.metaClass = proxyMetaClass
assert 1 == inspectMe.outer()
println tracer.writer.toString()

// now change to default no-proxy metaclass
proxyMetaClass.use(inspectMe){
    inspectMe.outer() // proxy in use
}
