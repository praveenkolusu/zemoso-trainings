package builder;


public class Main {
    public static void main(String[] args) {
        new Payslip.builder()
                .basic(50000.0)
                .hRA(20000.0)
                .dA(15000.0)
                .build();
    }
}
