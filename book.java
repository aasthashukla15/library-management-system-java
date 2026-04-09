class Book {

    int id;
    String title;
    String author;
    boolean issued;

    Book next;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.next = null;
    }
}