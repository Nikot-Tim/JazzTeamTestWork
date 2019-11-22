import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        long inputNumber;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число для преобразования: ");
        if(in.hasNextLong()){
            inputNumber = in.nextLong();
            System.out.println("Результат преобразования: " + Number2Text.inputValidation(inputNumber));
        }
        else {
            System.out.println("Введено неверное значение, попробуйте ввести число");
        }
    }
}
