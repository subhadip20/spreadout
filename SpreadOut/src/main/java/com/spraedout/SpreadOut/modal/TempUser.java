package com.spraedout.SpreadOut.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tempuser")
public class TempUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335131624433308794L;
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tempuser_seq")	
	 @SequenceGenerator(name = "tempuser_seq", sequenceName = "tempuser_seq", allocationSize = 1)
	private long id;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "verificationcode")
	private String verificationCode;
	@Column(name = "timecode")
	private String timestampcode;
	@Column(name = "verify")
	private boolean  verify;
	
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getTimestampcode() {
		return timestampcode;
	}
	public void setTimestampcode(String timestampcode) {
		this.timestampcode = timestampcode;
	}
	

}
