package level1;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class CalculatorLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TODO 1. 양의 정수를 저장하기 위한 변수 선언
        int first, second;
        //TODO 2. 사칙연산 기호를 입력받기 위한 변수 선언
        String opStr;
        char op;
        //TODO 3. 결과를 저장하기 위한 변수 선언
        Integer result;
        Optional<Integer> resultOptional;
        //TODO 4. 반복 여부를 결정하기 위한 변수 선언
        String exit;

        //TODO 4. 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
        while (true) {

            result = null;
            try {
                //TODO 1. 양의 정수(0 포함)을 입력받기
                System.out.print("첫 번째 양의 정수(0 포함)를 입력해주세요: ");
                first = scanner.nextInt();
                System.out.print("두 번째 양의 정수(0 포함)를 입력해주세요: ");
                second = scanner.nextInt();

                //TODO 2. 사칙연산 기호 (+, -, *, /) 입력받기
                System.out.print("사칙연산 기호를 입력해주세요: ");
                opStr = scanner.next();
                op = opStr.charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 프로그램을 다시 시작합니다.");
                scanner.nextLine();
                continue;
            }


            //TODO 3. 위에서 입력 받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
            switch (op) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case '/':
                    if(second > 0) {
                        result = first / second;
                    } else {
                        System.out.println("0으로는 나눌 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("올바른 연산자를 입력해주세요.");
            }

            resultOptional = Optional.ofNullable(result);
            resultOptional.ifPresent(integer -> System.out.println("계산 결과: " + integer));

            //TODO 4. 반복 여부 결정
            System.out.print("종료를 원하면 exit을 입력해주세요. 그렇지 않을 경우, 아무 문자나 입력해주세요: ");
            exit = scanner.next();

            if(exit.equals("exit")) {
                break;
            }
        }


    }
}
