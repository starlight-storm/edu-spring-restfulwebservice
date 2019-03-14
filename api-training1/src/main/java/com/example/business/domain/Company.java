package com.example.business.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "company")
@XmlAccessorType(XmlAccessType.NONE)
public class Company {
	@XmlAttribute
	private int companyId;
	@XmlElement
	private String name;
	
	public Company() {}
	
	public Company(int companyId, String name) {
		super();
		this.companyId = companyId;
		this.name = name;
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
