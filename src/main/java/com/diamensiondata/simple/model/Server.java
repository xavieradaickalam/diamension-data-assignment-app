package com.diamensiondata.simple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SERVER")
@XmlRootElement(name = "server")
public class Server {

	@Id
	@Column(name = "id")
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Server [id=" + id + ", name=" + name + "]";
	}
}