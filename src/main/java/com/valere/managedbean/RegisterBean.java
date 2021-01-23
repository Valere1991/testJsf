package com.valere.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(value="registerBean")
@SessionScoped
public class RegisterBean<Kunde> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Kunde> listkunden;
	private Long id;
	private String vorname;
	private String name;
	private String str;
	private int plz;
	private String stadt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
	
	public void showNewKundePage(){
        System.out.println("Kunde angelegt");

	}
	
	
	public void loadData() {
		listkunden = new ArrayList<>();
	}
	
	public List<Kunde>getListkunden(){
		return listkunden;
	}
	
	
}