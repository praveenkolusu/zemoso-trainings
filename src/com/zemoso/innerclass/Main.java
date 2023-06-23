public class Main {
		
		public static void main(String[] args) {
	        OuterClass outerObj = new OuterClass(10);
	        OuterClass.InnerClass innerObj = outerObj.new InnerClass(20);
	        
	        System.out.println("Outer value: " + outerObj.getOuterValue());
	        System.out.println("Inner value: " + innerObj.getInnerValue());
	        
	        SecondClass.InheritedInnerClass inheritedObj = new SecondClass().new InheritedInnerClass(outerObj, 30);
	        
	        System.out.println("Inherited value: " + inheritedObj.getInheritedValue());
	    }
}