package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileWriter(문자기반 스트림) 예제
 * 
 * @author pc24
 *
 */
public class T07_FileWriterTest {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기

		// 콘솔(표준 입력장치)과 연결된 입력용 문자 스트림 생성
		// InputStreamReader => 바이트 기반(기본)스트림을 문자기반 스트림으로 변환해 주는 보조 스트림
		// InputStreamReader를 사용하려면 항상 기반 스트림이 존재해야 한다. 
		InputStreamReader isr = new InputStreamReader(System.in); 
		//in => inputStream(바이트 기반)이므로 문자 변환을 하기 위해  보조 스트림을 사용 

		FileWriter fw = null; // 파일 출력용 문자 기반 스트림

		try {
			// 파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("d:/D_Other/testChar.txt");
			int c;
			System.out.println("아무거나 입력하세요");

			// 콘솔에서 입력할 때 입력의 끝 표시는 Ctrl + z 키를 누르면 된다.
			while ((c = isr.read()) != -1) {
				//read()함수 호출해서 문자기반 스트림으로 변환 -> 문자가 깨지지 않게 처리 됨.
				fw.write(c); // 콘솔에서 입력받은 값을 파일에 출력하기

			}
			System.out.println("작업 끝...");

			isr.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
