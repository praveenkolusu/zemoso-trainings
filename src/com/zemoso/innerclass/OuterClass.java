public class OuterClass {
	
private int outerValue;
    
    public OuterClass(int outerValue) {
        this.outerValue = outerValue;
    }
    
    public int getOuterValue() {
        return outerValue;
    }
    
    public class InnerClass {
        private int innerValue;
        
        public InnerClass(int innerValue) {
            this.innerValue = innerValue;
        }
        
        public int getInnerValue() {
            return innerValue;
        }
    }
}
