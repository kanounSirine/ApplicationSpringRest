package com.jcdecaux.kata.service ;

import java.util.List;

import com.jcdecaux.kata.domain.DeveloppeurEntity;


public interface DeveloppeurService {
	List<DeveloppeurEntity> loadAllDeveloppeur();

	DeveloppeurEntity findByIdDevellopeur(Long id);

	Boolean updateDeveloppeur(DeveloppeurEntity currentDeveloppeur);

	Boolean saveDeveloppeur(List<DeveloppeurEntity> listDev);

	boolean isDeveloppeurExist(DeveloppeurEntity developpeur);
	boolean addLanguage(Long id,Long id2);

}
