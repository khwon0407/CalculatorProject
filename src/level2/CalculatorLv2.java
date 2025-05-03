package level2;

import java.util.InputMismatchException;
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
        Optional<Integer> resultOptional;

        String exit, remove;

        while (true) {
            try {
                System.out.print("첫 번째 양의 정수(0 포함)를 입력해주세요: ");
                first = scanner.nextInt();
                System.out.print("두 번째 양의 정수(0 포함)를 입력해주세요: ");
                second = scanner.nextInt();

                System.out.print("사칙연산 기호를 입력해주세요: ");
                opStr = scanner.next();
                op = opStr.charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 프로그램을 다시 시작합니다.");
                scanner.nextLine();
                continue;
            }

            //TODO. 계산기 클래스에 계산 과정 이양
            resultOptional = calculator.calculate(first, second, op);
            
            if(resultOptional.isPresent()) {
                Integer realResult = resultOptional.get();
                System.out.println("계산 결과: " + realResult);
            }
            System.out.println("현재 저장 중인 값들의 목록: " + calculator.getResultCollection());

            //TODO. Getter 활용
            try {
                int idx;
                System.out.print("현재 저장되어 있는 결과값 중 보고 싶은 차례의 인덱스를 입력해주세요: ");
                idx = scanner.nextInt();
                System.out.println("해당 결과 값은 " + calculator.getResult(idx) + "입니다.");
            } catch (InputMismatchException ex) {
                System.out.println("잘못된 입력입니다.");
            } catch (Exception e) {
                System.out.println("범위를 벗어났습니다.");
            }
            
            //TODO. Setter 활용
            try {
                int idx;
                Integer temp;
                System.out.print("현재 저장되어 있는 결과값 중 고치고 싶은 차례의 인덱스를 입력해주세요: ");
                idx = scanner.nextInt();
                System.out.print("어떤 값으로 고치고 싶은지 입력해주세요: ");
                temp = scanner.nextInt();
                calculator.setResultCollection(idx, temp);
                System.out.println("수정된 값은 " + calculator.getResult(idx) + "입니다.");
            } catch (InputMismatchException ex) {
                System.out.println("잘못된 입력입니다.");
            } catch (Exception e) {
                System.out.println("범위를 벗어났습니다.");
            }

            System.out.print("현재 저장되어 있는 결과값 중 가장 오래된 값을 지우겠습니까? 원할 경우 yes를 입력해주세요: ");
            remove = scanner.next();

            if(remove.equals("yes")) {
                //삭제를 원하면 삭제 이행
                calculator.removeResult();
            }
            System.out.println("현재 저장 중인 값: " + calculator.getResultCollection());

            System.out.print("종료를 원하면 exit을 입력해주세요. 그렇지 않을 경우, 아무 문자나 입력해주세요: ");
            exit = scanner.next();

            if(exit.equals("exit")) {
                break;
            }
        }
    }
}
