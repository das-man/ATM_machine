import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner s = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();
    boolean login = false;
    double userBalance = 0;

    public void menu() {
        while (login) {
            System.out.println("-------------------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Current Balance");
            System.out.println("4. Exit\n");
            int choice = s.nextInt();

            switch (choice) {
                case 1 -> {deposit();}
                case 2 -> {withdraw();}
                case 3 -> {checkBalance();}
                case 4 -> {exit();}
            }
        }
    }

    public void exit() {
        login = false;
    }

    public void deposit() {
        boolean valid = false;
        System.out.println("-------------------------------");
        System.out.println("How much would you like to deposit?");

        while (!valid) {
            int dAmount = s.nextInt();

            if (dAmount <= 5000 && dAmount > 0) {
                valid = true;
                System.out.println("You have deposited $" + dAmount + " into your account");
                userBalance += dAmount;
                System.out.println("Your current account balance: $" + userBalance);
            } else {
                System.out.println("Please enter amount greater than 0 and less than $5000");
            }
        }
    }

    public void withdraw() {
        boolean valid = false;
        System.out.println("------------------------------");
        System.out.println("How much would you like to withdraw?");

        while (!valid) {
            int wAmount = s.nextInt();

            if (wAmount < userBalance && wAmount > 0) {
                valid = true;
                System.out.println("You have withdrew $" + wAmount + " out of your account");
                userBalance -= wAmount;
                System.out.println("Your current account balance: $" + userBalance);
            } else {
                System.out.println("Please enter an appropriate amount");
            }
        }
    }

    public void checkBalance() {
        System.out.println("-------------------------------");
        System.out.println("Your current account balance: " + userBalance);
    }

    public void addUser(String name, String password, double balance) {
        users.add(new User(name, password, balance));
    }

    public void userData() {
        addUser("leo", "admin", 7000);
        addUser("admin", "password", 20000);
    }

    public void greetings() {
        System.out.println("-------------------------------");
        System.out.println("Welcome to Poor Bank\n");
    }

    public void login() {
        System.out.println("Please enter your username: ");
        String username = s.nextLine();
        System.out.println("Please enter your password: ");
        String password = s.nextLine();

        while (true) {
            // loop through user
            for (User user : users) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Hi, " + username + ". You have successfully logged in!");
                    login = true;
                    userBalance = user.getBalance();
                    return;
                }
            }
            System.out.println("You have entered an invalid username or password");
            username = s.nextLine();
            password = s.nextLine();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.userData();
        main.greetings();
        main.login();
        main.menu();
    }
}