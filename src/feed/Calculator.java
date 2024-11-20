package feed;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator<T> {

    protected List<T> results = new ArrayList<>();

    public abstract T calculate(T firstNumber, T secondNumber, OperatorType operatorType);

    public List<T> getResults() {
        return results;
    }

    public void setResults(T number) {
        results.add(number);
    }

    // 중략 할께요..
}
