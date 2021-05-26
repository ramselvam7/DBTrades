package com.db.trade.Tradeflow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TradeDetails {	
	
	@Id
	@Column(name="TRADE_ID")
	private String tradeID;
	
	@Column(name="VERSION")	
	private int version;
	
	@Column(name="COUNTERPARTY_ID")
	private String counterPartyID;
	
	@Column(name="BOOK_ID")
	private String bookId;
	
	@Column(name="MATURITY_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date maturityDate;
	
	@Column(name="CREATED_DATE")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date createdDate;
	
	@Column(name="EXPIRED")
	private String expiredInd;
	
	
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyID() {
		return counterPartyID;
	}
	public void setCounterPartyID(String counterPartyID) {
		this.counterPartyID = counterPartyID;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpiredInd() {
		return expiredInd;
	}
	public void setExpiredInd(String expiredInd) {
		this.expiredInd = expiredInd;
	}
	
	
	@Override
	public String toString() {
		return "TradeDetails [ tradeID=" + tradeID + ", version=" + version + ", counterPartyID="
				+ counterPartyID + ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate="
				+ createdDate + ", expiredInd=" + expiredInd + "]";
	}
	
	

}
