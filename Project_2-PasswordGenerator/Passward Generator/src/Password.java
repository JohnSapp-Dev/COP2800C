import java.util.Random;

public class Password {

    //fields
    private String passwordName;
    private int passwordLength;
    private boolean specialCharacter;
    private boolean numberCharacter;
    private StringBuilder passWord;
    Random ranNum = new Random();
    StringBuilder password = new StringBuilder();
    String[] characters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String [] specialChar ={"!","@","#","$","%","^","&","*","(",")","~","/","-","+",":",";"};
    String[] numberChar = {"1","2","3","4","5","6","7","8","9","0"};
    int charactersLength = characters.length;
    int specialLength = specialChar.length;
    int numberLength = numberChar.length;

    //constructor
    Password(String pwName,int pwLength,boolean specialChar,boolean numChar){
        this.passwordName = pwName;
        this.passwordLength = pwLength;
        this.specialCharacter = specialChar;
        this.numberCharacter = numChar;
        this.passWord = pwGenerator();
    }
    Password(){
        this.passwordName = "No Name";
        this.passwordLength = 8;
        this.specialCharacter = true;
        this.numberCharacter = true;
        this.passWord = pwGenerator();
    }

    //methods
    public StringBuilder pwGenerator(){
        for(int i=0;i<this.passwordLength;i++){
            // randomly picks one of the switch cases to run.
            int pickCharType = ranNum.nextInt(1,4);
            switch (pickCharType){
                case 1:
                    int arrayIndexNum = ranNum.nextInt(0,charactersLength);
                    password.append(characters[arrayIndexNum]);
                    break;
                case 2:
                    if (this.specialCharacter){
                        arrayIndexNum = ranNum.nextInt(0,specialLength);
                        password.append(specialChar[arrayIndexNum]);
                    }else{
                        i--;
                    }
                    break;
                case 3:
                    if (this.numberCharacter){
                        arrayIndexNum = ranNum.nextInt(0,numberLength);
                        password.append(numberChar[arrayIndexNum]);
                    }else{
                        i--;
                    }
            }
        }
        return password;
    }

    // toString method to format the password text output.
    @Override
    public String toString(){
        return "Password Name: " + passwordName + "\nPassword:      " + passWord+ "\n";
    }

    //getters & setters

    public String getPasswordName(){
        return this.passwordName;
    }
    public void setPasswordName(String pwName){
        this.passwordName = pwName;
    }

    public int getPasswordLength(){
        return this.passwordLength;
    }
    public void setPasswordLength(int pwLength){
        this.passwordLength = pwLength;
    }
    public StringBuilder getPassword(){
        return this.passWord;
    }
    public void setPassWord(StringBuilder passWord){
        this.passWord = passWord;
    }

    public boolean getSpecialCharacter(){
        return this.specialCharacter;
    }
    public void setSpecialCharacter(boolean specialChar){
        this.specialCharacter = specialChar;
    }

    public boolean getNumberCharacter(){
        return this.numberCharacter;
    }
    public void setNumberCharacter(boolean numberCharacter){
        this.numberCharacter = numberCharacter;
    }
}
