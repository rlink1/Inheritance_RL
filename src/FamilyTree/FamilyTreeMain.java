package FamilyTree;

import java.util.ArrayList;

public class FamilyTreeMain {
    public static void run() {

        Person person1 = new Person("Bobbie", "Mexico");
        //gen 2
        person1.addChild(new Person("Susan", "Canada")); //0
        person1.addChild(new Person("Jill", "Canada"));
        person1.addChild(new Person("Bobette", "Japan"));
        //add child to susan
        person1.children.get(0).addChild(new Person("Zain", "Japan"));
        person1.children.get(0).children.get(0).addChild(new Person("Zain Jr", "Japan"));
        person1.children.get(0).children.get(0).addChild(new Person("Zainette", "Japan"));

        person1.children.get(1).addChild(new Person("Ryder", "Canada"));
        person1.children.get(1).addChild(new Person("Avaya", "Germany"));
        person1.children.get(1).children.get(0).addChild(new Person("Ryza", "Japan"));
        person1.children.get(1).children.get(1).addChild(new Person("Newayna", "Germany"));
        person1.children.get(1).children.get(0).children.get(0).addChild(new Person("Linkey Wink", "Australia"));



        person1.children.get(2).addChild(new Person("Bob III", "Japan"));
        person1.children.get(2).addChild(new Person("Jasmine", "Japan"));
        person1.children.get(2).children.get(0).addChild(new Person("Bob IV", "Spain"));
        person1.children.get(2).children.get(1).addChild(new Person("Zaiesah", "Russia"));
        person1.children.get(2).children.get(1).addChild(new Person("Steve", "Canada"));

        countFamily(person1);
        printFamily(person1);
    }

    public static int countFamily (Person ptemp){
        if(ptemp.children.size() == 0){
            return 0;
        }
        else{

            for (int i = 0; i < ptemp.children.size(); i++) {
                return 1 + countFamily(ptemp.children.get(i));
            }


        }
return 0;


    }

    public static void printFamily(Person ptemp) {
        if(ptemp.children.size() == 0){
            System.out.println(ptemp.getName());
        }
        else{
            System.out.println(ptemp.getName());
            for (int i = 0; i < ptemp.children.size(); i++) {
                printFamily(ptemp.children.get(i));
            }

        }


    }

}
