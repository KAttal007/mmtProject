package com.mmt.payment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class CardDetails { 
	@Id
	@Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?          # Visa\r\n"
			+ " |  (?:5[1-5][0-9]{2}                # MasterCard\r\n"
			+ "     | 222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}\r\n"
			+ " |  3[47][0-9]{13}                   # American Express\r\n"
			+ " |  3(?:0[0-5]|[68][0-9])[0-9]{11}   # Diners Club\r\n"
			+ " |  6(?:011|5[0-9]{2})[0-9]{12}      # Discover\r\n"
			+ " |  (?:2131|1800|35\\d{3})\\d{11}      # JCB\r\n"
			+ ")$")
	@NotBlank(message = "Card No is Mandatory for checkout")
	private String cardNo;
	@NotBlank(message = "Card Name is Mandatory for checkout")
	private String nameOnCard;
	@NotBlank(message = "Card Exp Month is Mandatory for checkout")
	private int expMonth;
	@NotBlank(message = "Card Exp Year is Mandatory for checkout")
	private int expYear;
	@NotBlank(message = "Card cvv is Mandatory for checkout")
	private int cvv;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
