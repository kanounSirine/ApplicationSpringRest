 package com.jcdecaux.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcdecaux.kata.domain.LangageEntity;

public interface LangageRepository extends JpaRepository<LangageEntity, Long>{

	LangageEntity findById(Long id);

}
