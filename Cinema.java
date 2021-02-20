package cinema;
import java.util.*;
public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of rows:\n");
		int r = sc.nextInt();
		System.out.print("Enter the number of seats in each row:\n");
		int e = sc.nextInt();
		char[][] ch = new char[r+1][e+1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= e; j++) {
				ch[i][j] = 'S';	
			}
		}
		int q = 0;
		int q1 = 0;
		int p = 0;
		int r2 = 0;
		while (true) {
			if(q1 == 0) {
			    System.out.print("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");
				p = sc.nextInt();
			}	
			switch (p) {
				case 1:
					System.out.println("\nCinema:");
					System.out.print(" ");
					for (int i = 1; i <= e; i++) {
						System.out.print(" " + i);
					}	
					System.out.println("");
					for (int i = 1; i <= r; i++) {
						System.out.print(i);
						for (int j = 1; j <= e; j++) {
							System.out.print(" " + ch[i][j]);
						}
						System.out.println("");
					}
					break;
				case 2:
					System.out.print("\nEnter a row number:\n");
					int r1 = sc.nextInt();
					System.out.print("Enter a seat number in that row:\n");
					int e1 = sc.nextInt();
					try {   
						if (ch[r1][e1] == 'B') {
							System.out.println("\nThat ticket has already been purchased!");
							q1 = 1;
						} else {
							ch[r1][e1] = 'B';
							q++;
							q1 = 0;
						}
					} catch (ArrayIndexOutOfBoundsException ec) {
						System.out.println("\nWrong input!");
						q1 = 1;
					}
					if (q1 == 0) {
						System.out.print("\nTicket price: $");
						if (r1 <= 9) {
							if (r1 <= 4) {
								System.out.println("10");
								r2 = r2 + 10;
							} else {
								System.out.println("8");
								r2 = r2 + 8;
							}
						}
					}
					break;
				case 3:
					System.out.println("\nNumber of purchased tickets: " + q);
					System.out.printf("Percentage: %.2f",(100.0 * q) / (r * e));
					System.out.println("%\nCurrent income: $" + r2);
					if (r >= 4) {
						System.out.println("Total income: $" + ((e * 4 * 10) + (e * (r - 4) * 8)));
					} else {
						
						System.out.println("Total income: $" + (r * e * 10));
					}
					break;
				case 0:
					return;
			}
		}
    }
}