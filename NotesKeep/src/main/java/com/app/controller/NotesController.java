package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.NewNoteDto;
import com.app.dto.NotedeleteDto;
import com.app.dto.NotesUpdateDto;
import com.app.dto.ResponseApi;
import com.app.services.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NotesService notesservice;
	
	@PostMapping("/newnotes")
	public ResponseApi addnewNotes(@RequestBody NewNoteDto newnote){
			return (notesservice.addnewNotes(newnote));
	}
	
	@PutMapping("/updatenotes")
	public ResponseApi updateNotes(@RequestBody NotesUpdateDto updatenote) {
		return (notesservice.updateNotes(updatenote));
	}
	
	@DeleteMapping("/deletenotes")
	public ResponseApi deletenotes(@RequestBody NotedeleteDto deletenote ) {
		return (notesservice.deletenotes(deletenote));
	} 
	
	
	
	

}
