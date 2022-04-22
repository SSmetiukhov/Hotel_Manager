public class ProblematicTenantException extends Exception{
    public ProblematicTenantException(Person p) {super("Person " + p + " had already renting these rooms:" + p.getTenantLetters());}
}