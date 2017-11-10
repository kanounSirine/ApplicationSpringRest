package com.jcdecaux.kata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;
import com.jcdecaux.kata.repositories.LangageRepository;

@Service
public class LangageServiceImpl implements LangageService {
	@Autowired
	private LangageRepository langageRepository;

	@Override
	public List<LangageEntity> loadAllLanguage() {

		return langageRepository.findAll();
	}

	@Override
	public boolean isLangageExist(LangageEntity langage) {
		if (langageRepository.findById(langage.getId()) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean saveLangages(List<LangageEntity> listLang) {
		if (listLang == null)
			return false;
		else

			listLang.forEach((k) -> {
				langageRepository.save(k);
			});

		return true;

	}

	@Override
	public LangageEntity findByIdLangage(Long theID) {

		return langageRepository.findById(theID);
	}

	@Override
	public boolean save(LangageEntity currentLangage) {
		if (currentLangage == null) {
			return false;
		} else {
			langageRepository.save(currentLangage);

			return true;
		}

	}

	@Override
	public List<DeveloppeurEntity> recuperationListDev(long id) {
		List<DeveloppeurEntity> listDev = new ArrayList<DeveloppeurEntity>();
		LangageEntity currentLanguage = langageRepository.findById(id);
		if (currentLanguage == null)
			return null;
		else if (currentLanguage.getDeveloppeurs() != null) {
			currentLanguage.getDeveloppeurs().forEach((k) -> listDev.add(k));
			return listDev;
		} else
			return null;

	}

	public LangageRepository getLangageRepository() {
		return langageRepository;
	}

	public void setLangageRepository(LangageRepository theLangageRepository) {
		langageRepository = theLangageRepository;
	}

}
