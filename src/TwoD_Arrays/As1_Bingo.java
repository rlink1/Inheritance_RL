package TwoD_Arrays;

import Utilities.Library;

import java.util.ArrayList;

public class As1_Bingo {
    public static  void run() {
        char[] titles = {'B', 'I', 'N', 'G', 'O'};
        int[][] card = {
                generateArray(5,1,15),
                generateArray(5,16,30),
                generateArray(5, 31, 45),
                generateArray(5, 46, 60),
                generateArray(5, 61, 75)

        };

        for (int row = 0; row < 5; row++) {
            System.out.print(titles[row] + " ");
            for (int col = 0; col < 5; col++) {

                System.out.print(card[row][col] + "  ");
            }
            System.out.println();
        }

        while (true){
            String tempent = "mama";
            tempent = Library.input.nextLine();
            if(tempent.equals("")){
                int temprow = -1;
                int temprand = Library.myRandom(1,75);
                System.out.println("The random number is " + temprand);
                for (int row = 0; row < card.length; row++) {
                    for (int col = 0; col < card[row].length; col++) {
                        if (card[row][col] == temprand) {
                            System.out.println("Found!");
                            temprow = row;
                            card[row][col] *= -1;

                        }
                    }

                }
                if (temprow < 0) {
                    System.out.println("Not found!");
                }
                else{
                    for (int row = 0; row < 5; row++) {
                        System.out.print(titles[row] + " ");
                        for (int col = 0; col < 5; col++) {

                            System.out.print(card[row][col] + "  ");
                        }
                        System.out.println();
                    }
                }

            }
            if(isWinner(card)){
                break;
            }

        }
        System.out.println("BINGO!");

    }

    public static int[] generateArray(int length, int min, int max){
        int[] tempArray = new int[length];
        while(true){
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = Library.myRandom(min,max);

            }
            for (int i = 0; i < tempArray.length; i++) {
                for (int j = 0; j < tempArray.length ; j++) {
                    if((tempArray[i] == tempArray[j]) && i!=j){
                    }
                    else{
                        return tempArray;
                    }
                }
            }
        }
    }

    public static boolean isWinner(int[][] arr){
        for (int row = 0; row < arr.length; row++) {
            if(arr[row][0] < 0 && arr[row][1] < 0 && arr[row][2] < 0 && arr[row][3] < 0 && arr[row][4] < 0){
                return true;
            }
            else if(arr[0][row] < 0 && arr[1][row] < 0 && arr[2][row] < 0 && arr[3][row] < 0 && arr[4][row] < 0){
                return true;
            } else if (arr[0][0] < 0 && arr[1][1] < 0 && arr[2][2] < 0 && arr[3][3] < 0 && arr[4][4] < 0) {
                return true;
            } else if (arr[4][0] < 0 && arr[3][1] < 0 && arr[2][2] < 0 && arr[1][3] < 0 && arr[0][4] < 0) {
            return true;
        }
        }
        return false;
    }
}
