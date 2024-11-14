import java.util.ArrayList;
import java.util.List;


public class Calculator<T extends Number> {
    private List<T> results = new ArrayList<>();

    public List<T> getResults() {
        return results;
    }

    public void setResults(T number) {
        results.add(number);
    }

    public void removeResult() {
        results.remove(0);
    }

    public List<T> searchGreaterThan(T number) {
        return this.results.stream()
                .filter(result -> result.doubleValue() > number.doubleValue())
                .toList();
    }

    public void calculate(T firstNumber, T secondNumber, char symbol, boolean isOperateDone) {
        double result = 0;
        isOperateDone = false;

        switch (symbol) {
            case '+' -> {
                result = firstNumber.doubleValue() + secondNumber.doubleValue();
                isOperateDone = true;
            }
            case '-' -> {
                result = firstNumber.doubleValue() - secondNumber.doubleValue();
                isOperateDone = true;
            }
            case '*' -> {
                result = firstNumber.doubleValue() * secondNumber.doubleValue();
                isOperateDone = true;
            }
            case '/' -> {
                if (secondNumber.doubleValue() == 0) {
                    System.out.println("!! 나눗셈에서 분모는 0이 될 수 없습니다.\n");
                    break;
                }
                result = (float) (firstNumber.doubleValue() / secondNumber.doubleValue());
                isOperateDone = true;
            }
        }
        if (!isOperateDone)
            return;

        results.add((T) Double.valueOf(result));
        System.out.println("결과: " + result);
    }
}