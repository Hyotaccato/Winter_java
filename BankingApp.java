package first;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // 생성자
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0; // 초기 잔액은 0
    }

    // 입금 메서드
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    // 출금 메서드
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
        } else if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            System.out.println("출금 금액은 0보다 커야 합니다.");
        }
    }

    // 잔액 조회 메서드
    public double getBalance() {
        return balance;
    }

    // 계좌 정보 조회 메서드
    public String getAccountInfo() {
        return "계좌번호: " + accountNumber + ", 계좌주: " + accountHolder + ", 잔액: " + balance + "원";
    }
}

// 메인 클래스
public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123-456-789", "홍길동");
        
        System.out.println(account.getAccountInfo());
        account.deposit(10000);
        account.withdraw(5000);
        System.out.println("최종 잔액: " + account.getBalance() + "원");
    }
}
