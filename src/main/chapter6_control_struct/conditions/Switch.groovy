// NOTE: switch is based on inCase()
switch (10) {
    case 0 : assert false ; break
    case 0..9 : assert false ; break
    case [8,9,11] : assert false ; break
    case Float : assert false ; break
    case {it%3 == 0}: assert false ; break
    case ~/../ : assert true ; break
    default : assert false ; break
}

// standard impl of isCase
//Object        | a.equals(b)
//Class         | a.isInstance(b)
//Collection    | a.contains(b)
//Range         |a.contains(b)
//Pattern       |a.matcher(b.toString()).matches()
//String        |(a==null && b==null) || a.equals(b)
//Closure       |a.call(b)

// collection.grep(classifier) returns a collection of all items that are a case
//of that classifier

// also inCase is is used by "IN" operator