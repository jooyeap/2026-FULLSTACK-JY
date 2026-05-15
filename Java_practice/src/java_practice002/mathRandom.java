package java_practice002;

public class mathRandom {
	public static void main(String[] args) {
//		double b = 0;
//		b = Math.random();
//		System.out.println(b);
		
		/*
		  	1. Math.random() 이 뱉는 값의 범위
		 	0.0 <= value < 1.0
		 	
		 	2. 아래 Math.random()에 21 곱하면 범위
		 	(Math.random() * 21)
		 	음수 10개, 0 1개, 양수 10개 = 21개
		 	0.0 <= value < 21.0
		 	
		 	3. 음수 10개, 0 1개, 양수 10개 이렇게 설정해야하기때문에
		 	범위값을 재조정
		 	(Math.random() * 21 - 10)
		 	-10.0 <= value < 11.0
		 	
		 	4. 이제 뱉은 값을 백분율로 반환
		 	(Math.random() * 21 - 10) / 100
		 	예 ) 8이란 숫자가 나오면 -> 0.08 을 뱉게, -3이란 숫자가 나오면 -0.03을뱉게
		 	
		 	5. 값 적용
		 	기존 가격을 A라고 하고
		 	4번에서 나온 값을 B 라고하면
		 	
		 	식 ) A += (A * B)
		 	A = 100
		 	B = 0.08
		 	100 += (100 * 0.8) -> 8 뱉으니까
		 	결과값 108
		 	
		*/
		
		for(int i=0; i<5; i++) {
			// a = Math.random(); // 호출 할때마다 값 새로들어감
			double a = 10000;
			double b = Math.random();
			double c = ((b*21 - 10) / 100);
			double d = a*c;
			
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			System.out.println();
			
//			b = (Math.random() * 21 - 10) / 100 ;
			
			
		}
	}	
}	
