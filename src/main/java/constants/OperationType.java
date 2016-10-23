package constants;

public enum OperationType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String value;
    private OperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
