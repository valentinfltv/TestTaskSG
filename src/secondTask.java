import java.util.Scanner;

/**
 * Created by LuckyMan on 2/15/2016.
 */
public class secondTask {
//starting integer
    private int number;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

//reading integer
    public void insertNumber(){

        while (true){

            int n = readFromKeyboard() ;
            if (n > 9){
                setNumber(n);
                break;
            }
            else {
                System.out.println("Please, try again");
            }
        }

    }

    public int readFromKeyboard(){

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter at least two-digit number: ");

        return reader.nextInt();
    }
//reverse the integer
    public int reverse(int n){
        int res = 0;
        while(n != 0){
            int last = n % 10;
            res = (res * 10) + last;
            n = n / 10;
        }
        return res;
    }
//finding palindrome
    public int findPalindrome(){
        int res = 0;
        int intMax = 2147483647;
        for (int i = getNumber(); i < intMax; i++) {
            if (i == reverse(i)){
                res = i;
                break;
            }
        }
        return res;
    }
//start search
    public void start(){
        insertNumber();
        int tmp = findPalindrome();
        System.out.println("Palindrome of "+getNumber()+" is "+tmp );
    }

}
