import java.io.FileWriter;
public class FileOutput {
    //fields
    String fileType;
    String fileName;
    String fileHeader = "Thank you for using the password generator! \nYour Passwords are below.\n\n";
    //constructor
    FileOutput(String fileType,String fileName){
     this.fileType = fileType;
     this.fileName = fileName;
    }
    FileOutput(){
        this.fileType = ".txt";
    }

    //methods
    public void createFile(){
        String fileNameType = this.fileName + this.fileType;
        try {
            FileWriter file = new FileWriter(fileNameType);
            file.write(fileHeader);
            // writes all objects in the ListOfPassword ArrayList
            for (int i =0;i<Generator.getListArray().size();i++) {
                file.write(Generator.getListArray().get(i).toString()+"\n");
            }
            file.close();
        }
        catch(Exception e){
            System.out.println("File didn't write");
        }
    }

    // Getters & Setters
    public String getFileType(){
        return this.fileType;
    }
    public void setFileType(String type){
        this.fileType = type;
    }
    public String getFileName(){
        return this.fileName;
    }
    public void setFileName(String name){
        this.fileName = name;
    }
}
