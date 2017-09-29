// java style
def classes = [String,List,File]
for (clazz in classes) {
    println clazz.package.name
}

// groovy access style
//* is optional, shows that every element in list is accessed
println( classes*.package*.name)