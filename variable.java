package a_variable;//클래스의 위치

import java.util.Scanner;
//ctrl + shift + o

public class variable {//클래스 - ()가 붙은것

	public static void main(String[] args) {
	      //메서드 : 명령문의 집합
          //main메서드 : 프로그램의 시작과 끝을 나타냄
          		
		  //주석 :프로그램 코드로 인식하지 않는 문장(주로 코드설명에 사용)
		
		
		  //종류로는 한줄 주석  crtl +shift + C
          /* 범위주석 : Crtl + shit + /(해제 :\) */
		   
		
//		데이터
//		-기본형 :기본적인 숫자 
//		-배열 : 여러개의 기본형이 묶어서 사용 /같은 것에 대해서만 묶으수 있다
//		-클래스 : 
//
//		조작 
//		-산술 연산
//		-비교 연산
//		-논리 연산 (and or not)
//		-조건문
//		-반복문
//		
//		변수르 만드는 방법: 데이트의 형태(테이터 타입) + 이름
//		기본형 타입 
		
//		-정수: byte(1), short(2),*int(4), long(8)
//		-상수: float(4) 7자리까지 정확함, *doule(8)15자리까지 정확함
//		-문자: char(4)
//		-논리: boolean(1) 참과 거짓 
		
		int x; //정수를 자장할수 있는 x라는 이름을 가진 그릇을 만들어라.
		//변수를 만드는 것을 변수 선언이라고 표현한다
		
//		double x;//블럭()안에 이름을 중복할수 없다. 
		    // x 아래 빨간 줄은 컴파일 에러로 현제 번역이 불가능 하다 
		double y;
		
		//=(대입 연산자) : 오른쪽 값을 왼쪽의 변수에 저장
		x = 690;//초기화 : 변수에 처음으로 값을 저장하는 것
		y = 3.14; // 변수의 타입에 맞는 값을 저장해야한다.
	
		int abc = 30;//일반적으로 선언과 초기화를 한번에 한다.
		long l = 40L;  //접미사 L을 붙ㅇ야 long 타입이 된다
		float f = 5.5f; //접미사 f를 붙어야 float타입이 된다.
		char c = '한'; //따움표를 써야만 반드시 한글자를넣어야한다
		boolean b = true; // true, false
		
		int qwe = 20;
		long e = 30L;
		float q = 5.9f;
		double w = 40;
		char r = '주';
		boolean dsa = false;
		
		x = 20; //기존의 저장되어 있는 10이라는 값은 사라직 20이라는 갋이 저장 된다
		y = 5.5; 
		
		qwe = 60;
		e = 57L;
		q = 6.9f;
		w = 85;
		r = '극';
		dsa = true;
		
		// 콘솔창 출력
//		System.out.println(r);
		//실행 단축키 : ctrl + F11
//		System.out.println(100);
//		System.out.println(qwe);
//		System.out.println(e);
//		System.out.println(q);
//		System.out.println(w);
//		System.out.println(dsa);
		
		//문자열
//		String str = "문자 여러 ro..."; //크래스는 참조 형태타입 테이터이다.
//		System.out.println(str);
//		//문자열과 다른 타입의 데이터가 결합이 되면 문자열의 결과를 얻는다.
//		System.out.println(str + r);/// string+ 다른 타입의 문자열이합처지면 무조건 string으로 표현됨
//		System.out.println(str + qwe + q);
//		System.out.println(50 + 30 + str);// 반대로 문자열 + string 은   문자끼리 연ㅅㄴ 됨
//		///형변환
//		//다른 타입의 갋을 저장하기 위해서는 갋의 타입을 변경해 주어야 하는데 이를 ㅎㅇㅂㄴ환(type casting)이라 한다
//		int small = 0;
//		long big = 10L;
//		
//		small = (int)big;// 큰쪽에서작은쪽으로의 형변환은 데이터 손실의 가느엉이 이으므로 생략이 불가 하다
//	    big = small; // 표현범위가 작은쪽에서 큰쪽으로 형변환은 생략이 가능하다
//	    
//	    // 명령 규칙
//	    // 영문자 대소문자, 한글 , 숫자, 특수문자('_', '$') 를 사용할수 있다
//	    // 숫자로 시작 할수 없다
//	    // 예약어는 사용할수 없다
//	    // [낙타식 표기법을 사용한다.(mySamplVariable)] <- 2번쨰 이름 부터는 대문자를 사용한다
//	    // [클래스 명의 첫글자는 대문자로 한다.(MysampleClass)] 대괄호 2개는 반드시 지키지 않아도 되지만 개바자들끼리 암묵적인 약속이다
//	    
//	    /*상수
//	     * - 값을 변경 할수 없는 그릇
//	     * - 리터럴에 의미를 부여하기 위해 사용한다.
//	     *
//	     */
//	    final int MAX_NUMBER = 10; // final을 변수 아에 붙이면 값을 변경할수 없다
//	    
//	    
//	    //출력
//	    System.out.print("줄바꿈을 하지 않는다");
//	    System.out.println("줄바꿈을 한다");
//	    System.out.println("줄바꿈을 \t한다");  // 좀 긴 띄어쓰기가 됨
//	    System.out.print("줄바꿈을 한다.\n");  // \는 탈출 이스케이프를 뜻한다
//	    System.out.printf("문자열 : %s, 숫자: %d", "안녕", 10); // 출력 포맷을 지정한다
//	                       // %s는 문자를 뜻하고 %d는 숫자를뜻한다
	    //입력
//	    Scanner sc = new Scanner(System.in); //입력 받기 위한 클래스
//	    System.out.println("아무거나 입력해주세요");
//	    String str2 = sc.nextLine();
//	    System.out.println("입력받은 내용 : " + str2);
//	    //입력을 받게 되면 사용자가 입력 할 떄까지 프로그램이 멈추게 된다
//	    //내용을 입력 후 엔터를 치면 입력이 종료되고 프로그램이 다시 진행 된다
//	    
//	    System.out.println("int 입력>");
//	    int nextInt = sc.nextInt();
//	    System.out.println(nextInt);
//	    System.out.println("문자열 입력>");
//	    string nextLine = sc.nextLine();
//	    System.out.println(nextLine);
//	    System.out.println("입력끝!");
//	    
//		//숫자 입력
//	    System.out.println("int 입력>");
//	    int number = Integer.parseInt(sc.nextLine()); // Integer.parseInt  문자열을 숫자여로 바꿔주는 역활을 함 
//	    System.out.println(number);
//	    //위의 경우에는 문자가아닌 숫자만 입역을 해야함
	    
	    
	
//	    // 자신의 이름을 저장할 변수를 선언 
//		String myname;
//	    System.out.println("이름을 입력해 주세용");
//        String str2 = sc.nextLine();
//	    System.out.println("서주형 : 28 " + str2);
//	    // 위에 선언한 변수를 초기화 하기 위해 이름을 입력 받아 주세요
//	    int nextInt = sc.nextInt();
//	    System.out.println(nextInt);
//	    System.out.println("서주형");
//	    String nextLine = sc.nextLine();
//	    System.out.println(nextLine);
//	    System.out.println("입력끝!");
//정답    
	 // 자신의 이름을 저장할 변수를 선언 
//	    String myName;
//	 // 위에 선언한 변수를 초기화 하기 위해 이름을 입력 받아 주세요  
//	    System.out.println("이름을 입력 해 주세요");
//	    myName = sc.nextLine();
//	 // 자신의 나이를 저장할 변수를 선언해주세요.   
//	    int myAge;	
//	    
//	    
//	 //위에서 선언한 변수를 초기화 하기 위해 나이를 입력 받아주세요.
//	    System.out.println("나이를 입력해주세요>");
//	    myAge = Integer.parseInt(sc.nextLine()); 
//	    
//	    System.out.println("이름: " + myName + " / 나이: " + myAge);
//	 
	/// 이름과 나이를 바꿔서 만든 것 
	    
	    
//	    int myAge;	
//	    System.out.println("나이를 입력해주세요>");
//	    myAge = Integer.parseInt(sc.nextLine()); 
//	    String myName;
//	    System.out.println("이름을 입력 해 주세요");
//	    myName = sc.nextLine();
//	    System.out.println("이름: " + myName + " / 나이: " + myAge);
//	    
      //다음과 같은 프로그램을 작성 해 주세요

	    
//	    
//	    ------------------회원가입 ---------------  입력 받는 내용
//	    아이디> admin
//	    비밀번호(4자리 숫자 ) > 1234
//	   이름 > 홍길동 
//	   나이 > 99세
//	   키 > 185.5cm
//	   -------------------------------------- 다 입력 후에 출력 
//	     아이디: admin
//	    비밀번호 : 1234
//	   이름  : 홍길동 
//	   나이 : 99세
//	   키 : 185.5cm
//	   --------------------------------------
//	    
//	   과제 
	    Scanner sc = new Scanner(System.in); 
	    String myid;
	    System.out.println("아이디를 입력 해 주세요");
	    myid = sc.nextLine();
	    int mypass;	
	    System.out.println("비밀번호(4자리 숫자)를 입력해주세요");
	    mypass = Integer.parseInt(sc.nextLine()); 
	    String myName;
	    System.out.println("이름을 입력 해 주세요");
	    myName = sc.nextLine();
	    int myAge;	
	    System.out.println("나이를 입력해주세요");
	    myAge = Integer.parseInt(sc.nextLine()); 
	    int mybody;	
	    System.out.println("키를 입력해주세요");
	    mybody = Integer.parseInt(sc.nextLine()); 
	    System.out.println("아이디: " + myid);
	    System.out.println("비밀번호: " + mypass);
	    System.out.println("이름: " + myName);
	    System.out.println("나이: " + myAge);
	    System.out.println("키: " + mybody);   
	    System.out.println("아이디: " + myid + " / 비밀번호: " + mypass + "이름: " + myName + " / 나이: " + myAge);
			    	   	   	    	    
	    
	    
	}
	

}
