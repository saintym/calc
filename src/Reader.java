import java.util.Scanner;

class Reader {
    static double readNumber(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 다시 입력하여 주십시오.");
            }
        }
    }

    static char readOperator(Scanner scanner) {
        while (true) {
            var operator = scanner.nextLine().charAt(0);
            switch (operator) {
                case '+' -> {
                    return '+';
                }
                case '-' -> {
                    return '-';
                }
                case '*' -> {
                    return '*';
                }
                case '/' -> {
                    return '/';
                }
                default -> System.out.println("기호는 +,-,*,/ 만 가능합니다. 다시 입력하여 주십시오.");
            }
        }
    }

    static Keyword readKeyword(Scanner scanner) {
        var keyword = scanner.nextLine();
        switch (keyword) {
            case "exit", "Exit", "EXIT", "2":
                return Keyword.EXIT;
            case "remove", "Remove", "REMOVE", "3":
                return Keyword.REMOVE;
            case "greaterThan", "GreaterThan", "GREATERTHAN", "GREATER_THAN", "4":
                return Keyword.GREATER_THAN;
            default:
                return Keyword.CONTINUE;
        }
    }
}

enum Keyword {
    CONTINUE,
    EXIT,
    REMOVE,
    GREATER_THAN;
}
