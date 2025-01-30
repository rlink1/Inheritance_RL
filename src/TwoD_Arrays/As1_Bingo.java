package TwoD_Arrays;

import Utilities.Library;

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
}
