package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03_ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		// 스트림 선언 및 객체 생성
		ByteArrayInputStream bais = null; //스트림 선언
		bais = new ByteArrayInputStream(inSrc); // 객체 생성
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int date; //읽어온 자료를 저장할 변수
		//read() 메서드 => byte단위로 자료를 읽어와 int형으로 변환한다.
		// 			  => 더 이상 읽어올 자료가 없으면 -1을 반환한다.
		
		while((date = bais.read()) != -1) {
			baos.write(date); //리턴받은 데이터 출력하기
		}
		
		//출력된 스트림 값들을 배열로 변환해서 반환하는 메서드
		outSrc = baos.toByteArray();
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		try {
			//스트림 객체 닫아주기
			bais.close();
			baos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
