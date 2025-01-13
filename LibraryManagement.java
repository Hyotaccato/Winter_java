package day6;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("책이 대출되었습니다: " + title);
        } else {
            System.out.println("책이 대출 중입니다: " + title);
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("책이 반납되었습니다: " + title);
    }

    @Override
    public String toString() {
        return title + " by " + author + (isAvailable ? " (Available)" : " (Not Available)");
    }
}

public class LibraryManagement {
    private ArrayList<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("책이 추가되었습니다: " + title);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.borrow();
                return;
            }
        }
        System.out.println("책을 찾을 수 없습니다: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("책을 찾을 수 없습니다: " + title);
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("선택하세요. (추가하기/목록보기/빌리기/반납하기/나가기): ");
            command = scanner.nextLine();

            switch (command) {
                case "추가하기":
                    System.out.print("책 제목: ");
                    String title = scanner.nextLine();
                    System.out.print("저자: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case "목록보기":
                    library.listBooks();
                    break;
                case "빌리기":
                    System.out.print("대출할 책 제목: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case "반납하기":
                    System.out.print("반납할 책 제목: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case "나가기":
                    System.out.println("도서관 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
