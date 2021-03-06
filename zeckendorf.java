/*

zeckendorf.java
By: Brian Floss
10/5/16

*/
import java.util.Scanner;
import java.util.*;

public class zeckendorf {
	
	/*calculates 'size' digits of the Fibonacci sequence */
	public static int[] fib_calc(int size) {
		int[] nums = new int[size];
		nums[0] = 1; nums[1] = 1;
		for (int i=2;i<nums.length;i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		return nums;
	}
	
	/*finds the Zeckendorf representation of x */
	public static LinkedList<Integer> solve(int[] b, int x) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		for (int i=b.length-1;i>0;i--) {
			if (b[i] <= x) {
				a.add(b[i]);
				x -= b[i--];
			}
		}
		return a;
	}
	
	/*for writing out the Zeckendorf representation */
	public static void write(LinkedList<Integer> x, int a) {
		System.out.print(a + " = ");
		for (int i=0; i<=x.size()-2; i++) {
			System.out.print(x.get(i)+ " + ");
		}
		System.out.println(x.getLast());
	}
	
	/* reads in an integer then writes out N number of Zeckendorf representations */
	public static void main(String[] args) {
		int[] fib_numbers = fib_calc(20);
		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();
		for (int i=0;i<lines;i++) {
			int n = in.nextInt();
			LinkedList<Integer> solution = solve(fib_numbers, n);
			write(solution, n);
		}
		in.close();
	}
}
