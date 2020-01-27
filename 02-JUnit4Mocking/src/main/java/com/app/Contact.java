package com.app;

public class Contact {

	private Integer id;
	private String name;
	private Long mobileNo;

	public Contact(Integer id, String name, Long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}

}
