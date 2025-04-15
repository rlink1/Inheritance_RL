package FamilyTree;

import java.util.ArrayList;

public class Person {
    public String name;
    public String country;
    public ArrayList<Person> children;

    public Person( String n, String c){
        name = n;
        country = c;
        children = new ArrayList<>();

    }//constructor

    public void addChild(Person p){
        children.add(p);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}//class
