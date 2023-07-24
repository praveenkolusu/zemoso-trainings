package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayslipTest {

    @Test
    public void testPayslipBuilder() {
        Payslip payslip = new Payslip.builder()
                .basic(50000.0)
                .hRA(20000.0)
                .dA(15000.0)
                .build();

        assertEquals(50000.0, payslip.getBasic());
        assertEquals(20000.0, payslip.getHra());
        assertEquals(15000.0, payslip.getDa());
    }

    @Test
    public void testPayslipBuilderWithDefaultValues() {
        Payslip payslip = new Payslip.builder()
                .basic(50000.0)
                .build();

        assertEquals(50000.0, payslip.getBasic());
        assertEquals(0.0, payslip.getHra()); // Default value for HRA is 0.
        assertEquals(0.0, payslip.getDa());  // Default value for DA is 0.
    }

    @Test
    public void testPayslipBuilderWithNegativeValues() {
        Payslip payslip = new Payslip.builder()
                .basic(-50000.0)
                .hRA(-20000.0)
                .dA(-15000.0)
                .build();

        assertEquals(-50000.0, payslip.getBasic());
        assertEquals(-20000.0, payslip.getHra());
        assertEquals(-15000.0, payslip.getDa());
    }

}
