package Ex3_MusicFestival;

import Utilities.Library;

import java.util.ArrayList;

public class Ex3_Main {
    public static void run() {
        ArrayList<Event> allEvents = new ArrayList<>();
        double availableSpace = 1000;

        allEvents.add(new MainStageEvent("Hemples Temple", "Band"));
        ((MainStageEvent) allEvents.get(0)).techRequirements.add("Speakers");
        ((MainStageEvent) allEvents.get(0)).techRequirements.add("Cables");
        ((MainStageEvent) allEvents.get(0)).techRequirements.add("Lighting Technician");
        ((MainStageEvent) allEvents.get(0)).techRequirements.add("Microphones");
        allEvents.add(new MainStageEvent("Kazzoo Boy", "Indie Artist"));
        ((MainStageEvent) allEvents.get(1)).techRequirements.add("Kazzoo (if not provided)");
        ((MainStageEvent) allEvents.get(1)).techRequirements.add("Backup Security");
        allEvents.add(new MainStageEvent("The Strathcona Jazz Band", "Jazz Music"));
        ((MainStageEvent) allEvents.get(2)).techRequirements.add("Speakers");
        ((MainStageEvent) allEvents.get(2)).techRequirements.add("Mufflers");
        ((MainStageEvent) allEvents.get(2)).techRequirements.add("Microphones");
        allEvents.add(new MainStageEvent("The Comp Sci Trio", "Beat Saber + Glowstick wave"));
        ((MainStageEvent) allEvents.get(3)).techRequirements.add("Projector");
        ((MainStageEvent) allEvents.get(3)).techRequirements.add("Cables");
        ((MainStageEvent) allEvents.get(3)).techRequirements.add("Glowsticks");
        allEvents.add(new MainStageEvent("Disney Symphony", "Music"));
        ((MainStageEvent) allEvents.get(4)).techRequirements.add("Chairs");
        ((MainStageEvent) allEvents.get(4)).techRequirements.add("Microphones");
        ((MainStageEvent) allEvents.get(4)).techRequirements.add("Mufflers");
        allEvents.add(new NonMusicEvent("The Two Week Championships", "Fortnite Championship", "The Rec Centre"));
        ((NonMusicEvent) allEvents.get(5)).setRent(200.00);
        allEvents.add(new NonMusicEvent("Feedy Eaters", "Food Competition", "McDonalds"));
        ((NonMusicEvent) allEvents.get(6)).setRent(250.00);
        allEvents.add(new NonMusicSub("Slappies!", "Slap Battle", "Right Field", 50.0));
        allEvents.add(new NonMusicSub("Bounce Funtime", "Bouncy Castle", "Left Field", 150.50));
        allEvents.add(new NonMusicSub("The Sun Setters", "Staring at the sun for fun", "The Park", 50.0));
        allEvents.add(new SmallStage("Bongo Boys", "Music", "11:30AM"));
        ((SmallStage) allEvents.get(10)).addLocation("Small Stage #1");
        allEvents.add(new SmallStage("Trampoline Flipists", "Performance", "12:00PM"));
        ((SmallStage) allEvents.get(11)).addLocation("SouthWest Field Central");
        allEvents.add(new SmallStage("Hackie Sackie", "Potato Sack Race", "12:30PM"));
        ((SmallStage) allEvents.get(12)).addLocation("NorthEast Stage");
        ((SmallStage) allEvents.get(12)).addLocation("Sprinkle Stadium");
        allEvents.add(new SmallStage("Joyful Smilers", "Smiling Competition", "1:00PM"));
        ((SmallStage) allEvents.get(13)).addLocation("SouthEast Centre Stage");
        allEvents.add(new SmallStage("Folkfest Got Talent", "Talent Show", "1:30PM"));
        ((SmallStage) allEvents.get(14)).addLocation("Cineplex");
        ((SmallStage) allEvents.get(14)).addLocation("Southgate Cinema");


        System.out.println("Welcome to Folkfest!!");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Make new event");
            System.out.println("2.  Search for event");
            System.out.println("3.  Filter by event type");
            System.out.println("4.  Print all Events Grouped by Type");
            System.out.println("5.  Add Main Stage Tech");
            System.out.println("6.  Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {
                System.out.println("Which type of event would you like to add? Your choices are of the following:\nMainStageEvent\nNonMusicEvent\nNonMusicSub\nSmallStage");
                String cho = Library.input.nextLine();
                if (cho.equalsIgnoreCase("MainStageEvent")) {
                    System.out.println("\nAdding: Main Stage Event");
                    System.out.println("\nWhat the name of this event?");
                    String tempname = Library.input.nextLine();
                    System.out.println("\nWhat is the type of this event?");
                    String temptype = Library.input.nextLine();
                    allEvents.add(new MainStageEvent(tempname, temptype));
                    System.out.println("Does your event have any technical requirements?");
                    String tempCho = Library.input.nextLine();
                    if (tempCho.startsWith("y")) {
                        System.out.println("How many technical requirements does " + tempname + " need?");
                        int tempLoop = Library.input.nextInt();
                        Library.input.nextLine();
                        for (int i = 0; i < tempLoop; i++) {
                            System.out.println("Requirement number " + i+1 + ", please input.");
                            String tempIns = Library.input.nextLine();
                            for (int j = 0; j < allEvents.size(); j++) {
                                if (j == allEvents.size() - 1) {
                                    ((MainStageEvent) allEvents.get(j)).addTech(tempIns);
                                }
                            }
                        }
                    }

                } else if (cho.equalsIgnoreCase("NonMusicEvent")) {
                    System.out.println("Adding: Non Music Event");
                    System.out.println("\nWhat the name of this event?");
                    String tempname = Library.input.nextLine();
                    System.out.println("\nWhat is the type of this event?");
                    String temptype = Library.input.nextLine();
                    String temploc = "m";

                    double randRent = Library.myRandom(10, 200);
                    System.out.println("We are planning to charge you " + randRent + "$/hr. Does this work with you?");
                    String deci = Library.input.nextLine();
                    if(deci.startsWith("y")){
                        boolean mama = true;
                        while (mama) {
                            System.out.println("\nWhere are you planning to have this event?");
                            boolean repeat = false;
                            temploc = Library.input.nextLine();
                            for (int i = 0; i < allEvents.size(); i++) {
                                if (allEvents.get(i) instanceof NonMusicEvent) {
                                    if (temploc.equalsIgnoreCase(((NonMusicEvent) allEvents.get(i)).getLoc())) {
                                        repeat = true;
                                    }
                                }
                            }
                            if (repeat) {
                                System.out.println("There is already an event here, please try another location");
                            } else {
                                mama = false;
                            }
                        }
                        allEvents.add(new NonMusicEvent(tempname, temptype, temploc));
                        ((NonMusicEvent) allEvents.get(allEvents.size()-1)).setRent(randRent);
                    }
                    else{
                        System.out.println("Sorry, but we can't have you at folk fest this year. Please come back with a different event in mind.");
                    }



                } else if (cho.equalsIgnoreCase("NonMusicSub")) {
                    System.out.println("Adding: Non Music Sub Event");
                    System.out.println("\nWhat the name of this event?");
                    String tempname = Library.input.nextLine();
                    System.out.println("\nWhat is the type of this event?");
                    String temptype = Library.input.nextLine();
                    System.out.println("How much space does this event take up?");
                    double tempSpace = Library.input.nextInt();
                    Library.input.nextLine();
                    String temploc = "m";
                    boolean mama = true;
                    while (mama) {
                        System.out.println("\nWhere are you planning to have this event?");
                        boolean repeat = false;
                        temploc = Library.input.nextLine();
                        int tempInt = -1;
                        for (int i = 0; i < allEvents.size(); i++) {
                            if(allEvents.get(i) instanceof SmallStage){
                                tempInt = ((SmallStage) allEvents.get(i)).getAmIndex();
                            }
                            if (allEvents.get(i) instanceof NonMusicEvent) {
                                if (temploc.equalsIgnoreCase(((NonMusicEvent) allEvents.get(i)).getLoc())) {
                                    repeat = true;
                                }
                            }
                            for (int k = 0; k < tempInt + 1; k++) {
                                if(allEvents.get(i) instanceof SmallStage){
                                    if(temploc.equalsIgnoreCase(((SmallStage)allEvents.get(i)).getMultLocation(k))){
                                        repeat = true;
                                    }
                                }

                            }
                        }
                        if (repeat) {
                            System.out.println("There is already an event here, please try another location");
                        } else {
                            mama = false;
                        }
                    }
                    allEvents.add(new NonMusicSub(tempname, temptype, temploc, tempSpace));
                    for (int i = 0; i < allEvents.size(); i++) {
                        if (allEvents.get(i) instanceof NonMusicSub) {
                            if (((NonMusicSub) allEvents.get(i)).checkSpace(1000) < 0) {
                                System.out.println("No available space. Removing " + tempname);
                                allEvents.remove(allEvents.size() - 1);
                                break;
                            } else {
                                System.out.println("Event Fits! Remaining space: " + ((NonMusicSub) allEvents.get(i)).checkSpace(1000));
                            }

                        }

                    }


                } else if (cho.equalsIgnoreCase("SmallStage")) {
                    System.out.println("Adding: Small Stage Event");
                    System.out.println("\nWhat the name of this event?");
                    String tempname = Library.input.nextLine();
                    System.out.println("\nWhat is the type of this event?");
                    String temptype = Library.input.nextLine();
                    System.out.println("\nWhat time does this event start? ((hr):(min)AM/PM)");
                    String tempTime = Library.input.nextLine();

                    allEvents.add(new SmallStage(tempname, temptype, tempTime));
                    String temploc = "m";
                    boolean mama = true;
                    while (mama) {
                        System.out.println("\nHow many locations will this event have at this time?");
                        int rep = Library.input.nextInt();
                        Library.input.nextLine();
                        if (rep > 0) {


                            for (int i = 0; i < rep; i++) {
                                System.out.println("\nWhere are you planning to have this event?");
                                boolean repeat = false;
                                temploc = Library.input.nextLine();
                                int tempInt = -1;

                                for (int j = 0; j < allEvents.size(); j++) {
                                    if(allEvents.get(j) instanceof SmallStage){
                                        tempInt = ((SmallStage) allEvents.get(j)).getAmIndex();
                                    }
                                    if (allEvents.get(j) instanceof NonMusicEvent) {

                                        if (temploc.equalsIgnoreCase(((NonMusicEvent) allEvents.get(j)).getLoc())) {
                                            repeat = true;
                                        }

                                    }
                                    for (int k = 0; k < tempInt + 1; k++) {
                                        if(allEvents.get(j) instanceof SmallStage){
                                            if(temploc.equalsIgnoreCase(((SmallStage)allEvents.get(j)).getMultLocation(k))){
                                                repeat = true;
                                            }
                                        }

                                    }
                                }
                                if (repeat) {
                                    System.out.println("There is already an event here, please try another location");
                                    rep = rep + 1;
                                } else {
                                    mama = false;
                                }
                                ((SmallStage) allEvents.get(allEvents.size() - 1)).addLocation(temploc);
                            }

                        } else {
                            System.out.println("Well... you need a location for your event pal.");
                        }


                    }


                } else {
                    System.out.println("Invalid event choice, please try again.");
                }

            } else if (choice == 2) {
                System.out.println("\nSearch For Event");
                System.out.println("\nWhat event are you looking for?");
                String searchTerm = Library.input.nextLine();
                int foundIndex = -1;
                int eventType = -1;
                for (int i = 0; i < allEvents.size(); i++) {
                    if (allEvents.get(i) instanceof MainStageEvent) {
                        if(allEvents.get(i).getEventName().equalsIgnoreCase(searchTerm) ){
                            foundIndex = i;
                            eventType = 1;
                            break;
                        }
                    } else if (allEvents.get(i) instanceof NonMusicSub) {
                        if(allEvents.get(i).getEventName().equalsIgnoreCase(searchTerm)){
                            foundIndex = i;
                            eventType = 3;
                            break;
                        }


                    }else if (allEvents.get(i) instanceof NonMusicEvent) {
                        if (allEvents.get(i).getEventName().equalsIgnoreCase(searchTerm)){
                            foundIndex = i;
                            eventType = 2;
                            break;
                        }


                    }  else if (allEvents.get(i) instanceof SmallStage) {
                        if(allEvents.get(i).getEventName().equalsIgnoreCase(searchTerm)){
                            foundIndex = i;
                            eventType = 4;
                            break;
                        }

                    }
                }
                if(foundIndex > -1){
                    if(eventType == 1){
                        System.out.println("Found Main Stage Event " + allEvents.get(foundIndex).getEventName());
                        System.out.println("\nDetails:\n" );
                        System.out.println("Event ID: " + allEvents.get(foundIndex).getEventID());
                        System.out.println("Type: " + allEvents.get(foundIndex).getEventType());
                        System.out.println("Location: " + allEvents.get(foundIndex).getLocation());
                        ((MainStageEvent) allEvents.get(foundIndex)).printTech();


                    }else if(eventType == 2){
                        System.out.println("Found Non Music Event " + allEvents.get(foundIndex).getEventName());
                        System.out.println("\nDetails:\n" );
                        System.out.println("Event ID: " + allEvents.get(foundIndex).getEventID());
                        System.out.println("Type: " + allEvents.get(foundIndex).getEventType());
                        System.out.println("Location: " + allEvents.get(foundIndex).getLocation());
                        System.out.println("Rent: " + ((NonMusicEvent) allEvents.get(foundIndex)).getRent());



                    }else if(eventType == 3){
                        System.out.println("Found Non Music Sub Event " + allEvents.get(foundIndex).getEventName());
                        System.out.println("\nDetails:\n" );
                        System.out.println("Event ID: " + allEvents.get(foundIndex).getEventID());
                        System.out.println("Type: " + allEvents.get(foundIndex).getEventType());
                        System.out.println("Space Taken up: " + ((NonMusicSub)allEvents.get(foundIndex)).returnSpace());



                    }else if(eventType == 4){
                        System.out.println("Found Small Stage Event " + allEvents.get(foundIndex).getEventName());
                        System.out.println("\nDetails:\n" );
                        System.out.println("Event ID: " + allEvents.get(foundIndex).getEventID());
                        System.out.println("Type: " + allEvents.get(foundIndex).getEventType());
                        System.out.println("Time: " + allEvents.get(foundIndex).getTime());
                        ((SmallStage) allEvents.get(foundIndex)).printLocation();

                    }


                }else{
                    System.out.println("Event not found. Please try again.");
                }


            } else if (choice == 3) {
                System.out.println("Filter by event type");
                ArrayList<Event> allMainEvents = new ArrayList<>();
                ArrayList<Event> allNonMusicEvents = new ArrayList<>();
                ArrayList<Event> allNonMusicSubs = new ArrayList<>();
                ArrayList<Event> allSmallEvents = new ArrayList<>();

                for (int i = 0; i < allEvents.size(); i++) {
                    if(allEvents.get(i) instanceof MainStageEvent){
                        allMainEvents.add(allEvents.get(i));

                    }else if(allEvents.get(i) instanceof NonMusicSub){
                        allNonMusicSubs.add(allEvents.get(i));

                    }
                    else if(allEvents.get(i) instanceof NonMusicEvent){
                        allNonMusicEvents.add(allEvents.get(i));
                    }
                    else if(allEvents.get(i) instanceof SmallStage){
                        allSmallEvents.add(allEvents.get(i));

                    }
                }
                System.out.println("Which event type would you like to filter by? Your choices are of the following:\nMainStageEvent\nNonMusicEvent\nNonMusicSub\nSmallStage");
                String type = Library.input.nextLine();

                if(type.equalsIgnoreCase("NonMusicEvent")){
                    System.out.println("\n        - NONMUSIC EVENTS - \n");

                    for (int i = 0; i < allNonMusicEvents.size(); i++) {
                        System.out.println(allNonMusicEvents.get(i).getEventName());
                        System.out.println("Event ID: " + allNonMusicEvents.get(i).getEventID());
                        System.out.println("Type: " + allNonMusicEvents.get(i).getEventType());
                        System.out.println("Location: " + allNonMusicEvents.get(i).getLocation());
                        System.out.println("Rent: " + ((NonMusicEvent) allNonMusicEvents.get(i)).getRent());
                        System.out.println();
                    }
                }
                else if(type.equalsIgnoreCase("NonMusicSub")){
                    System.out.println("\n        - NONMUSIC SUB EVENTS - \n");
                    for (int i = 0; i < allNonMusicSubs.size(); i++) {
                        System.out.println( allNonMusicSubs.get(i).getEventName());
                        System.out.println("Event ID: " + allNonMusicSubs.get(i).getEventID());
                        System.out.println("Type: " + allNonMusicSubs.get(i).getEventType());
                        System.out.println("Space Taken up: " + ((NonMusicSub)allNonMusicSubs.get(i)).returnSpace());
                        System.out.println();
                    }
                }
                else if(type.equalsIgnoreCase("MainStageEvent")){
                    System.out.println("\n        - MAIN EVENTS - \n");
                    for (int i = 0; i < allMainEvents.size(); i++) {
                        System.out.println(allMainEvents.get(i).getEventName());
                        System.out.println("Event ID: " + allMainEvents.get(i).getEventID());
                        System.out.println("Type: " + allMainEvents.get(i).getEventType());
                        System.out.println("Location: " + allMainEvents.get(i).getLocation());
                        ((MainStageEvent) allMainEvents.get(i)).printTech();
                        System.out.println();
                    }

                }else if(type.equalsIgnoreCase("SmallStage")){
                    System.out.println("\n        - SMALL STAGE EVENTS - \n");
                    for (int i = 0; i < allSmallEvents.size(); i++) {
                        System.out.println(allSmallEvents.get(i).getEventName());
                        System.out.println("Event ID: " + allSmallEvents.get(i).getEventID());
                        System.out.println("Type: " + allSmallEvents.get(i).getEventType());
                        System.out.println("Time: " + allSmallEvents.get(i).getTime());
                        ((SmallStage) allSmallEvents.get(i)).printLocation();
                        System.out.println();
                }


                }

            } else if (choice == 4) {
                System.out.println("Print All Events Grouped by Type");
                ArrayList<Event> allMainEvents = new ArrayList<>();
                ArrayList<Event> allNonMusicEvents = new ArrayList<>();
                ArrayList<Event> allNonMusicSubs = new ArrayList<>();
                ArrayList<Event> allSmallEvents = new ArrayList<>();

                for (int i = 0; i < allEvents.size(); i++) {
                    if(allEvents.get(i) instanceof MainStageEvent){
                        allMainEvents.add(allEvents.get(i));

                    }else if(allEvents.get(i) instanceof NonMusicSub){
                        allNonMusicSubs.add(allEvents.get(i));

                    }
                    else if(allEvents.get(i) instanceof NonMusicEvent){
                        allNonMusicEvents.add(allEvents.get(i));
                    }
                    else if(allEvents.get(i) instanceof SmallStage){
                        allSmallEvents.add(allEvents.get(i));

                    }
                }
                System.out.println("\n        - NONMUSIC EVENTS - \n");

                for (int i = 0; i < allNonMusicEvents.size(); i++) {
                    System.out.println(allNonMusicEvents.get(i).getEventName());
                    System.out.println("Event ID: " + allNonMusicEvents.get(i).getEventID());
                    System.out.println("Type: " + allNonMusicEvents.get(i).getEventType());
                    System.out.println("Location: " + allNonMusicEvents.get(i).getLocation());
                    System.out.println("Rent: " + ((NonMusicEvent) allNonMusicEvents.get(i)).getRent());
                    System.out.println();
                }
                System.out.println("\n        - NONMUSIC SUB EVENTS - \n");
                for (int i = 0; i < allNonMusicSubs.size(); i++) {
                    System.out.println( allNonMusicSubs.get(i).getEventName());
                    System.out.println("Event ID: " + allNonMusicSubs.get(i).getEventID());
                    System.out.println("Type: " + allNonMusicSubs.get(i).getEventType());
                    System.out.println("Space Taken up: " + ((NonMusicSub)allNonMusicSubs.get(i)).returnSpace());
                    System.out.println();
                }
                System.out.println("\n        - MAIN EVENTS - \n");
                for (int i = 0; i < allMainEvents.size(); i++) {
                    System.out.println(allMainEvents.get(i).getEventName());
                    System.out.println("Event ID: " + allMainEvents.get(i).getEventID());
                    System.out.println("Type: " + allMainEvents.get(i).getEventType());
                    System.out.println("Location: " + allMainEvents.get(i).getLocation());
                    ((MainStageEvent) allMainEvents.get(i)).printTech();
                    System.out.println();
                }
                System.out.println("\n        - SMALL EVENTS - \n");
                for (int i = 0; i < allSmallEvents.size(); i++) {
                    System.out.println(allSmallEvents.get(i).getEventName());
                    System.out.println("Event ID: " + allSmallEvents.get(i).getEventID());
                    System.out.println("Type: " + allSmallEvents.get(i).getEventType());
                    System.out.println("Time: " + allSmallEvents.get(i).getTime());
                    ((SmallStage) allSmallEvents.get(i)).printLocation();
                    System.out.println();
                }
            } else if(choice == 5){
                System.out.println("Add Main Stage Tech");
                System.out.println("\nWhat event would you like to add tech to?");
                String tempEvent = Library.input.nextLine();
                Boolean tick = true;
                for (int i = 0; i < allEvents.size() -1; i++) {
                    if(allEvents.get(i) instanceof MainStageEvent){
                        if(tempEvent.equalsIgnoreCase(allEvents.get(i).getEventName())){
                            tick = false;
                            System.out.println("Adding Tech to " + allEvents.get(i).getEventName());
                            System.out.println("What would you like to add?");
                            String tempadd = Library.input.nextLine();
                            ((MainStageEvent) allEvents.get(i)).addTech(tempadd);
                        }
                    }
                }
                if(tick){
                    System.out.println("No MAIN STAGE EVENT tech was added, please add one if you do so desire.");
                }
            }
            else if(choice == 6){
                    break;
                }
        } // while
        System.out.println("There is no folk folking like there is in folkfests folks  \nGood bye.");


    }

}
