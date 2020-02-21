package com.kh.searchfree.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;

public class EncryptWrapper extends HttpServletRequestWrapper {
	// 상속받은 HttpServletRequestWrapper 클래스는 기본 생성자가 없음
	// 반드시 명시적으로 HttpServletRequest를 매개변수로 하는 생성자 작성이 필수!
	
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		// String key : 모든 input 태그들의 값이 순서대로 한번씩 넘어옴
		// 요청 데이터의 key에 대응되는 value를 저장할 변수 선언
		String value = "";
		//input 태그에 name속성이 있으면서 ,
		// 회원가입시 비밀번호, 비밀번호 변경시, 회원탈퇴시 비밀번호
		if(key != null && 
				(key.equals("memberPwd") || 
				key.equals("pwd1") || 
				key.equals("currentPwd") ||
				key.equals("newPwd1") ||
				key.equals("inputPwd"))) {

			// 암호화 진행 -> SHA-512  해시함수 암호화
			// 해시함수란 ?
			// 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수
			// SHA-숫자 길이만큼 고정된 길이의 크기가 다름 
			
			value = getSha512(super.getParameter(key));
		} else { 
			value = super.getParameter(key);
		}
	
		
		return value;
	}
	// 그러면 최상위 ServletRequestWrapper 클래스 상속받으면되는거아닌가?
	// ServletRequestWrapper클래스에는 Http로 전달된 것 말고도 다른것 들을 다룰 수 있음
	// 현재 파라미터들은 HttpServlet을 통해서 전달되는 것이기 때문에
	// 암호화하려는 request를 얻기위해서 HttpServletRequestWrapper를 상속받는 것
	// 하지만 파라미터값을 가져오는 기능들은 ServletRequestWrapper에 있기때문에 
	// EncryptWrapper의 슈퍼생성자에 HttpServletRequestWrapper 클래스의 request를 
	// 전달하여 초기화하는 것
	// super() : ServletRequestWrapper 클래스의 생성자
	
	
	
	// ServletRequestWrapper 의 getParameter()(input태그의 value를 얻어옴)
	// 오버라이딩해서 값을 가져옴
	// 무엇을 오버라이딩해야할 지 모를 떄 alt + shift + s -> override implement methods
	// -> 
	
	/**SHA-512 해시함수를 사용하여 암호화하는 메소드
	 * @param pwd
	 * @return encPwd
	 */
	public static String getSha512(String pwd) {
		String encPwd = null;
		
		MessageDigest md = null;
		// -> 지정된 알고릐즘에 따라 해시 함수를 진행하는 클래스
		
		try {
			// 원하는 알고리즘을 꺼내오기
			// MessageDigest.getInstance("알고리즘명")
			// 지정된 알고리즘을 사용해 MessageDigest 객체를 작성하여 반환
			md = MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// 암호화를 진행하기 위해서는 
		// 전달받은 문자열(비밀번호)를 바이트 배열로 변환해야 함.
		byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
		
		// md객체에 pwd 바이트배열을 전달하여 갱신
		// -> 실제 암호화 (해시함수) 진행
		md.update(bytes);
		
		// 인코더가 어떤 작업을 하는 건지 
		// java.util.Base64 인코더 (자바에서 기본제공 )를 이용해서
		// 암호화된 바이트 배열을 인코딩해서 문자열로 출력
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		// getEncoder(): Base64의 싱글톤 패턴 
		// Base64(MessageDigest.getInstance("SHA-512")로 가져온 암호화 알고리즘이 세팅되어 있음
		// )클래스의 객체를 생성
		// .encodeToString(md.digest()) : 생성된 객체의 메소드를 사용하는데 , 
		// 						encode( 코드화된 값들을 문자열로 리턴)
		// 						그 문자열들은 sha-512로 해시화된 값들임.
		
		System.out.println("암호화 전 : "+ pwd );
		System.out.println("암호화 후 : "+ encPwd);
		
		return encPwd;
	}
}
