import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    private boolean borrowed;

    public Book(String title) {
        this.title = title;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book '" + title + "' borrowed.");
        } else {
            System.out.println("Book '" + title + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book '" + title + "' returned.");
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;
    private boolean borrowed;

    public DVD(String title) {
        this.title = title;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD '" + title + "' borrowed.");
        } else {
            System.out.println("DVD '" + title + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD '" + title + "' returned.");
        } else {
            System.out.println("DVD '" + title + "' was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

abstract class LibraryUser {
    abstract void printItemsBorrowed();
    void borrowItem(LibraryItem item, String itemName) {
        item.borrowItem();
        System.out.println(itemName + " borrowed by " + getClass().getSimpleName() + ".");
    }
    void returnItem(LibraryItem item, String itemName) {
        item.returnItem();
        System.out.println(itemName + " returned by " + getClass().getSimpleName() + ".");
    }
}

class Student extends LibraryUser {
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Student(String string) {
        //TODO Auto-generated constructor stub
    }

    public Student() {
        //TODO Auto-generated constructor stub
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Student: Nick Van");
        System.out.println("Borrowed items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.getTitle());
        }
    }

    @Override
    void borrowItem(LibraryItem item, String itemName) {
        super.borrowItem(item, itemName);
        borrowedItems.add(item);
    }

    @Override
    void returnItem(LibraryItem item, String itemName) {
        super.returnItem(item, itemName);
        borrowedItems.remove(item);
    }
}

class Teacher extends LibraryUser {
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Teacher(String string) {
        //TODO Auto-generated constructor stub
    }

    public Teacher() {
        //TODO Auto-generated constructor stub
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Teacher: Kian Porras");
        System.out.println("Borrowed items:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.getTitle());
        }
    }

    @Override
    void borrowItem(LibraryItem item, String itemName) {
        super.borrowItem(item, itemName);
        borrowedItems.add(item);
    }

    @Override
    void returnItem(LibraryItem item, String itemName) {
        super.returnItem(item, itemName);
        borrowedItems.remove(item);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Haaland: The incredible story behind the worlds greatest striker");
        DVD dvd1 = new DVD("The IT Crowd");

        Student student = new Student();
        Teacher teacher = new Teacher();

        student.borrowItem(book1, "Book");
        teacher.borrowItem(dvd1, "DVD");

        student.printItemsBorrowed();
        teacher.printItemsBorrowed();
    }
}
