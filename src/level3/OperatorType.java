package level3;

//TODO 1. Enum을 활용하여 코드 작성
public enum OperatorType {
    PLUS, MINUS, MULTI, DEVIDE, WRONG;

    public static OperatorType fromChar(char op) {
        switch (op) {
            case '+': return OperatorType.PLUS;
            case '-': return OperatorType.MINUS;
            case '*': return OperatorType.MULTI;
            case '/': return OperatorType.DEVIDE;
            default:  return OperatorType.WRONG;
        }
    }
}
