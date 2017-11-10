package com.jcdecaux.kata.service ;

import java.util.List;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;

public interface LangageService {
	boolean isLangageExist(LangageEntity langage);
	boolean saveLangages(List<LangageEntity> listLang);
	List<LangageEntity> loadAllLanguage();
	LangageEntity findByIdLangage(Long theID);
	boolean save(LangageEntity currentLangage);
	List<DeveloppeurEntity> recuperationListDev(long id);
}
