package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01_FileTest {
	public static void main(String[] args) throws IOException {
		
		/*
		 * 파일 객체 만들기 연습
		 * 1. new File(String 파일 또는 경로)
		 * => 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 '\'를 사용하거나 '/'를 사용할 수 있다.
		 */
		//File file = new File("d:/D_Other/test.txt");
		File file = new File("d:\\D_Other\\test.txt"); /* \를 의미 \\를 써야 \인식*/
		//경로 안에 있는 test.txt를 핸들링하기 위한 File객체 생성 
		System.out.println("파일명: " + file.getName());
		//파일의 이름을 얻음. getName
		System.out.println("파일 여부: " + file.isFile());
		//디렉토리인지 파일인지 구분할 때 사용 => isFile() isDirectory
		System.out.println("디렉토리(폴더) 여부: " + file.isDirectory());
		
		//파일여부 : false, 디렉토리여부 : false => 파일이 존재하지 않는 것.
		//test.txt파일 생성 후 파일여부 : true   !!!직접 파일, 폴더에 가지 않아도 자바 프로그램에서 확인 가능!!!!
		//test.txt를 자바 프로그램 상에서 핸들링을 할 것임. 
		System.out.println("--------------------------------------------");
		
		File file2 = new File("d:/D_Other");
		//File file2 = new File("d:/D_Other/test.txt");
		System.out.print(file2.getName() + "은 ");
		if(file2.isFile()) {
			System.out.println("파일");
		} else if(file2.isDirectory()) {
			System.out.println("디렉토리(폴더)");
		}
		System.out.println("--------------------------------------------");

		//2. new File(File parent, String child)
		// => 'parent'디렉토리 안에 있는 'child'파일 또는 디렉토리를 말한다.
		File file3 = new File(file2, "test.txt");
		//첫번째 파라미터 :파일 객체, 두번째 파라미터 : String 
		
		System.out.println(file3.getName() + "의 용량 크기: "
				+ file.length() + "bytes");
		//file.length => 파일의 용량 단위 [bytes]
		
		//3. new File(String parent, String child)
		File file4 = new File("d:/D_Other", "test.txt");
		//첫번째 파라미터 : String, 두번째 파라미터 : String 
		
		System.out.println("절대 경로: " + file4.getAbsolutePath());
		//절대 경로란 관측자가 어디에 있는 동일한 경로로 나오는 것 => root C: ~~ D: ~~ [window]
		//상대 경로란 관측자 기준인 경로 (다른 사람과 경로가 다를 수 있음) => .이나 ..으로 시작 
		
		System.out.println("경로 : " + file4.getPath());
		System.out.println("표준 경로 : " + file4.getCanonicalPath());
		//표준 경로 : 최종으로 계산된 경로
		System.out.println("현재 클래스의 URL : " + T01_FileTest.class.getResource("T01_FileTest.class"));
		//file:\D ~~ file 프로토콜
		System.out.println("--------------------------------------------");
		
		//현재 클래스의 절대 경로를 가져오기
		System.out.println("현재 클래스의 절대경로 가져오기 : " + T01_FileTest.class.getResource("").getPath());
		
		/*
		 * 디렉토리(폴더) 만들기
		 * 
		 * 1. mkdir() => File객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		 * 			  => 중간의 경로가 모두 미리 만들어져 있어야 한다.
		 * 
		 * 2. mkdirs() => 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 디렉토리를 만들어 준다.
		 * 			   => 위 두 메서드 모두 만들기를 성공하면 true, 실패하면 false 반환
		 * 
		 */
		File file5 = new File("d:/D_Other/연습용");
		if(file5.mkdir()) {
			System.out.println(file5.getName() + " 만들기 성공!");
			//성공하면  true리턴
		}else {
			System.out.println(file5.getName() + " 만들기 실패!!!");
			//실패하면 false리턴
		}
		System.out.println();
		
		File file6 = new File("d:/D_Other/test/java/src");
		if(file6.mkdirs()) {
			System.out.println(file6.getName() + " 만들기 성공!");
			//성공하면  true리턴
		}else {
			System.out.println(file6.getName() + " 만들기 실패!");
			//실패하면 false리턴
		}
	}
}
