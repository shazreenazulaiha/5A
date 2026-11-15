public class Book {
    private String title, author;
    private Student borrower = null;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    // Setiap pelajar hanya boleh pinjam satu buku, dan hanya ada satu salinan setiap buku
    public boolean borrowBy(Student s) {
        if (borrower != null || s.hasBorrowed()) {
            return false;
        }
        borrower = s;
        s.setBorrowedBook(this);
        return true;
    }

    // untuk combo box: Harry Potter (J K Rowling)
    public String getInfo() { return title + " (" + author + ")"; }

    // untuk senarai: Book title : Harry Potter (Author : J K Rowling)
    public String toString() { return "Book title : " + title + " (Author : " + author + ")"; }
}