import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Add Book");
            System.out.println("2 Search Book");
            System.out.println("3 Issue Book");
            System.out.println("4 Return Book");
            System.out.println("5 Display Books");
            System.out.println("6 Show Waiting List");
            System.out.println("7 Show Return History");
            System.out.println("8 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    lib.addBook(id, title, author);

                    break;


                case 2:

                    System.out.print("Enter title/author: ");
                    String key = sc.nextLine();

                    lib.searchBook(key);

                    break;


                case 3:

                    System.out.print("Enter title: ");
                    String issueTitle = sc.nextLine();

                    System.out.print("Enter student name: ");
                    String student = sc.nextLine();

                    lib.issueBook(issueTitle, student);

                    break;


                case 4:

                    System.out.print("Enter title: ");
                    String returnTitle = sc.nextLine();

                    lib.returnBook(returnTitle);

                    break;


                case 5:

                    lib.displayBooks();

                    break;


                case 6:

                    lib.showWaitingList();

                    break;


                case 7:

                    lib.showReturnHistory();

                    break;


                case 8:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}