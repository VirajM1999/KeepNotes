package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
@CrossOrigin(origins = "http://localhost:3000/")
public class NotesController {
	
	@Autowired
	private NotesService notesservice;
	
	@PostMapping("/newnotes")
	public ResponseApi addnewNotes(@RequestBody NewNoteDto newnote){
			return (notesservice.addnewNotes(newnote));
	}
	
	@PostMapping("/updatenotes")
	public ResponseApi updateNotes(@RequestBody NotesUpdateDto updatenote) {
		return (notesservice.updateNotes(updatenote));
	}
	
	@PostMapping("/deletenotes")
	public ResponseApi deletenotes(@RequestBody NotedeleteDto deletenote ) {
		return (notesservice.deletenotes(deletenote));
	} 
	
	
	
	

}
