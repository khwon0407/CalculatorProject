package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Number> resultCollection = new ArrayList<>();

    //TODO 2. generic을 활용하여 정수와 실수 모두에 대응되는 calculate 메서드 작성
    public <S extends Number> Optional<S> calculate(S first, S second, OperatorType op) {
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

        if(resultOptional.isPresent()) {
            this.resultCollection.add(result); //계산 결과 저장
        }

        return resultOptional;
    }

    public static int isIntDouble(String numStr) {
        try {
            Integer.parseInt(numStr);
            return 1;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(numStr);
                return 2;
            } catch (NumberFormatException ex) {
                return 0;
            }
        }
    }

    public Number getResult(int idx) throws Exception {
        try {
            return this.resultCollection.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception();
        }
    }

    public List<Number> getResultCollection() {
        return resultCollection;
    }

    public void setResultCollection(int idx, Number number) throws Exception {
        try {
            this.resultCollection.set(idx, number);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception();
        }
    }

    public void removeResult() {
        try {
            resultCollection.remove(0);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("저장된 계산 결과 값이 없습니다.");
        }
    }

    //TODO 3. filter와 lambda를 활용하여 특정 수보다 큰 결과값을 모두 불러오는 기능
    public List<Number> getMoreThanNum(double cmp) {
        return resultCollection.stream().filter(num -> num.doubleValue() > cmp).collect(Collectors.toList());
    }
}
