
package AccountManagement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;





//contains method for genrating a random ID
 class RandIDGenerator {
    private StringBuilder str;
    private int itemCount;
    private String alphaNumeric;

    public RandIDGenerator() {
        str = new StringBuilder();
        itemCount = 0;
        alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }

    public void generateRandID() {
        Random rand = new Random();
        for (int i = 0; i < itemCount; i++) {
            str.append(alphaNumeric.charAt(rand.nextInt(alphaNumeric.length())));
        }
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getRandID() {
        return str.toString();
    }
 }



public class UserSettings extends Customer{
    
 
    private ArrayList <Customer> list= new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);
    Customer u=new Customer();

    //keeps track of user's trip history
    private ArrayList<String> tripsHistory=new ArrayList<>();
    
    
    

    
    
    //create an account 
    public void create_acc() throws IOException{
        
        System.out.println("\n");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println("");
        System.out.println("Create Account ");
        System.out.println("");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println("\n");



        while(true){

            System.out.println("Please enter your first name : ");
            System.out.println("");
            String f_name =scanner.next();
            System.out.println("");
            if(f_name.length()<3){
                System.out.println("Invalid !");
                continue;
            }
            
            if(f_name.length()>14){
                System.out.println("First name is too long.");
            }

            else{
                u.first_name=f_name;
                break;
            }
            
        }

        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("\n");

        while(true){
            System.out.println("Please enter your last name : ");
            System.out.println("");
            String l_name =scanner.next();
            System.out.println("");
            if(l_name.length()<3){
                System.out.println("Invalid !");
                continue;
            }
            
            if(l_name.length()>14){
                System.out.println("Last name is too long.");
            }
            
            else{
                u.last_name=l_name;
            break;
        }
    }
    

         System.out.println("\n");
         System.out.println("--------------------------------------");
         System.out.println("\n");
    


 while(true){
            System.out.println("Please enter a username for your account : ");
            System.out.println("");
            String u_name =scanner.next();
            System.out.println("");
            if(u_name.length()<7){
                System.out.println("Username is too short , it must be a minimum of 7 characters.");
                continue;
            }
            
            if(u_name.length()>14){
                System.out.println("Username is too long , it must be a maximum of 14 characters.");
            }
            
            else{
                u.username=u_name;
            break;
        }
    }




    
   
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("\n");



    while(true){
        System.out.println("Enter your age : ");
        System.out.println("");
        Integer Age =scanner.nextInt();
        System.out.println("");
        if(Age<16){
            System.out.println("Invalid age, the minimum age to create an account is 16 !");
            continue;
        }
            else{
                u.age=Age;
                break;
            }
        }
        
        
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("\n");

        while(true){
            System.out.println("Please enter your mobile phone number : ");
            System.out.println("");
            String phone_no =scanner.next();
            System.out.println("");
            if(phone_no.length()==11 ){
                u.phone_number=phone_no;
                break;
            }
            else{
                System.out.println("Invalid phone number, the phone number should be 11 numbers !");
                continue;
                
            }
        }
        
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("\n");

        while(true){
            System.out.println("Please enter your address: ");
            System.out.println("");
            String Address =scanner.next();
            System.out.println("");
            u.address=Address;
            break;
        }
        
        
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("\n");

        System.out.println("Note : your password should be a minimum of 8 character & maximum of 16 ");
        while(true){

            System.out.println("Create a strong password for your account : ");
            System.out.println("");
            String pass=scanner.next();
            System.out.println("");
          if(pass.length()<8  ){
              System.out.println("Weak password detected!");
              continue;
            }
            
           else if(pass.length()>16){
                System.out.println("Password is too long !");
                continue;
            }
            else{
                u.password=pass;
                System.out.println("Enter your password again to confirm : ");
                System.out.println("");
                String confirm_pass=scanner.next();
                System.out.println("");
                if(confirm_pass.equals(pass)){
                    break;
                }

                else{
                    System.out.println("Passwords don't match ,try again !");
                    continue;
                }
                
            }
        }
        
        
        //generates random ID for Customer
        RandIDGenerator generator = new RandIDGenerator();
        generator.setItemCount(5);
        generator.generateRandID();
        u.account_id=generator.getRandID();
        
        
        //add the user account to the list of accounts
        list.add(u);
    

        //input data into text file
        String filePath = "test.txt";
         try (PrintWriter writer = new PrintWriter(new FileWriter(filePath,true),true)) {
            for (Customer u : list) {
                writer.println(u.first_name);
                writer.println(u.last_name);
                writer.println(u.age);
                writer.println(u.address);
                writer.println(u.phone_number);
                writer.println(u.username);
                writer.println(u.password);
                writer.println(u.account_id);
                writer.println();
            }


        }
        
        


    }
    

  
    //login into account
    public void login() throws FileNotFoundException, IOException{
        
        System.out.println("\n");
        System.out.println("Login into your account : ");
        System.out.println("==============================");
        
        while(true){
            System.out.println("Enter your username : ");
            String usern=scanner.next();
            System.out.println("Enter your password : ");
            String pass=scanner.next();
          

            String filePath = "test.txt"; 

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                
                String line;
    
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\n");
    
                    // Assuming the file format is "username,password"
                     usern = parts[5];
                     pass = parts[6];
    
                    if (usern.equals(u.username) && pass.equals(u.password)) {
                        System.out.println("Logged in successfuly.");
                        break;
                    }

                    else{
                        System.out.println("Wrong username or password, try again !");
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }







        

        }//end of while

    
    }








    //diplay all users accounts and their information (for admin usage only)
   protected void display_all_users() throws FileNotFoundException, IOException{
         String filePath = "test.txt";
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file until the end of the file is reached
            System.out.println("\n");
            System.out.println("Users accounts : ");
            System.out.println("==============================");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               
            }
           
        } 
    }

    
    }











