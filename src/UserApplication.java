import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

    public static void main(String[] args ){
        UserService userService = new UserService();
        userService.readUsers("data.txt");
        boolean succsesfulLoged = false;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        for(int i = 0;i< 5;i++){
            System.out.println("Enter your email:");
            String userName = myObj.nextLine();
            System.out.println("Enter your password:");
            String password = myObj.nextLine();

            if(userService.validateUser(userName,password)){
                System.out.println("Welcome: "+
                        userService.getGlobalUserArray()[userService.getIndexOfLoggxedUser()].getName());
                i = 5;
                succsesfulLoged = true;
            } else {
                if(i != 4){
                    System.out.println("Invalid login, please try again");
                }
            }
        }
        if(!succsesfulLoged){
            System.out.println("Too many failed login attempts, you are now locked out.");

        }

    }
}
