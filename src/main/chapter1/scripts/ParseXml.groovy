def filename = 'C:\\Users\\NM.Rabotaev\\IdeaProjects\\groovy_in_action\\src\\main\\resources\\customers.xml';
def customers = new XmlSlurper().parse(new File(filename))

customers.corporate.customer.each {println "${it.@name} works for ${it.@company}"}