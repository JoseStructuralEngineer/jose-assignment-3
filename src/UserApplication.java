import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

    public static void main(String[] args ){
        UserService userService = new UserService();

        //User Service is Instantiated and this contains the logged in data
        //It also allows to validate data
        userService.readUsers("data.txt");

        boolean successfulLogged = false;

        Scanner myObj = new Scanner(System.in);
        // Create a Scanner object
        int logInAttempts = 0;

        while(logInAttempts<5){
            System.out.println("Enter your email:");
            String userName = myObj.nextLine();

            System.out.println("Enter your password:");
            String password = myObj.nextLine();
            User logedInUser = userService.validateUser(userName,password);

            if(logedInUser != null){
                System.out.println("Welcome: "+
                        logedInUser.getName());

                successfulLogged = true;

            } else {
                if(logInAttempts != 4){
                    System.out.println("Invalid login, please try again");
                }
                logInAttempts = logInAttempts +1;
            }
        }
        if(!successfulLogged){
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

    }
}
