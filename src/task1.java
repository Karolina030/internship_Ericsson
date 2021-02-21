import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args)  throws IOException {

        char eightChars[] = new char[8];
        List<String> strings = new ArrayList<>();
        List<String> correctStrings= new ArrayList<>();

        int objectsNumber;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt" ));

            while (reader.read(eightChars) != -1) {
                strings.add(new String(eightChars));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt" ));
            objectsNumber = strings.size();
            writer.write(objectsNumber+"\n");
            int stringWithErrors =0;
            //counting objects start from 0
            for(int i =0; i<objectsNumber;i++){

                if (strings.get(i).charAt(6)=='0'&& strings.get(i).charAt(5)=='0' && strings.get(i).charAt(4)=='0'){
                    stringWithErrors +=1;
                } else if (i%2==0 && strings.get(i).charAt(7)=='0'){
                    correctStrings.add(strings.get(i));
                } else if (i%2!=0 && strings.get(i).charAt(7)=='1'){
                    correctStrings.add(strings.get(i));
                } else{
                    stringWithErrors +=1;

                }

            }
            writer.write(stringWithErrors+"\n");
            writer.write(correctStrings.toString()+"\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}



