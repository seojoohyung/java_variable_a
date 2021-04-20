package kr.or.ddit.basic;

import java.awt.DisplayMode;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {

	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");

		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
			//f1이 존재하는지 확인하기 위해 exists를 호출
		}else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			
			try {
				if(f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "파일을 새로 만들었습니다.");
				}
			}catch (IOException ex) {	
				ex.printStackTrace();
			}
		}
		
		if(f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
		}
		System.out.println("---------------------------------------------");
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles();
		//파일 타입의 배열 files의 객체들을 파일 목록으로 리턴
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + " => ");
			if(files[i].isFile()) {
				System.out.println("파일");
			}else if(files[i].isDirectory()) {
				System.out.println("디렉토리");
			}
		}
		System.out.println("---------------------------------------------");
		String[] strFiles = f3.list();
		//파일 이름만 가져온다. 
		for (String str : strFiles) {
			System.out.println(str);
		}
		System.out.println("---------------------------------------------");
		System.out.println();
		
		//------------------------------------------------------------
		//출력할 디렉토리 정보를 갖는 File객체 생성
		File f4 = new File("d:/A_TeachingMaterial");
		
		displayFileList(f4); //파일목록 정보 조회
	}
	/**
	 * 지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	 * @param dir 목록을 보고자 하는 디렉토리
	 */
	private static void displayFileList(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "]" + " 디렉토리 내용");
		
		//디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		//하위 디렉토리 정보를 저장할 ArrayList 생성(File배열의 인덱스 저장)
		List<Integer> subDirList = new ArrayList<Integer>();
		//디렉토리인지 아닌지 구분하기 위해 
		
		//날짜를 출력하기 위한 형식 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = ""; //파일의 속성정보(읽기, 쓰기, 히든, 디렉토리 등)
			String size = ""; //파일 용량
			
			if (files[i].isDirectory()) {
				attr = "<DIR>"; //디렉토리로 세팅
				subDirList.add(i); //파일 배열에 디렉토리인 인덱스 정보를 저장
				//인덱스에 디렉토리를 저장해놓기 때문에 나중에 인덱스만 가져오면 디렉토리를 알 수 있음. 
			}else {
				//디렉토리가 아니면 파일
				size = files[i].length() + ""; //파일 사이즈
				attr = files[i].canRead() ? "R" : " "; //읽을 수 있으면 boolean R
				attr += files[i].canWrite() ? "W" : " "; // RW 읽고 쓸 수 있으면
				attr += files[i].isHidden() ? "H" : " "; //RWH 읽고 쓰고 히든이면
			}
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())),
					attr, size, files[i].getName());
		}// for문 끝...
		//%s: 문자, %5s : 문자 5개, %12s :문자 12개 !!!포맷(출력)부분을 줄을 맞춰 주기 위해서 사용!!!
		//default값이 우측정렬, -를 붙이면 좌측정렬 
		
		int dirCount = subDirList.size(); //폴더안의 하위폴더 개수 구하기
		int fileCount = files.length - dirCount; // 폴더안의 파일 개수
		
		System.out.println(fileCount + "개의 파일, " + dirCount + "개의 디렉토리");
		System.out.println();
		
		//윈도우에 없는 서브 디렉토리들도 출력해주려고 함. 
		for (int i = 0; i < subDirList.size(); i++) {
			// 하위 폴더의 내용들도 출력하기 위해 현재 메서드를 재귀호출하여 처리한다. 
			displayFileList(files[subDirList.get(i)]);
		}
	}

}









