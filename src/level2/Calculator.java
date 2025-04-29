package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {
    //TODO 1. 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스
    List<Integer> resultCollection = new ArrayList<Integer>();

    //TODO 1. 사칙연산을 수행 후, 결과값 반환 메서드 구현
    public Optional<Integer> calculate(int first, int second, char op) {
        Integer result = null;
        Optional<Integer> resultOptional;

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
                try {
                    result = first / second;
                } catch (ArithmeticException e) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("올바른 연산자를 입력해주세요.");
        }

        resultOptional = Optional.ofNullable(result);
        return resultOptional;
    }
}
