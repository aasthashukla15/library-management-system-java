import java.util.*;

class Library {

    Book head = null;

    Queue<String> waitingList = new LinkedList<>();

    Stack<String> returnHistory = new Stack<>();


    void addBook(int id, String title, String author) {

        Book newBook = new Book(id, title, author);

        if (head == null) {
            head = newBook;
        } else {

            Book temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newBook;
        }

        System.out.println("Book added successfully");
    }


    void displayBooks() {

        Book temp = head;

        if (temp == null) {
            System.out.println("No books in library");
            return;
        }

        while (temp != null) {

            if (!temp.issued) {
                System.out.println(temp.id + " " + temp.title + " by " + temp.author);
            }

            temp = temp.next;
        }
    }


    void searchBook(String key) {

        Book temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key)) {

                System.out.println("Book Found: " + temp.title + " by " + temp.author);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }


    void issueBook(String title, String student) {

        Book temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                if (!temp.issued) {

                    temp.issued = true;
                    System.out.println("Book issued to " + student);

                } else {

                    waitingList.add(student);
                    System.out.println("Book already issued. Added to waiting list.");
                }

                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }


    void returnBook(String title) {

        Book temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                temp.issued = false;

                returnHistory.push(title);

                System.out.println("Book returned");

                if (!waitingList.isEmpty()) {

                    String nextStudent = waitingList.poll();

                    temp.issued = true;

                    System.out.println("Book issued to next waiting student: " + nextStudent);
                }

                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found");
    }


    void showWaitingList() {

        if (waitingList.isEmpty()) {
            System.out.println("No students in waiting list");
        } else {

            System.out.println("Waiting List:");

            for (String student : waitingList) {
                System.out.println(student);
            }
        }
    }


    void showReturnHistory() {

        if (returnHistory.isEmpty()) {
            System.out.println("No return history");
        } else {

            System.out.println("Return History:");

            for (String book : returnHistory) {
                System.out.println(book);
            }
        }
    }
}