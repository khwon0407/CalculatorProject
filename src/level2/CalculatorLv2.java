package level2;

import java.util.Optional;
import java.util.Scanner;

public class CalculatorLv2 {
    public static void main(String[] args) {
        //TODO 2. Lv 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int first, second;
        String opStr;
        char op;

        Integer result;
        Optional<Integer> resultOptional;

        String exit;


        while (true) {

            result = null;

            System.out.print("첫 번째 양의 정수(0 포함)를 입력해주세요: ");
            first = scanner.nextInt();
            System.out.print("두 번째 양의 정수(0 포함)를 입력해주세요: ");
            second = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력해주세요: ");
            opStr = scanner.next();
            op = opStr.charAt(0);

            resultOptional = calculator.calculate(first, second, op);
            resultOptional.ifPresent(integer -> System.out.println("계산 결과: " + integer));
            
            System.out.print("종료를 원하면 exit을 입력해주세요. 그렇지 않을 경우, 아무 문자나 입력해주세요: ");
            exit = scanner.next();

            if(exit.equals("exit")) {
                break;
            }
        }
    }
}
