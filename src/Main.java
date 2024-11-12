import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var trigger = true;

        while(trigger) {
            int firstNumber = 0;
            int secondNumber = 0;
            char operate = '+';

            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("사칙연산 기호를 입력하세요: ");
            operate = scanner.nextLine().charAt(0);

            float result = 0;
            var isOperateDone = false;
            switch (operate) {
                case '+' -> {
                    result = firstNumber + secondNumber;
                    isOperateDone = true;
                }
                case '-' -> {
                    result = firstNumber - secondNumber;
                    isOperateDone = true;
                }
                case '*' -> {
                    result = firstNumber * secondNumber;
                    isOperateDone = true;
                }
                case '/' -> {
                    if (secondNumber == 0) {
                        System.out.print("나눗셈에서 분모는 0이 될 수 없습니다.\n");
                        break;
                    }
                    result = (float) (firstNumber / secondNumber);
                    isOperateDone = true;
                }
                default -> System.out.print("기호는 +,-,*,/ 만 가능합니다.");

            }
            if(!isOperateDone)
                continue;

            System.out.println("결과: " + result);

            System.out.println("더 계산하려면 아무 키나 누르십시오. (exit 입력 시 종료)");
            if(scanner.nextLine().equals("exit"))
                trigger = false;
        }
    }
}