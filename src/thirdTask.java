import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by LuckyMan on 2/15/2016.
 */
public class thirdTask {

    private String[] ArrOfWords;

    public String[] getArrOfWords() {
        return ArrOfWords;
    }

    public void setArrOfWords(String[] arrOfWords) {
        ArrOfWords = arrOfWords;
    }


//method received array of words
//returns decompound

    public String findWord(String[] a) {

        String s = "";

        for (int i = 0; i < a.length; i++) {

            int position = 0;

            for (int j = 1 + i; j < a.length; j++) {

                if (a[i].contains(a[j])) {

                    if (a[i].indexOf(a[j]) == position) {

                        position = a[i].length();

                        int tmp = a[i].indexOf(a[j]);

                        if (a[i].length() == position + tmp) {
                            s = a[i];
                            break;
                        }

                        j = i + 1;
                    }
                }
            }
        }
        return s;
    }

//sorting array by length of words
    public void sortByLength(String[] a) {

        for (int i = a.length - 1; i >= 0; i--) {
            String minStr = a[i];
            int minInt = i;

            for (int j = i - 1; j >= 0; j--) {
                if (a[j].length() < minStr.length()) {
                    minStr = a[j];
                    minInt = j;
                }
            }
            if (i != minInt) {
                String tmp = a[i];
                a[i] = a[minInt];
                a[minInt] = tmp;
            }
        }

        setArrOfWords(a);
    }

//reading words from scanner,sort it by alphabet and push in array
    public void insert() {

        Scanner numb = new Scanner(System.in);
        System.out.println("Type the number of words: ");
        int quantity = numb.nextInt();

        String[] tmp = new String[quantity];

        Scanner reader = new Scanner(System.in);
        System.out.println("Type the words and press enter: ");

        for (int i = 0; i < quantity; i++) {
            tmp[i] = reader.nextLine();
        }

        Arrays.sort(tmp);

        setArrOfWords(tmp);
    }

    public void start(){
        insert();
        sortByLength(getArrOfWords());
        System.out.println(findWord(getArrOfWords()));
    }
}