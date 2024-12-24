import java.util.Scanner;

//Palindrome of number entered
class test2{
    static int revNumb(int n){
        int revn=0;
        while(n>0){
            revn=revn*10+n%10;
            n=n/10;
        }
        return revn;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        int revn;
        System.out.println("Enter the number for palindrome: ");
        n=sc.nextInt();
        revn=revNumb(n);
        if(n==revn){
            System.out.println("Entered number is a palindrome");
        }
        else{
            System.out.println("Entered number is not palindrome");
        }
        sc.close();
    }
}
