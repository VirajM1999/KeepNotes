import React, { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function NotesDashboard() {
  const navigate = useNavigate();
  const [notesObj, setNotesObj] = useState([]);
  const [userObj, setUserObj] = useState({});

  useEffect(() => {
    //It is necessary to parse user object into JSON string.
    const user = JSON.parse(sessionStorage.getItem('user'));
    setUserObj(user);
    getAllNotes(user.id);
  },[]);

  const getAllNotes = (id) => {
    axios.get(`http://localhost:8080/user/notelist/${id}`)
    .then(
      res => {
        setNotesObj(res.data);
      }
    )
  }

  const deleteNote = (id) => {
    axios.post(`http://localhost:8080/notes/deletenotes`, {'userId' : userObj.id, 'noteId' : id})
    .then(
      res => {
        alert('Note deleted');
        getAllNotes(userObj.id);
      }
    );
  }

  var count = 0;
  var getHtmlForNotes = notesObj.map(note => {
    return (
      <tr>
        <td>{++count}</td>
        <td>{note.title}</td>
        <td>{note.description}</td>
        <td>{note.updationTimestamp.replace('T', ' ')}</td>
        <td><button >Edit</button></td>
        <td><button onClick={() => deleteNote(note.id)}>Delete</button></td>
      </tr>
    )
  })

  return (
    <div className='notesListDivParent'>
      <div className='notesListDiv'>
        <div>
          <button onClick={() => navigate("/newnote")} >New Note</button>
          <button onClick={() => navigate("/")} >Logout</button>
        </div>
        <table>
          <tbody>
            <tr>
              <th>Sr.No.</th>
              <th>Title</th>
              <th>Description</th>
              <th>Last Updated</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
            {getHtmlForNotes}
          </tbody>
        </table>
      </div>
    </div>
  )
}
