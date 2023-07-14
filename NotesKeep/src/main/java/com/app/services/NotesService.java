package com.app.services;


import com.app.dto.NewNoteDto;
import com.app.dto.NotedeleteDto;
import com.app.dto.NotesUpdateDto;
import com.app.dto.ResponseApi;
public interface NotesService {

	ResponseApi addnewNotes(NewNoteDto newnotes);

	ResponseApi updateNotes(NotesUpdateDto updatenote);

	ResponseApi deletenotes(NotedeleteDto deletenote);
	
	

}
