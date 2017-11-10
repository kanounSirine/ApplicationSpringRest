package com.jcdecaux.kata.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.jcdecaux.kata.domain.DeveloppeurEntity;
import com.jcdecaux.kata.repositories.DeveloppeurRepository;
import com.jcdecaux.kata.service.DeveloppeurService;
import com.jcdecaux.kata.service.DeveloppeurServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class ServiceDeveloppeur {
	@InjectMocks
	  private DeveloppeurServiceImpl developpeurService;
	  @Mock
	 private DeveloppeurRepository developpeurDao ;
	  @Test
	public void loadAllDeveloppeurTest(){
		List<DeveloppeurEntity> listDev = new ArrayList<DeveloppeurEntity>();
		  Mockito.when(developpeurDao.findAll()).thenReturn(listDev);
		  Assert.assertEquals(developpeurService.loadAllDeveloppeur(),listDev);
	};
	@Test
	public void  findByIdDevellopeurTest(){
		
		Long id = (long) 1 ;
		DeveloppeurEntity developpeurEntity= new DeveloppeurEntity();
		 Mockito.when( developpeurDao.findById(id)).thenReturn(developpeurEntity);
		 Assert.assertEquals(developpeurService.findByIdDevellopeur(id),developpeurEntity);
		
		
	};
	@Test
	public void updateDeveloppeurTest(){
		Assert.assertFalse(developpeurService.updateDeveloppeur(null));
		DeveloppeurEntity currentDeveloppeur = new DeveloppeurEntity();
		
			Mockito.when( developpeurDao.save(currentDeveloppeur)).thenReturn(currentDeveloppeur);
			Assert.assertTrue(developpeurService.updateDeveloppeur(currentDeveloppeur));
		}
		
		
	

	


}
