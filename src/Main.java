import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var calc = new Calculator();
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

            var isOperateDone = false;
            calc.calculate(firstNumber, secondNumber, operate, isOperateDone);

            System.out.println("더 계산하려면 아무 키나 누르십시오. \nexit 입력 시 종료\nremove 입력 시 처음 계산 결과 삭제");
            var orderWord = scanner.nextLine();
            if(orderWord.equals("exit"))
                trigger = false;
            else if(orderWord.equals("remove"))
                calc.removeResult();
        }
    }
}