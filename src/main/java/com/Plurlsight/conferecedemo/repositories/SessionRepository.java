package com.Plurlsight.conferecedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Plurlsight.conferecedemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
