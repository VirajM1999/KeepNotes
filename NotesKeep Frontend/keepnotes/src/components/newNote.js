import React, { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function NewNote() {
    const navigate = useNavigate();
    const [newNoteObj, setNewNoteObj] = useState({userid: '', title:'', description:''});


    useEffect(() => {
        const user = JSON.parse(sessionStorage.getItem('user'));
        setNewNoteObj({ ...newNoteObj, userid: user.id });
    },[]);

    const addnote = (event) => {
        event.preventDefault();

        axios.post('http://localhost:8080/notes/newnotes/', newNoteObj)
        .then(
            res => {
                if (res.data.statuscode === 200) {
                    alert(res.data.message);
                    navigate("/notesdashboard");
                }
                else if (res.data.statuscode === 501) {
                    alert(res.data.message);
                    setNewNoteObj({...newNoteObj, title: '', description: ''});
                }
            }
        )
    }
    const handleChange = (event) => {
        const { name, value } = event.target;
        setNewNoteObj({ ...newNoteObj, [name]: value });
    }

    return (
        <div className='newNoteDiv'>
            <h3>Create a New Note</h3>
            <form onSubmit={addnote}>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                Note Title
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="title" onChange={handleChange} value={newNoteObj.username} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Description
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <textarea name="description" rows={10} cols={30} onChange={handleChange} value={newNoteObj.name}></textarea>
                            </td>
                        </tr>
                        <tr className='formBtns'>
                            <td>
                                <input type="submit" value="Save" />
                                <button onClick={() => navigate("/notesdashboard")}>Back</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    )
}
