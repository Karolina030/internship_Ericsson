import java.util.InputMismatchException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type;
        int number;
        do{
            System.out.println("Select the application operating mode:");
            System.out.println("0 - binary to decimal conversion ");
            System.out.println("1 - decimal to binary conversion ");
            System.out.println("2 - the end");

            type = scanner.next();
            if (type.equals("0")) {
                System.out.println("Enter a binary number: ");

                try {
                    number = scanner.nextInt();
                    if (isBinary(number)){
                        binaryToDecimal(number);
                    }
                    else{
                        System.out.println("Unfortunately, the given number is not a binary number");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The given number is not an integer");
                    scanner.nextLine();
                }


            } else if (type.equals("1")){
                System.out.println("Enter a decimal number: ");
                try {
                    number = scanner.nextInt();
                    if (number>=0){
                        decimalToBinary(number);
                    }
                    else{
                        System.out.println("The given number is negative, I can't convert it to binary");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The given number is not an integer");
                    scanner.nextLine();
                }
            } else if (type.equals("2")){
                System.out.println("The end");
            }
            else {
                System.out.println("No mode selected");
            }
        }
        while(!type.equals("2"));
        scanner.close();

    }


    public static void binaryToDecimal(int binary){
        int decimal = 0;
        int i =0;
        int temp = binary;
        while (temp > 0)
        {
            int last = temp%10;
            temp = temp / 10;
            decimal += last * Math.pow(2, i);
            ++i;
        }
        System.out.println("After conversion:");
        System.out.println(decimal);
        System.out.println(" ");

    }

    public static boolean isBinary(int number){
        int checkedNumber = number;
        if (checkedNumber>=0) {
            while (checkedNumber > 0) {
                if (checkedNumber % 10 > 1) {
                    return false;
                }
                checkedNumber = checkedNumber / 10;
            }
            return true;
        }
        else{
            return false;
        }
    }


    public static void decimalToBinary(int decimal){
        Integer dec = decimal;
        String bin = Integer.toBinaryString(dec);
        System.out.println("After conversion:");
        System.out.println(bin);
        System.out.println(" ");

    }
}
