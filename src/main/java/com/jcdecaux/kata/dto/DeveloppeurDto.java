package com.jcdecaux.kata.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;

public class DeveloppeurDto {
	private Long id;
	private String lastname;
	private String firstname;
	private Set<LangageEntity> langages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Set<LangageEntity> getLangages() {
		return langages;
	}

	public void setLangages(Set<LangageEntity> langages) {
		this.langages = langages;
	}

	public DeveloppeurDto ConvertirDtoObject(DeveloppeurEntity developpeurEntity) {
		Set<LangageEntity> listLang = new HashSet<LangageEntity>();
		DeveloppeurDto currentDeveloppeurDto = new DeveloppeurDto();

		currentDeveloppeurDto.setId(developpeurEntity.getId());
		currentDeveloppeurDto.setFirstname(developpeurEntity.getFirstname());
		currentDeveloppeurDto.setLastname(developpeurEntity.getLastname());
		if (currentDeveloppeurDto.getLangages() != null) {
			for (LangageEntity langEntity : currentDeveloppeurDto.getLangages())
				developpeurEntity.getLanguages().forEach((k) -> {
					langEntity.setName((k).getName());
				});
		} else

			currentDeveloppeurDto.setLangages(listLang);
		return currentDeveloppeurDto;

	}

}
