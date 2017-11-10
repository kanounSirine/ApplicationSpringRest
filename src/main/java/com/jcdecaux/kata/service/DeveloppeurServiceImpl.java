package com.jcdecaux.kata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;
import com.jcdecaux.kata.repositories.DeveloppeurRepository;
import com.jcdecaux.kata.repositories.LangageRepository;

@Service
public class DeveloppeurServiceImpl implements DeveloppeurService {

	@Autowired
	private DeveloppeurRepository developpeurRepository;
	@Autowired
	private LangageRepository langageRepository;

	@Override
	public List<DeveloppeurEntity> loadAllDeveloppeur() {
		
		return developpeurRepository.findAll();
	}

	@Override
	public DeveloppeurEntity findByIdDevellopeur(Long theId) {

		return developpeurRepository.findById(theId);
	}

	@Override
	public Boolean updateDeveloppeur(DeveloppeurEntity currentDeveloppeur) {
		if (currentDeveloppeur == null) {
			return false;
		} else {
			developpeurRepository.save(currentDeveloppeur);
			return true;
		}

	}

	@Override
	public Boolean saveDeveloppeur(List<DeveloppeurEntity> listDev) {
		if (listDev == null)
			return false;
		else

			listDev.forEach((k) -> {
				developpeurRepository.save(k);

			});

		return true;

	}

	@Override
	public boolean isDeveloppeurExist(DeveloppeurEntity developpeur) {
		if (developpeurRepository.findById(developpeur.getId()) != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean addLanguage(Long Id, Long Id2) {
		DeveloppeurEntity developpeur = developpeurRepository.findById(Id);
		LangageEntity langage = langageRepository.findById(Id2);
		if (langage == null || developpeur == null)
			return false;
		else {

			developpeur.getLanguages().add(langage);
			updateDeveloppeur(developpeur);
			return true;
		}

	}

}
