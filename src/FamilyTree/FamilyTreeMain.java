package FamilyTree;

import Utilities.Library;


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
        person1.children.get(1).children.get(0).children.get(0).addChild(new Person("Atticus", "Canada"));



        person1.children.get(2).addChild(new Person("Bob III", "Japan"));
        person1.children.get(2).addChild(new Person("Jasmine", "Japan"));
        person1.children.get(2).children.get(0).addChild(new Person("Bob IV", "Spain"));
        person1.children.get(2).children.get(1).addChild(new Person("Zaiesah", "Russia"));
        person1.children.get(2).children.get(1).addChild(new Person("Steve", "Canada"));

        System.out.println(countFamily(person1) + 1);
        printFamily(person1);
        System.out.println("\nThese people are LOWK canadian:");
        printCanadians(person1);

        printFromHere(person1);
    }

    public static int countFamily (Person ptemp){
        int num = 0;
        if(ptemp.children.isEmpty()){
            num += 0;

        }
        else{
            for (int i = 0; i < ptemp.children.size(); i++) {
                num+= (1 + countFamily(ptemp.children.get(i)));
            }


        }
return num;


    }

    public static void printFamily(Person ptemp) {
        if(ptemp.children.isEmpty()){
            System.out.println(ptemp.getName());
        }
        else{
            System.out.println(ptemp.getName());
            for (int i = 0; i < ptemp.children.size(); i++) {
                printFamily(ptemp.children.get(i));
            }

        }


    }

    public static void printCanadians(Person ptemp){
        if(ptemp.getCountry().equalsIgnoreCase("canada")){
            System.out.println(ptemp.getName());
            for (int i = 0; i < ptemp.children.size(); i++) {
                printCanadians(ptemp.children.get(i));
            }
        }
        else{
            for (int i = 0; i < ptemp.children.size(); i++) {
                printCanadians(ptemp.children.get(i));
            }
        }
    }

    public static void printFromHere(Person ptemp){
        System.out.println("Who would you like to search for?");
        String search = Library.input.nextLine();
        System.out.println("\nPrinting " + search +"'s family\n");
        checkChildren(ptemp, search);

    }
    public static void checkChildren(Person ptemp, String searchTerm){

            if(ptemp.getName().equalsIgnoreCase(searchTerm)){
                printFamily(ptemp);
            }
            else{
                for (int i = 0; i < ptemp.children.size(); i++) {
                    checkChildren(ptemp.children.get(i), searchTerm);
                }
            }
    }

}
