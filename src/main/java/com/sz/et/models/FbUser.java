package com.sz.et.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table( name = "FB_USER" )
public class FbUser implements IEntity{
	
	@JsonProperty("id")
	@Id
	@Column(name = "id")
	private String id;
	
	@JsonProperty("name")
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@Column(name = "phone")
	private String phone;
	
	public FbUser() {
	}

	@JsonIgnore
	public FbUser(String id) {
		setId(id);
	}

	@JsonIgnore
	public FbUser(String id, String name) {
		this(id);
		setName(name);
	}
	
	@JsonIgnore
	public FbUser(String id, String name, String phone) {
		this(id, name);
		setPhone(phone);
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString(){
		return "id=" + getId() + " name=" + getName() + " phone=" + getPhone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
