package AtmDesign;

public enum OperationType {
    CASH_WITHDRAWAL,
    BALANCE_INQUIRY,
    CHANGE_PIN,
    DEPOSIT;

    public static void showAllOperations() {
        for (OperationType operation : OperationType.values()) {
            System.out.println(operation);
        }
    }
}


