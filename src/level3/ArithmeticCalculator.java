package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Number> resultCollection = new ArrayList<>();

    public <S> Optional<S> calculate(S first, S second, OperatorType op) {
        S result = null;
        Optional<S> resultOptional;

        switch (op) {
            case PLUS -> {
                if (first instanceof Integer i1 && second instanceof Integer i2) {
                    Integer temp = i1 + i2;
                    result = (S) temp;
                } else if (first instanceof Double d1 && second instanceof Double d2) {
                    Double temp = d1 + d2;
                    result = (S) temp;
                }
            }
            case MINUS -> {
                if (first instanceof Integer i1 && second instanceof Integer i2) {
                    Integer temp = i1 - i2;
                    result = (S) temp;
                } else if (first instanceof Double d1 && second instanceof Double d2) {
                    Double temp = d1 - d2;
                    result = (S) temp;
                }
            }
            case MULTI -> {
                if (first instanceof Integer i1 && second instanceof Integer i2) {
                    Integer temp = i1 * i2;
                    result = (S) temp;
                } else if (first instanceof Double d1 && second instanceof Double d2) {
                    Double temp = d1 * d2;
                    result = (S) temp;
                }
            }
            case DEVIDE -> {
                try {
                    if (first instanceof Integer i1 && second instanceof Integer i2) {
                        Integer temp = i1 / i2;
                        result = (S) temp;
                    } else if (first instanceof Double d1 && second instanceof Double d2) {
                        Double temp = d1 / d2;
                        result = (S) temp;
                    }
                } catch (ArithmeticException e) {
                    System.out.println("0으로는 나눌 수 없습니다.");
                }
            }
            default -> System.out.println("올바른 연산자를 입력해주세요.");
        }

        resultOptional = Optional.ofNullable(result);
        return resultOptional;
    }

    public static boolean isInteger(String numStr) {
        try {
            Integer.parseInt(numStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Number> getResultCollection() {
        return resultCollection;
    }

    public void setResultCollection(Number number) {
        this.resultCollection.add(number);
    }

    public void removeResult() {
        resultCollection.remove(0);
    }

    //TODO. filter와 lambda를 활용하여 특정 수보다 큰 결과값을 모두 불러오는 기능
    public List<Number> getMoreThanNum(double cmp) {
        return resultCollection.stream().filter(a -> a.doubleValue() >= cmp).collect(Collectors.toList());
    }
}
