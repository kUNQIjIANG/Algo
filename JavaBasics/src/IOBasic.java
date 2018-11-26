/**
 * Created by kunqi
 * ON 11/24/18 10:36 PM
 */


import java.io.*;
import java.util.Scanner;

public class IOBasic {

    public static void main(String[] args){
        System.out.println(1);
    }

    public static void printerScanner(String file) throws IOException{

        PrintWriter output = new PrintWriter("./src/tmp.txt");
        output.println("I am learning back");
        output.println("who knows future");
        output.close();

        Scanner input = new Scanner(new File("./src/tmp.txt"));
        while(input.hasNextLine()){
            System.out.println(input.nextLine());
        }

    }

    public static void fileStream(String file) throws IOException{
        try (FileOutputStream output = new FileOutputStream(file);){
            for (int i = 1; i <= 5; i++){
                output.write(i);
            }
            output.close();
        }


        try (FileInputStream input = new FileInputStream(file)) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value + " ");
            }
        }
    }

    public static void dataStream(String file) throws IOException{
        try( DataOutputStream output = new DataOutputStream(
                new FileOutputStream(file));){
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeChars("jajajv");
        }

        try (DataInputStream input = new DataInputStream(
                new FileInputStream(file));){
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }

    public static void copyFile(String source, String target) throws IOException {
        File sourceFile = new File(source);
        if (!sourceFile.exists()){
            System.out.println("source file " + source
                    + " does not exist");
            System.exit(2);
        }

        File targetFile = new File(target);
        if (targetFile.exists()){
            System.out.println("target file " + target
                    + " already exist");
            System.exit(3);
        }

        try (
                BufferedInputStream input = new BufferedInputStream(
                        new FileInputStream(sourceFile));
                BufferedOutputStream output = new BufferedOutputStream(
                        new FileOutputStream(targetFile));)
        {
            int r, numberOfByteCopied = 0;
            while (( r = input.read()) != -1){
                output.write((byte) r);
                numberOfByteCopied ++;
            }
            System.out.println(numberOfByteCopied + "bytes copied");

        }

    }

}
