package kr.or.ddit.comm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;

import kr.or.ddit.util.FileUploadRequestWrapper;

public class MultipartParser implements Filter{

	//메모리 임계 크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	
	//파일 1개당 최대 크기
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 40;
	
	//요청 파일 최대 크기
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 50;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {

		//리퀘스트래퍼 객체 생성
		FileUploadRequestWrapper requestWrapper;
		
		try {
			requestWrapper = new FileUploadRequestWrapper(
											(HttpServletRequest)req
											, MEMORY_THRESHOLD
											, MAX_FILE_SIZE
											, MAX_REQUEST_SIZE
											,"");
			
			//래퍼클래스 적용
			fc.doFilter(requestWrapper, resp);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
