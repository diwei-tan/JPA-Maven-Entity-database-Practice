package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Members")
@IdClass(MemPK.class)
public class Member implements Serializable {
	
	private int memberNo;
	@Id
	private String surname;
	@Id
	private String firstname;
	@Column(name="SECOND_NAME")
	private String secondname;
	
	public Member() {
		
	}
	public Member (String surname, String firstname, String secondname) {
		this.surname=surname;
		this.firstname=firstname;
		this.secondname=secondname;
	}

	public Member(int membershipNum, String surname, String firstname, String secondName) {
		this.memberNo=membershipNum;
		this.surname=surname;
		this.firstname=firstname;
		this.secondname=secondName;
	}
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	
	public void show() {
		System.out.println(this.toString());
	}
	public String toString() {
		return surname + " " + firstname + " " + secondname;
	}
	public int getMemberNo() {
		// TODO Auto-generated method stub
		return memberNo;
	}

}
