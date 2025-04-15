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
                    System.out.println("\nWhat message would you like to send?");
                    String tempMessage = Library.input.nextLine();
                    allMessages.add(new Message(tempMessage));
                    System.out.println(tempMessage + " successfully sent!");

                } else if (option == 2) {
                    System.out.println("\n\tSecurity Message\tMachine ID \tMachine Type ");
                    for (int i = 0; i < allMessages.size(); i++) {
                        boolean oncecheck = false;

                        for (int j = 0; j < allMessages.get(i).getMessage().length(); j++) {
                            if ((oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '0') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '1') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '2') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '3') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '4') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '5') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '6') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '7') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '8') || (oncecheck == false && allMessages.get(i).getMessage().charAt(j) == '9')) {
                                oncecheck = true;
                                String tempStart = allMessages.get(i).getMessage().substring(0, j);
                                tempStart = tempStart.trim();
                                String tempMiddle = allMessages.get(i).getMessage().substring(j, j + 1);
                                String tempEnd = allMessages.get(i).getMessage().substring(j + 2, allMessages.get(i).getMessage().length());
                                tempEnd = tempEnd.trim();
                                System.out.println(tempStart + "___" + tempMiddle + "___" + tempEnd + ".");
                            }

                        }

                    }

                } else if (option == 3) {

                } else if (option == 4) {
                    break;
                } else {
                    System.out.println("That is not an available option");
                }
                System.out.println("Logging out. Good Bye.");        }//while

        }//main
    public boolean scanWarning(String searchTerm, String searchWord){
            if(searchTerm.length() == 1 && searchTerm.length()){
                return true;
            }
    }
    }//class

