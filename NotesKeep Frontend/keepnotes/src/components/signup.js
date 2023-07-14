import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function Signup() {
    sessionStorage.clear();
    const navigate = useNavigate();
    const [signupObj, setSignupObj] = useState({name:'', username:'', password:''})

    const signupuser = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/user/newuser/', signupObj)
        .then(
            res => {
                if (res.data.statuscode === 200) {
                    alert(res.data.message);
                    navigate("/login");
                }
                else if (res.data.statuscode === 501) {
                    alert(res.data.message);
                    setSignupObj({...signupObj, username: '', password: ''});
                }
            }
        )
    }
    const handleChange = (event) => {
        const { name, value } = event.target;
        setSignupObj({ ...signupObj, [name]: value });
    }

    return (
        <div className='signupDiv'>
            <form onSubmit={signupuser}>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                Username:
                            </td>
                            <td>
                                <input type="text" name="username" onChange={handleChange} value={signupObj.username} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Name:
                            </td>
                            <td>
                                <input type="text" name="name" onChange={handleChange} value={signupObj.name} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Password:
                            </td>
                            <td>
                                <input type="password" name="password" onChange={handleChange} value={signupObj.password} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Submit" />
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} className='loginLink'>
                                <a href="/login">Already an user? Login!</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    )
}
