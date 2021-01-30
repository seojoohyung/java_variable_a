package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
//		조작 
//		-산술 연산
//		-비교 연산
//		-논리 연산 (and or not)	

		/*
		 * 산술 연산자
		 * - 사칙 연산자 : +, - *, /, %(나머지)
		 * - 복합 연산자 : +=, -=, *=, /=, %=
		 * - 증감 연산자 : ++, --
		*/
		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
		
		//나머지 연산
		result = 10 / 3;
		System.out.println(result);
		result = 10 % 3; //소수점 아래의 숫자까지는 나오지 않는다
		System.out.println(result);
		
		//5개의 산술 연산자를 사용해 5개의 연산을 수행 후 출력해 주세요.
		result = 100 + 52;
		System.out.println(result);
		result = 52 - 100;
		System.out.println(result);
		result = 52 * 100;
		System.out.println(result);
		result = 133 / 100;
		System.out.println(result);
		result = 33 % 100;
		System.out.println(result);
		
		//복합연산자
		//변수에 ㅈ장되어 있는 값에 연산을 수행 할떄 수행할 연산자와 대입연산자를 결합해 사용 할수 있다
		result += 3;
		System.out.println(result);
		result = result + 3;
		System.out.println(result);
		result -= 5;
		System.out.println(result);
		result *= 2;
		System.out.println(result);		
		
		//아래의 문장을 복합 연산자를 사용한문장으로 만들어 줏세요
		//result = redult + 10;
		result += 10;
		
		//result = redult - 2 * 3;
		result -= 2 * 3;
		
		//result = redult % 5;
		result %= 5;
		
		//증가연산자
		//증감연산자(++) : 변수의 값을 1 증가 시킨다
		//감소요연산자(--) 
		int i = 0;
		++i;//전위 형 : 변수의 값을 읽어 오기 까지 전에 1 증가한다
		i++; // 후위형: 변수의 갋을 을 읽어 본 후에 1증가
		--i;
		i--;
		
		i =0;
		System.out.println("++i = " + ++i);
		i =0;
	    System.out.println("i++ = " + i++);
	    System.out.println(i);
	    
	    
	    //피연산자의 타입이 서로 같아야만 연산이 가능하다.
	    int _int = 10;
	    double _double = 3.14;
	    double result2 =(double)_int + _double; // 표현범위가 더 큰 타입으로 형변화 한다.
	    System.out.println(result2);     // 작은 쪽에서 큰쪽으로 형변환은 삭제가 가능 하다.
	    
	    long _long = 100L;
	    _long = _int + _long;
	    _int = _int + (int)_long;
	    
	    byte _byte = 5;
	    short _short = 10;
	    int result3 = _byte + _short; //int 보다 작은 타입은 int로 형변환 한다
		System.out.println(result3);
		
		char _char = 'a';
		char _char2 = 'b';   //아스키코드표 로 문자의 숫자화를 확인 하도록
		_int = _char + _char2;
		System.out.println(_int);
		
		
	    //오버플로우, 언더 플로우
		//표현 범위를 벗어나는 갋을 표현할때 발생하는 현상
		byte b = 127;
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
		
		//다으을 한줄씩 계산 해서 최종 결과 걊을 출력 해 주세요
		//1. 123456+ 654321
		//2. 1ㅓㄴ의 결과값 + 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 123456
		//5. 4번의 결과값 % 123456
		
//	     나의 답
	     int _int12= 123456;
	     int _int34= 654321;
	     int result11 = _int12 + _int34;
	     System.out.println(result11);
	     int result12 = result11 + _int12;
	     System.out.println(result12);
	     
		long res = 123456 + 654321;
		res *= 123456;
		res /= 123456;
		res -= 654321;
		res %= 123456;
		System.out.println(res);
		
		//3개의 int 항 변수를 선언 및 초기화 후  합계와 평균을 구하라
		//나의 답
		int _int33 = 153;
		int _int36 = 585;
		int _int35 = 584;
		int res1 = _int33 + _int36 + _int35;
		res1 += 0;
		res1 /= 3;
		System.out.println(res1);
		
		///답
		int num1 = 15;
		int num2 = 34;
		int num3 = 49;
		int sum = num1 + num2 + num3;
		double avg = sum / 3;
		System.out.println(avg);  //현제 모든 답이 int 임으로 소수점을 보이지 않는다
		
		
//		int sum = num1 + num2 + num3;
//		double avg = sum / 3.0;  //   3뒤에 0.0 을 붙여준다
//		System.out.println(avg);
//		
		// 반올림
		avg = Math.round(avg); // 소숮ㅁ 첫째 자리에서 반올림
		System.out.println(avg); // 만약 소수점 2째자리 이상을 보고 싶다면 소수점의 위치를 변경하는 방법으로 
		avg = Math.round(avg * 10) / 10.0;
		System.out.println(avg);
		
		
		
		
		
		
		
	}

}
