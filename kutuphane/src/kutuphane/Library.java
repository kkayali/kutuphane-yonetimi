
package kutuphane;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
    }

    
    public void addBook(Book book) {
        books.add(book);
    }

    
    public void addUser(User user) {
        users.add(user);
    }

    
    public void loanBook(User user, Book book, LocalDate borrowDate, LocalDate dueDate) {
        if (book.isAvailable()) {
            Loan loan = new Loan(user, book, borrowDate, dueDate);
            loans.add(loan);
            book.setAvailable(false); 
            System.out.println("Kitap ödünç alındı: " + loan);
        } else {
            System.out.println("Kitap mevcut değil: " + book.getTitle());
        }
    }

    
    public void returnBook(Loan loan) {
        loan.getBook().setAvailable(true);
        loans.remove(loan);
        System.out.println("Kitap iade edildi: " + loan.getBook().getTitle());
    }

    
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
