import java.util.LinkedList;
import java.util.Scanner;

public class JosephusProblem {
    
    public static int josephus(int n, int k) {
        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + k - 1) % people.size();
            people.remove(index);
        }

        return people.get(0);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n; // Number of people
        int k; // Every k-th person will be eliminated
        System.out.println("Enter the number of people: ");
        n=sc.nextInt();
        System.out.println("Enter the jumping number: ");
        k=sc.nextInt();
        

        int survivor = josephus(n, k);
        System.out.println("The survivor is person number: " + survivor);
    }
}