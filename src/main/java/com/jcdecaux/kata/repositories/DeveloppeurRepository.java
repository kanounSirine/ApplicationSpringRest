package com.jcdecaux.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcdecaux.kata.domain.DeveloppeurEntity;





public interface DeveloppeurRepository extends JpaRepository<DeveloppeurEntity, Long>{
	
	public DeveloppeurEntity findById(Long id);
	
}
