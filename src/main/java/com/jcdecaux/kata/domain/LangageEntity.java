package com.jcdecaux.kata.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LANGAGE")
public class LangageEntity implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 8929505852505990733L;

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "langages")
    private Set<DeveloppeurEntity> developpeurs;

    public Set<DeveloppeurEntity> getDeveloppeurs()
    {
        return developpeurs;
    }

    public void setDeveloppeurs(Set<DeveloppeurEntity> developpeurs)
    {
        this.developpeurs = developpeurs;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LangageEntity()
    {
    }

    public LangageEntity(String name)
    {
        this.name = name;

    }

    public LangageEntity(Long id, String name)
    {
        this.id = id;
        this.name = name;

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}