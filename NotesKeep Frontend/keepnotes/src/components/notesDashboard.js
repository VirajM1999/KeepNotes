import React, { useEffect, useState } from 'react';
// import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function NotesDashboard() {
  const [notesObj, setNotesObj] = useState([]);
  const [userObj, setUserObj] = useState([]);
  setUserObj(JSON.parse(sessionStorage.getItem('user')));

  useEffect(() => {
    //It is necessary to parse user object into JSON string.
    const user = JSON.parse(sessionStorage.getItem('user'));
    axios.get(`http://localhost:8080/user/notelist/${user.id}`)
    .then(
      res => {
        setNotesObj(res.data);
      }
    )
  },[]);

  const deleteNote = (id) => {
    axios.post(`http://localhost:8080/notes/deletenotes`, {'userId' : userObj.id, 'noteId' : id})
    .then(
      res => {
        alert('Note deleted');
      }
    );
  }

  var count = 0;
  var getAllNotes = notesObj.map(note => {
    return (
      <tr>
        <td>{++count}</td>
        <td>{note.title}</td>
        <td>{note.description}</td>
        <td>{note.updationTimestamp}</td>
        <td><button >Edit</button></td>
        <td><button onClick={() => deleteNote(note.id)}>Delete</button></td>
      </tr>
    )
  })

  return (
    <div className='notesListDiv'>
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
          {getAllNotes}
        </tbody>
      </table>
    </div>
  )
}
