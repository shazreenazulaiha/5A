public class Student {
    private String name, matric;
    private Book borrowedBook = null;

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }
    public String getName()   { return name; }
    public String getMatric() { return matric; }
    public boolean hasBorrowed() { return borrowedBook != null; }
    public void setBorrowedBook(Book b) { borrowedBook = b; }

    // untuk combo box: Ali Imran (A123456)
    public String getInfo() { return name + " (" + matric + ")"; }

    // untuk senarai: Name : Ali Imran (A123456)
    public String toString() { return "Name : " + name + " (" + matric + ")"; }
}