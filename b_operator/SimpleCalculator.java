package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력 받아 연산결과를 아려주는 equal프로그램을 만들어라.        일종의 계산기 
		// 2개의 숫자와 개의 연산자를 쓸때 나오는 계산기 만드셍ㅁ
		     


		 Scanner scan = new Scanner(System.in);
		 
	     
	 
//	        System.out.print("첫 번째 계산할 값을 입력하세요: ");
//	        double one1 = Integer.parseInt(scan.nextLine()); 
//	       
//	        System.out.print("두 번째 계산할 값을 입력하세요: ");
//	        double two2 = Integer.parseInt(scan.nextLine()); 
//	        
//	        double sum = one1 + two2;
//	        double min = one1 - two2;
//	        double mul = one1 * two2;
//	        double div = one1 / two2;
//	        double res = one1 % two2;
//	        
//	        System.out.print("합: " + sum + 
//	                "차: " + min + 
//	                "곱: " + mul +
//	                "몫: " + div +
//	                "나머지: " + (int)res);
//	        
//	        System.out.print("첫 번째 계산할 값을 입력하세요: ");
//	        double one1 = Integer.parseInt(scan.nextLine()); 
//	       
//	        System.out.print("두 번째 계산할 값을 입력하세요: ");
//	        double two2 = Integer.parseInt(scan.nextLine()); 
//	        
//	        System.out.print("연산자를 입력하세요: ");
//	        String str = 
//	        
	      // 샘의 답 
	        
	        System.out.println("첫 번째 계산할 값을 입력하세요: ");
	        int x = Integer.parseInt(scan.nextLine()); 
	        System.out.println("연산자>");
	        String op = scan.nextLine();
	        System.out.println("두 번째 계산할 값을 입력하세요: ");
	        int y = Integer.parseInt(scan.nextLine()); 
	        
	        int result = op.equals("+") ? x + y
	        		: op.equals("-") ? x - y
	        	    : op.equals("*") ? x * y
	        	    : op.equals("/") ? x / y
	        	    : x % y;
	        System.out.println(x + " " + op + " " + y + " = " + result);
	        
	        
	      
	    }
	}

