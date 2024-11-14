import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;


public class Calculator<T extends Number> {
    private final Scanner scanner = new Scanner(in);
    private T firstNumber;
    private T secondNumber;
    private OperatorType operator;
    private List<T> results = new ArrayList<>();

    public List<T> getResults() {
        return results;
    }

    public void setResults(T number) {
        results.add(number);
    }

    public void removeResult() {
        System.out.println("가장 마지막 계산 값 [ " + results.get(0) + " ] 를 삭제하였습니다.\n");
        results.remove(0);
    }

    public List<T> searchGreaterThan(T number) {
        return this.results.stream()
                .filter(result -> result.doubleValue() > number.doubleValue())
                .toList();
    }

    private void setNumbersAndOperator(){
        System.out.print("첫 번째 숫자를 입력하세요: ");
        this.firstNumber = ((T) Double.valueOf(Reader.readNumber(this.scanner)));
        System.out.print("사칙연산 기호를 입력하세요: ");
        this.operator = Reader.readOperator(scanner);
        System.out.print("두 번째 숫자를 입력하세요: ");
        this.secondNumber = ((T) Double.valueOf(Reader.readNumber(this.scanner)));
    }

    public void calculate() {
        var trigger = true;
        while(trigger) {
            setNumbersAndOperator();

            double result = 0;

            switch (operator) {
                case PLUS -> result = firstNumber.doubleValue() + secondNumber.doubleValue();
                case SUBTRACT -> result = firstNumber.doubleValue() - secondNumber.doubleValue();
                case MULTIPLY -> result = firstNumber.doubleValue() * secondNumber.doubleValue();
                case DIVIDE -> {
                    if (secondNumber.doubleValue() == 0) {
                        System.out.println("!! 나눗셈에서 분모는 0이 될 수 없습니다.\n");
                        return;
                    }
                    result = (float) (firstNumber.doubleValue() / secondNumber.doubleValue());
                }
            }

            results.add((T) Double.valueOf(result));
            System.out.println("결과: " + result);
            trigger = isKeepGoing();
            if(!trigger)
                scanner.close();
        }

    }

    private boolean isKeepGoing(){
        System.out.println("1. 더 계산하려면 아무 키나 누르십시오.\n2. exit 혹은 2 입력 시 종료\n3. remove 혹은 3 입력 시 처음 계산 결과 삭제\n4. greaterThan 혹은 4 입력 시 해당 숫자보다 큰 값 도출");
        var keyword = Reader.readKeyword(scanner);

        switch (keyword) {
            case EXIT -> {
                System.out.println("계산기 종료.");
                return false;
            }
            case REMOVE -> {
                removeResult();
                return isKeepGoing();
            }
            case GREATER_THAN -> {
                System.out.println("숫자를 입력하여 주십시오.");
                var list = searchGreaterThan((T) Double.valueOf(Reader.readNumber(scanner)));
                list.forEach(System.out::println);
                return isKeepGoing();
            }
            default -> {
                return true;
            }
        }
    }
}