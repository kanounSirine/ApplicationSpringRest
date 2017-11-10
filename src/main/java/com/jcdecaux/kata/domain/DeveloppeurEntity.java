package com.jcdecaux.kata.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name = "DEVELOPPEUR")
public class DeveloppeurEntity {
	
	
	
	  @Id
	  @GeneratedValue
	  @Column(name = "Id")

	  private Long id;

	  @Column(name = "Firstname")
	  private String firstname;
	  @Column(name = "Lastname")
	  private String lastname;
		
	  @ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable( name = "langage_dev", joinColumns = { @JoinColumn(name = "developpeur_id",referencedColumnName = "Id") }, 
	      inverseJoinColumns = { @JoinColumn(name = "langage_id", referencedColumnName = "Id") })
	  
	  private Set<LangageEntity> langages;
	  
	  public Set<LangageEntity> getLanguages() {
		return langages;
	}

	public void setLanguages(Set<LangageEntity> languages) {
		this.langages = languages;
	}

	public DeveloppeurEntity() {
	  }

	  public DeveloppeurEntity(String firstname, String lastname) {
	    this.firstname = firstname;
	    this.lastname = lastname;
	  }
	  public DeveloppeurEntity(Long id,String firstname, String lastname) {
		  this.firstname = firstname;
		    this.lastname = lastname;
		    this.id=id;
	  }

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getFirstname() {
	    return firstname;
	  }

	  public void setFirstname(String firstname) {
	    this.firstname = firstname;
	  }

	  public String getLastname() {
	    return lastname;
	  }

	  public void setLastname(String lastname) {
	    this.lastname = lastname;
	  }
	}

