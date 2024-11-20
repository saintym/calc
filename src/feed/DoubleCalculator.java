package feed;

public class DoubleCalculator extends Calculator<Double> {

    @Override
    public Double calculate(Double firstNumber, Double secondNumber, OperatorType operatorType) {
        switch (operatorType) {
            case PLUS -> {
                return firstNumber + secondNumber;
            }
            case SUBTRACT -> {
                return firstNumber - secondNumber;
            }
            case MULTIPLY -> {
                return firstNumber * secondNumber;
            }
            case DIVIDE -> {
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("나눗셈에서 분모는 0이 될 수 없습니다.");
                }
                return firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("unknown operator");
        }
    }


}
