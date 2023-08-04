package com.exams.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int seatCapacity;
	
	public Faculty() {
		super();
	}

	public Faculty(String name, int seatCapacity) {
		super();
		this.name = name;
		this.seatCapacity = seatCapacity;
	}

	public Faculty(int id, String name, int seatCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.seatCapacity = seatCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, seatCapacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return id == other.id && Objects.equals(name, other.name) && seatCapacity == other.seatCapacity;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", seatCapacity=" + seatCapacity + "]";
	}	
}
