package level3;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class CalculatorLv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        OperatorType operatorType;

        String first, second;
        String opStr;
        char op;
        double cmp;

        Optional<Number> resultOptional;

        String exit, remove;

        while (true) {
            try {
                System.out.print("첫 번째 양의 정수(0 포함)를 입력해주세요: ");
                first = scanner.next();
                System.out.print("두 번째 양의 정수(0 포함)를 입력해주세요: ");
                second = scanner.next();

                System.out.print("사칙연산 기호를 입력해주세요: ");
                opStr = scanner.next();
                op = opStr.charAt(0);

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 프로그램을 다시 시작합니다.");
                scanner.nextLine();
                continue;
            }

            operatorType = OperatorType.fromChar(op);
            if(ArithmeticCalculator.isInteger(first) && ArithmeticCalculator.isInteger(second)) {
                Integer firstInt = Integer.parseInt(first);
                Integer secondInt = Integer.parseInt(second);
                resultOptional = calculator.calculate(firstInt, secondInt, operatorType);
            } else {
                Double firstDouble = Double.parseDouble(first);
                Double secondDouble = Double.parseDouble(second);
                resultOptional = calculator.calculate(firstDouble, secondDouble, operatorType);
            }

            if(resultOptional.isPresent()) {
                Number realResult = resultOptional.get();
                System.out.println("계산 결과: " + realResult);
                calculator.setResultCollection(realResult);
            }
            System.out.println("현재 저장 중인 값들의 목록: " + calculator.getResultCollection());

            System.out.print("현재 저장되어 있는 결과값 중 가장 오래된 값을 지우겠습니까? 원할 경우 yes를 입력해주세요: ");
            remove = scanner.next();

            if(remove.equals("yes")) {
                calculator.removeResult();
            }

            System.out.print("결과값 중 특정 수 보다 큰 결과값을 봅니다. 특정 수를 입력해주세요: ");
            cmp = scanner.nextDouble();
            System.out.println("찾는 값의 목록: " + calculator.getMoreThanNum(cmp));

            System.out.print("종료를 원하면 exit을 입력해주세요. 그렇지 않을 경우, 아무 문자나 입력해주세요: ");
            exit = scanner.next();

            if(exit.equals("exit")) {
                break;
            }
        }
    }
}
