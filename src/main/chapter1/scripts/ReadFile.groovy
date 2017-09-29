def number = 0
new File('C:\\Users\\NM.Rabotaev\\IdeaProjects\\groovy_in_action\\src\\main\\resources\\file.txt').eachLine { line ->
    number++
    println "$number: $line"
}