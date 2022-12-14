import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
    private User[] globalUserArray;

    //Method to create user
    public User createUser(String userName, String password, String name){
        User user = new User();
        user.setName(name);
        user.setUsername(userName);
        user.setPassword(password);
        return user;
    }
    public User createUser(String[] userData){
        User user = new User();
        user.setName(userData[0]);
        user.setUsername(userData[1]);
        user.setPassword(userData[2]);
        return user;
    }
    public User[] readUsers(String fileName){
        //Here Read the Text File
        BufferedReader fileReader = null;
        User[] array;
        try{
            fileReader = new BufferedReader(new FileReader("data.txt"));
            String line;
            int lines = 0;
            while (fileReader.readLine() != null) lines++;
            fileReader.close();
            fileReader = new BufferedReader(new FileReader("data.txt"));
            array = new User[lines];
            int index = 0;
            while((line = fileReader.readLine()) != null){
                System.out.println(line);
                String[] data = line.split(",");
                User user = null;
                if(data.length>2){
                    user = createUser(data);
                }
                array[index] = user;
                index++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        globalUserArray = array;
        return array;
    }

    public User validateUser(String userName, String password){

        for(int i = 0;i<globalUserArray.length;i++){
            User testUser = globalUserArray[i];
            if(testUser.getUsername().equals(userName) && testUser.getPassword().equals(password)){
                return testUser;
            }
        }

        return null;
    }

//    public boolean validateUser(String userName, String password){
//        boolean isUser = false;
//        indexOfLatestLoggedUser = -1;
//        for(int i = 0;i<globalUserArray.length;i++){
//            User testUser = globalUserArray[i];
//            if(testUser.getUsername().equals(userName) && testUser.getPassword().equals(password)){
//                indexOfLatestLoggedUser = i;
//                return true;
//            }
//        }
//        return false;
//    }


}
