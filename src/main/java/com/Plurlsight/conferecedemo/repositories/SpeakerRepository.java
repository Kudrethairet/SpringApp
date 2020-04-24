package com.Plurlsight.conferecedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Plurlsight.conferecedemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
