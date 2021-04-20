package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일 출력 예제
 */
public class T06_FileStreamTest {
	public static void main(String[] args) {
		//우리가 적은 데이터를 어떻게 파일로 관리할 것인지? 
		//파일에 저장하고 싶음 => FileOutputStream
		// 파일에 출력하기
		FileOutputStream fos = null;
		
		try {
			// 출력용 OutputStream객체 생성
			fos = new FileOutputStream("d:/D_Other/out.txt");
			
			for(char ch='a'; ch<='z'; ch++) { //char타입의 ch는 2바이트 'a'1바이트로도 충분히 처리가 가능하다.
				fos.write(ch);
			}
			System.out.println("파일에 쓰기 작업 완료...");
			
			// 쓰기 작업 완료 후 스트림 닫기
			fos.close();
			
			// 저장된 파일의 내용을 읽어와 화면에 출력하기
			FileInputStream fis = 
					new FileInputStream("d:/D_Other/out.txt");
			
			int c;
			while((c = fis.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
			System.out.println("출력 끝...");
			
			// 읽기 작업 후 스트림 닫기
			fis.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	
	}
}
