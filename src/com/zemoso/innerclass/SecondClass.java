public class SecondClass {
	
	public class InheritedInnerClass extends OuterClass.InnerClass {
        public InheritedInnerClass(OuterClass outerObj, int inheritedValue) {
            outerObj.super(inheritedValue);
        }
        public int getInheritedValue() {
            return getInnerValue();
        }
    }
}
