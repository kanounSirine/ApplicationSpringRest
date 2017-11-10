package com.jcdecaux.kata.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.domain.LangageEntity;
import com.jcdecaux.kata.dto.DeveloppeurDto;
import com.jcdecaux.kata.service.DeveloppeurService;
import com.jcdecaux.kata.service.LangageService;

@RestController
public class IndexController {

	@Autowired
	private DeveloppeurService developpeurService;
	@Autowired
	private LangageService langageService;

	@RequestMapping(value = "/AllDeveloppeur")
	public List<DeveloppeurDto> showListDeveloppeur() {
		List<DeveloppeurDto> listDeveloppeurDto = new ArrayList<DeveloppeurDto>();
		DeveloppeurDto developpeurDto = new DeveloppeurDto();
		List<DeveloppeurEntity> developpeurList = developpeurService.loadAllDeveloppeur();

		developpeurList.forEach((k) -> {
			listDeveloppeurDto.add(developpeurDto.ConvertirDtoObject(k));
		});
		return listDeveloppeurDto;
	}

	@RequestMapping(value = "/Language/specif/{id}")
	public List<DeveloppeurDto> showListDeveByLang(@PathVariable("id") long id) {
		List<DeveloppeurDto> listDeveloppeurDto = new ArrayList<DeveloppeurDto>();
		DeveloppeurDto developpeurDto = new DeveloppeurDto();
		List<DeveloppeurEntity> langageList = langageService.recuperationListDev(id);
		if (langageList == null) {
			System.out.println("il y a pas des developpeur a cette langage ");
			return null;
		} else
			langageList.forEach((k) -> {
				listDeveloppeurDto.add(developpeurDto.ConvertirDtoObject(k));
			});
		return listDeveloppeurDto;
	}

	@RequestMapping(value = "/developpeur/{id}", method = RequestMethod.PUT)
	public void updateDeveloppeur(@PathVariable("id") long id, @RequestBody DeveloppeurEntity developpeur) {

		DeveloppeurEntity currentDeveloppeur = developpeurService.findByIdDevellopeur(id);
		if (developpeur == null) {
			System.out.println(" metre a jour n'est pas effectué ");
		} else {
			currentDeveloppeur.setFirstname(developpeur.getFirstname());
			currentDeveloppeur.setLastname(developpeur.getLastname());

			developpeurService.updateDeveloppeur(currentDeveloppeur);
			System.out.println(" metre a jour est effectué ");
		}

	}

	@RequestMapping(value = "/developpeur/", method = RequestMethod.POST)
	public void createDeveloppeur(@RequestBody List<DeveloppeurEntity> listDeveloppeur) {

		if (developpeurService.saveDeveloppeur(listDeveloppeur))

		{
			System.out.println("la listeDeveloppeur est creer");
		} else
			System.out.println("Conflit de creation ");
	}

	@RequestMapping(value = "/developpeur/{id}/langage/{id2}", method = RequestMethod.PUT, consumes = "application/json")
	public void associerDeveloppeur(@PathVariable("id") long id, @PathVariable("id2") long id2) {

		if (developpeurService.addLanguage(id, id2))

			System.out.println(" asscier un language  ");
		else
			System.out.println("il y a un conflit lors de l'association   ");

	}

	@RequestMapping(value = "/langage/", method = RequestMethod.POST)
	public void createLangage(@RequestBody List<LangageEntity> listLangage) {

		if (langageService.saveLangages(listLangage))

		{
			System.out.println("la liste des langages  est creer");
		} else
			System.out.println("Conflit de creation ");

	}

}
