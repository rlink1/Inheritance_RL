package FamilyTree;

import Utilities.Library;

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
        if(ptemp.children.size() == 0){
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
        ArrayList<Integer> code = new ArrayList<>();
        System.out.println("Who would you like to search for?");
        String search = Library.input.nextLine();
        if(checkChildren(ptemp, search, code) == -1){
            System.out.println("Not found. Please try again");
        }
        else {
            if(code.size() == 1){
                System.out.println(ptemp.children.get(code.get(0)).getName());
            }
            else if(code.size() == 2){
                System.out.println(ptemp.children.get(code.get(1)).children.get(code.get(0)).getName());
            }
            else if(code.size() == 3){
                System.out.println(ptemp.children.get(code.get(2)).children.get(code.get(1)).children.get(code.get(0)).getName());
            }
            else if(code.size() == 4){
                System.out.println(ptemp.children.get(code.get(3)).children.get(code.get(2)).children.get(code.get(1)).children.get(code.get(0)).getName());
            }
            else if(code.size() == 5){
                System.out.println(ptemp.children.get(code.get(4)).children.get(code.get(3)).children.get(code.get(2)).children.get(code.get(1)).children.get(code.get(0)).getName());
            }
        }


    }
    public static int checkChildren(Person ptemp, String searchTerm, ArrayList<Integer> arr){
        if(ptemp.getName().equalsIgnoreCase(searchTerm)){
            System.out.println(ptemp.getName());
            return 1;
        }
        else{
            for (int i = 0; i < ptemp.children.size(); i++) {
                if(checkChildren(ptemp.children.get(i), searchTerm, arr) > 0){
                    arr.add(i);
                    //print names; make it not a public static int
                    return i;
                }


            }
        }
    }

}
