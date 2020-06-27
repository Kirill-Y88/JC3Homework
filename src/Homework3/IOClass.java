package Homework3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOClass {
    private String fileName;
    private byte [] outData;
    private byte[] byteInArray;
    private String censorship [][] = {{"2+2=4", "2+2=5"}, {"твою мать", "матушка"}, {"вперед","назад"}};

    public IOClass (String fileName){
        this.fileName = fileName;
    }

    public void outStream (String message){
        String arrayOutstream [] = message.split(" ");
        message = "";
        for (int i = 0; i < arrayOutstream.length ; i++) {
            for (int j = 0; j < censorship.length ; j++) {
                if (arrayOutstream[i].equals(censorship[j][0])) {
                    arrayOutstream[i] = censorship[j][1];
                }
            }
        message = message + " " + arrayOutstream[i];
        }
        outData = message.getBytes();
        try (FileOutputStream out = new FileOutputStream(fileName, true)) {
            out.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanFile (){
        outData = "".getBytes();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inStream (){
        try (FileInputStream in = new FileInputStream(fileName)) {
            byteInArray = new byte[in.available()];
            in.read(byteInArray);
            String dataInStream = new String(byteInArray);
            String[] stringArray = dataInStream.split("\n");
            System.out.println(stringArray.length);
            if(stringArray.length > 10){
            for (int i = stringArray.length-10; i < stringArray.length; i++) {
                System.out.println(stringArray[i]);
            }}
            else {
                for (int i = 0; i < stringArray.length; i++) {
                    System.out.println(stringArray[i]);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
