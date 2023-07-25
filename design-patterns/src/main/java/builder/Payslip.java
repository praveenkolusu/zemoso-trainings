package builder;

public class Payslip {
    private double basic;
    private double hra;
    private double da;
    // Add more components here if needed.

    private Payslip(builder builder) {
        this.basic = builder.basic;
        this.hra = builder.hra;
        this.da = builder.da;
        // Initialize other components if needed.
    }

    // Add getters for all components.
    public double getBasic() {
        return basic;
    }

    public double getHra() {
        return hra;
    }

    public double getDa() {
        return da;
    }

    // Nested static class for the builder.
    public static class builder {
        private double basic;
        private double hra;
        private double da;
        // Add more components here if needed.

        public builder basic(double basic) {
            this.basic = basic;
            return this;
        }

        public builder hRA(double hra) {
            this.hra = hra;
            return this;
        }

        public builder dA(double da) {
            this.da = da;
            return this;
        }

        // Add more methods to set other components if needed.

        // Build method to create the Payslip object.
        public Payslip build() {
            return new Payslip(this);
        }
    }

    // Example usage:

}