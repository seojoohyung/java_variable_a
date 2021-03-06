package korail;

import java.io.Serializable;

/**
 * 개발자 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class DeveloperErm implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** TRAIN_ADMIN. */
	private  trainAdmin;

	/** USER_ADMIN. */
	private  userAdmin;

	/**
	 * 생성자.
	 */
	public DeveloperErm() {
	}

	/**
	 * TRAIN_ADMIN을 설정합니다..
	 * 
	 * @param trainAdmin
	 *            TRAIN_ADMIN
	 */
	public void setTrainAdmin( trainAdmin) {
		this.trainAdmin = trainAdmin;
	}

	/**
	 * TRAIN_ADMIN을 가져옵니다..
	 * 
	 * @return TRAIN_ADMIN
	 */
	public  getTrainAdmin() {
		return this.trainAdmin;
	}

	/**
	 * USER_ADMIN을 설정합니다..
	 * 
	 * @param userAdmin
	 *            USER_ADMIN
	 */
	public void setUserAdmin( userAdmin) {
		this.userAdmin = userAdmin;
	}

	/**
	 * USER_ADMIN을 가져옵니다..
	 * 
	 * @return USER_ADMIN
	 */
	public  getUserAdmin() {
		return this.userAdmin;
	}


}
