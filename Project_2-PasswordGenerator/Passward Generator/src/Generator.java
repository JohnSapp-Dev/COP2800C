
import java.util.ArrayList;
import java.util.Scanner;

public class Generator {

    static Scanner userInput = new Scanner(System.in);
    static ArrayList<Password> listOfPasswords = new ArrayList<>();
    //static FileOutput file = new FileOutput();
    static Password newPass;
    static String name;
    static int pwLength;
    static String specialChar;
    static String numberChar;
    static boolean specialCharacters;
    static boolean numberCharacters;
    static boolean generatingPasswords = true;
    static String generateAnother;
    static String createFileResponse;
    public static void welcomeMessage(){
        System.out.println("\nWelcome to the Password Generator!");
    }

    public static StringBuilder createPassword() {
        //try catch to set the name of the password
        try {
            System.out.println("What is this Password used for?");
            name = userInput.nextLine();
        }
        catch (Exception e) {
            System.out.println("Sorry something went wrong, try again.");
        }
        // try catch to set the length of the password
        try {
            System.out.println("How many characters are in this Password?");
            pwLength = Integer.parseInt(userInput.nextLine());
        }
        catch (Exception e) {
            System.out.println("please only enter a number");
        }
        //try catch to set if the user wants to use special characters
        try {
            System.out.println("Do you want this password to have Special characters? (!@#)");
            System.out.println("Enter yes or no");
            specialChar = userInput.nextLine();
            specialChar = specialChar.toUpperCase();
            if (specialChar.equals("Y") || specialChar.equals("YES")) {
                specialCharacters = true;
            } else if (specialChar.equals("N") || specialChar.equals("NO")) {
                specialCharacters = false;
            }
        }
        catch (Exception e) {
            System.out.println("Sorry something went wrong, try again.");
        }
        //try catch to set if the user wants to use numerical characters
        try{
            System.out.println("Do you want this password to have number characters? (123)");
            System.out.println("Enter yes or no");
            numberChar = userInput.nextLine();
            numberChar = numberChar.toUpperCase();
            if (numberChar.equals("Y") || numberChar.equals("YES")){
               numberCharacters = true;
            }
            else if(numberChar.equals("N") || numberChar.equals("NO")){
                numberCharacters = false;
            }
        }
        catch (Exception e) {
            System.out.println("Sorry something went wrong, try again.");
        }
        newPass = new Password(name,pwLength,specialCharacters,numberCharacters);
        listOfPasswords.add(newPass);
        return newPass.getPassword();
    }

    public static ArrayList<Password> getListArray(){
        return listOfPasswords;
    }

    public static void main(String[]args){
        StringBuilder password;
        welcomeMessage();
        while (generatingPasswords){
            password = createPassword();
            System.out.println(password);

            try {
                System.out.println("Do you want to create another password? Yes or no");
                generateAnother = userInput.nextLine();
                generateAnother = generateAnother.toUpperCase();
                if (generateAnother.equals("Y") || generateAnother.equals("YES")){
                    generatingPasswords = true;
                }
                else{
                    generatingPasswords = false;
                }
            } catch (Exception e) {
                System.out.println("Sorry something went wrong, try again.");
            }
        }
        /*Prints all the passwords created*/
        for (Password listOfPassword : listOfPasswords) {
            System.out.println(listOfPassword.toString());
        }
        //write to file
        System.out.println("Would you like to save your passwords to a file? yes or no");
        createFileResponse = userInput.nextLine();
        createFileResponse = createFileResponse.toUpperCase();
        if (createFileResponse.equals("Y")||createFileResponse.equals("YES")){
            FileOutput file = new FileOutput();
            System.out.println("Name your file");
            file.setFileName(userInput.nextLine());
            System.out.println("Your file will be saved in the Project folder");
            file.createFile();
        }
        System.out.println("Thank you for using the Password Generator");
    }
}
