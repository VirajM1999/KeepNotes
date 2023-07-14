package com.app.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.NewNoteDto;
import com.app.dto.NotedeleteDto;
import com.app.dto.NotesUpdateDto;
import com.app.dto.ResponseApi;
import com.app.pojo.Notes;
import com.app.pojo.User;
import com.app.repository.NotesRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesrepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseApi addnewNotes(NewNoteDto newnote) {
		ResponseApi response = new ResponseApi();
		User user = userRepo.findById(newnote.getUserid()).orElseThrow();
		
		if(user == null) {
			response.setMessage("Invalid user trying to save note");
			response.setStatuscode(501);
			return response;
		}
		
		Notes newNote = new Notes(
			newnote.getTitle(),
			newnote.getDescription(),
			LocalDateTime.parse(newnote.getCreationTimestamp(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
			user
		);
		
		try {
			notesrepo.save(newNote);
			response = mapper.map(user, ResponseApi.class);
			response.setMessage("Notes added successfully");
			response.setStatuscode(200);
		} catch (Exception e) {
			response.setMessage("Notes adddition failed");
			response.setStatuscode(400);
		}
		return response;
	}

	@Override
	public ResponseApi updateNotes(NotesUpdateDto updatenote) {
		ResponseApi response = new ResponseApi();
		Notes updtnote=notesrepo.findById(updatenote.getNotesId()).orElseThrow();
		
		
		try {
			updtnote.setDescription(updatenote.getDescription());
			notesrepo.save(updtnote);
			response.setStatuscode(200);
			response.setMessage("note updated successfully");
			
		}
		catch(Exception e) {
			response.setStatuscode(400);
			response.setMessage("upadation failed");
		}
		return response;
	}

	@Override
	public ResponseApi deletenotes(NotedeleteDto deletenote) {
		ResponseApi response = new ResponseApi();
		User user=userRepo.findById(deletenote.getUserId()).orElseThrow();
		Notes note=notesrepo.findById(deletenote.getNoteId()).orElseThrow();
		try {
			user.removenote(note);
			userRepo.save(user);
			response.setStatuscode(200);
			response.setMessage("Notes deleted");
			
		} catch (Exception e) {
			response.setStatuscode(400);
			response.setMessage("invalid id to delete the notes");
		}
		return response;
	}

}
