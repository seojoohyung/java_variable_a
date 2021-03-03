package practice_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class students {
	public static void main(String[] args) {
		
		List<Student> stuList =new ArrayList<Student>();
	    stuList.add(new Student(124601,"홍길동","80","90","40"));
	    stuList.add(new Student(124602,"변학도","70","80","65"));
		stuList.add(new Student(124603,"성춘향","54","91","77"));
		stuList.add(new Student(124604,"이순신","32","33","97"));
		stuList.add(new Student(124605,"강감찬","43","67","45"));
		stuList.add(new Student(124606,"일지매","36","60","94"));
		stuList.add(new Student(124607,"서주형","80","72","56"));
		
		
		System.out.println("정렬 전: ");
		for (Student stu : stuList) {
			System.out.println(stu);
			
		}
		System.out.println("====================");

		Collections.sort(stuList); // 정렬하기

		System.out.println("이름 오름 차순으로 정렬 후");
		for (Student stu : stuList) {
			System.out.println(stu.toString());
		}
		System.out.println("===========================");

		
//		//외부 정렬 기준을 이용한 정렬하기
//		Collections.sort(stuList,new SortNumDesc());
//		System.out.println("번호 내림차순 후 정렬 후");
//		for (Student stu : stuList) {
//			System.out.println(stu);
//		}
//	    System.out.println("=============================");
	}

	
	
}

class Student implements Comparable<Student>{

	 private int num;  //학번
	 private String name; //아름
	 private String kor;  //국어
	 private String eng;  //영어
	 private String math; //수학
	 private String sum;
	 
	 public Student(int num,String name,String kor,String eng,String math ) {
		 super();
		 this.num=num;
		 this.name=name;
		 this.kor=kor;
		 this.eng=eng;
		 this.math=math;
		 
	 }
	 
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

	@Override
	public int compareTo(Student stu) {
		
		return this.getName().compareTo(stu.getName()) * 1;
	}
	 
 }

