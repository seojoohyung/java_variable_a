package korail;

import java.io.Serializable;

/**
 * 새 테이블 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class CsServiceErm implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** QNA. */
	private  qna;

	/** SINGO. */
	private  singo;

	/** LOST_PACKAGE. */
	private  lostPackage;

	/** 고객. */
	private UserErm user;

	/**
	 * 생성자.
	 */
	public CsServiceErm() {
	}

	/**
	 * QNA을 설정합니다..
	 * 
	 * @param qna
	 *            QNA
	 */
	public void setQna( qna) {
		this.qna = qna;
	}

	/**
	 * QNA을 가져옵니다..
	 * 
	 * @return QNA
	 */
	public  getQna() {
		return this.qna;
	}

	/**
	 * SINGO을 설정합니다..
	 * 
	 * @param singo
	 *            SINGO
	 */
	public void setSingo( singo) {
		this.singo = singo;
	}

	/**
	 * SINGO을 가져옵니다..
	 * 
	 * @return SINGO
	 */
	public  getSingo() {
		return this.singo;
	}

	/**
	 * LOST_PACKAGE을 설정합니다..
	 * 
	 * @param lostPackage
	 *            LOST_PACKAGE
	 */
	public void setLostPackage( lostPackage) {
		this.lostPackage = lostPackage;
	}

	/**
	 * LOST_PACKAGE을 가져옵니다..
	 * 
	 * @return LOST_PACKAGE
	 */
	public  getLostPackage() {
		return this.lostPackage;
	}

	/**
	 * 고객을 설정합니다..
	 * 
	 * @param user
	 *            고객
	 */
	public void setUser(UserErm user) {
		this.user = user;
	}

	/**
	 * 고객을 가져옵니다..
	 * 
	 * @return 고객
	 */
	public UserErm getUser() {
		return this.user;
	}


}
