package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}
