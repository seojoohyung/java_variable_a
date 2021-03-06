package korail;

import java.io.Serializable;

/**
 * 결제 모델 클래스.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class PayErm implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 결제 번호. */
	private  payNm;

	/** 고객. */
	private UserErm user;

	/** 결제방식. */
	private  payType;

	/** 환불. */
	private  payRefund;

	/**
	 * 생성자.
	 */
	public PayErm() {
	}

	/**
	 * 결제 번호을 설정합니다..
	 * 
	 * @param payNm
	 *            결제 번호
	 */
	public void setPayNm( payNm) {
		this.payNm = payNm;
	}

	/**
	 * 결제 번호을 가져옵니다..
	 * 
	 * @return 결제 번호
	 */
	public  getPayNm() {
		return this.payNm;
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

	/**
	 * 결제방식을 설정합니다..
	 * 
	 * @param payType
	 *            결제방식
	 */
	public void setPayType( payType) {
		this.payType = payType;
	}

	/**
	 * 결제방식을 가져옵니다..
	 * 
	 * @return 결제방식
	 */
	public  getPayType() {
		return this.payType;
	}

	/**
	 * 환불을 설정합니다..
	 * 
	 * @param payRefund
	 *            환불
	 */
	public void setPayRefund( payRefund) {
		this.payRefund = payRefund;
	}

	/**
	 * 환불을 가져옵니다..
	 * 
	 * @return 환불
	 */
	public  getPayRefund() {
		return this.payRefund;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payNm == null) ? 0 : payNm.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PayErm other = (PayErm) obj;
		if (payNm == null) {
			if (other.payNm != null) {
				return false;
			}
		} else if (!payNm.equals(other.payNm)) {
			return false;
		}
		return true;
	}

}
