package exposed;

public class InnerClassExample {
	private int c = 0;
	public class InnerClass {
		private int a = 0;
		public void deneme2(){
			
		}
	}
	
	public void deneme(){
		
	}

	
	public static void main(String[] args) {
		InnerClassExample e = new InnerClassExample();
		InnerClassExample.InnerClass b = e.new InnerClass();
		
	}
	
	
}
