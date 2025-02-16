
package kutuphane;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        
        Book book1 = new Book("Java Programlama", "Yazar A", "Bilgisayar");
        Book book2 = new Book("Veritabanı Yönetimi", "Yazar B", "Teknoloji");
        library.addBook(book1);
        library.addBook(book2);

        
        User user1 = new User("Ali", 1);
        User user2 = new User("Ayşe", 2);
        library.addUser(user1);
        library.addUser(user2);

        
        library.loanBook(user1, book1, LocalDate.now(), LocalDate.now().plusDays(7));

        
        System.out.println("Kitaplar:");
        library.listBooks();
        
       
        Loan loan = new Loan(user1, book1, LocalDate.now(), LocalDate.now().plusDays(7));
        library.returnBook(loan);
    }
}
