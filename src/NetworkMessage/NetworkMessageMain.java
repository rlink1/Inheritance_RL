package NetworkMessage;
import Utilities.Library;

import java.util.ArrayList;

public class NetworkMessageMain {
        public static void run() {
            ArrayList <Message> allMessages = new ArrayList();
            allMessages.add(new Message("Client3: repeated login failure"));
            allMessages.add(new Message("Client2:filed password reset on file"));
            allMessages.add(new Message("Server1: file not found"));
            allMessages.add(new Message("Server3: ping not returned"));
            allMessages.add(new Message("Server1:write file error on disk DSK1       "));
            allMessages.add(new Message("Server2:disk failure on DSK2"));
            allMessages.add(new Message("Server2:diskette diskette"));
            allMessages.add(new Message("Client3:    diskette disk"));
            allMessages.add(new Message("Router1: missing packet"));
            allMessages.add(new Message("PC4: power surge detected"));


            System.out.println("Assign 1 Network Messages");

            while (true) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1. Add Message");
                System.out.println("2. Print All Messages");
                System.out.println("3. Scan for Error Messages");
                System.out.println("4. EXIT");
                int option = Library.input.nextInt();
                Library.input.nextLine();
                System.out.println();

                if (option == 1) {
                    System.out.println("\nWhat message would you like to send?\nPlease follow the format: Machine Type, MachineID followed by a ':' (required), Security Message");
                    String tempMessage = Library.input.nextLine();
                    if(tempMessage.contains(":")){
                        allMessages.add(new Message(tempMessage));
                        System.out.println(tempMessage + " successfully sent!");
                    }
                    else{
                        System.out.println("Not added, please follow the format.");
                    }


                } else if (option == 2) {
                    System.out.println("\nMachine ID\tMachine Type\tSecurity Message");
                    for (int i = 0; i < allMessages.size(); i++) {
                        boolean oncecheck = false;

                        for (int j = 0; j < allMessages.get(i).getMessage().length(); j++) {
                            if ((oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '0') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '1') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '2') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '3') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '4') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '5') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '6') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '7') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '8') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '9')) {
                                oncecheck = true;
                                String tempStart = allMessages.get(i).getMessage().substring(0, j);
                                tempStart = tempStart.trim();
                                String tempMiddle = allMessages.get(i).getMessage().substring(j, j + 1);
                                String tempEnd = allMessages.get(i).getMessage().substring(j + 2);
                                tempEnd = tempEnd.trim();
                                System.out.println(tempStart + "___" + tempMiddle + "___" + tempEnd + ".");
                            }

                        }

                    }

                } else if (option == 3) {
                    System.out.println("What kind of warning are you looking for? (CASE SENSITIVE)");
                    String searchTerm = Library.input.nextLine();
                    boolean temp = false;
                    for (int i = 0; i < allMessages.size(); i++) {
                        if(scanWarning(searchTerm, allMessages.get(i).getMessage())){
                            temp = true;

                            System.out.println(allMessages.get(i).getMessage());
                        }
                    }
                    if(temp){
                        System.out.println("\nThe messages above fit the search criteria.");
                    }
                    else {
                        System.out.println("None found, please try again.");
                    }
                } else if (option == 4) {
                    System.out.println("Logging out. Good Bye.");
                    break;
                } else {
                    System.out.println("That is not an available option");
                }
                       }//while


        }//main
    public static boolean scanWarning(String searchTerm, String searchWord){
        String message = "a";
        for (int i = 0; i < searchWord.length(); i++) {
            if(searchWord.charAt(i) == ':'){
                message = searchWord.substring(i +1 );
            }
        }
        if(message.equals("a")){
            return false;
        }
        else{
            if(message.contains(searchTerm)){
                if(message.equals(searchTerm)){
//                    System.out.println("equals to");
                    return true;
                }
                else if(message.startsWith(searchTerm) && message.charAt(searchTerm.length()) == ' '){
//                    System.out.println("start");
                    return true;
                }
                else if(message.endsWith(searchTerm) && message.charAt(message.length() - (searchTerm.length()) - 1 ) == ' '){
//                    System.out.println("end");
                    return true;
                }
                else if(message.indexOf(searchTerm) > 0 && message.indexOf(searchTerm) < message.length()  - searchTerm.length()){
                    String tempcheck = message.substring(message.indexOf(searchTerm) -1, message.indexOf(searchTerm) + searchTerm.length() + 1);
                    if(tempcheck.startsWith(" ") && tempcheck.endsWith(" ")){
//                        System.out.println("inbetween");
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }
    }//class

