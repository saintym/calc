import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var calc = new Calculator<Double>();
        var trigger = true;

        while (trigger) {
            double firstNumber = 0;
            double secondNumber = 0;
            char operate = '+';

            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNumber = Reader.readNumber(scanner);
            System.out.print("사칙연산 기호를 입력하세요: ");
            operate = Reader.readOperator(scanner);
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNumber = Reader.readNumber(scanner);

            var isOperateDone = false;
            calc.calculate(firstNumber, secondNumber, operate, isOperateDone);

            System.out.println("1. 더 계산하려면 아무 키나 누르십시오.\n2. exit 혹은 2 입력 시 종료\n3. remove 혹은 3 입력 시 처음 계산 결과 삭제\n4. greaterThan 혹은 4 입력 시 해당 숫자보다 큰 값 도출");
            var keyword = Reader.readKeyword(scanner);

            switch (keyword) {
                case EXIT -> trigger = false;
                case REMOVE -> calc.removeResult();
                case GREATER_THAN -> {
                    System.out.println("숫자를 입력하여 주십시오.");
                    var list = calc.searchGreaterThan(Reader.readNumber(scanner));
                    list.forEach(System.out::println);
                }
                case CONTINUE -> {
                    continue;
                }
            }
        }
    }
}