import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Float> results = new ArrayList<>();

    public List<Float> getResults() {
        return results;
    }

    public void setResults(float number) {
        results.add(number);
    }

    public void removeResult() {
        results.remove(0);
    }

    public void calculate(int firstNumber, int secondNumber, char symbol, boolean isOperateDone) {
        float result = 0;
        isOperateDone = false;

        switch (symbol) {
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
                    isOperateDone = false;
                    break;
                }
                result = (float) (firstNumber / secondNumber);
                isOperateDone = true;
            }
            default -> System.out.print("기호는 +,-,*,/ 만 가능합니다.");
        }
        if(!isOperateDone)
            return;
        results.add(result);
        System.out.println("결과: " + result);
    }
}
