import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from 'axios';

export default function Login() {
    sessionStorage.clear();
    const navigate = useNavigate();
    const [loginObj, setLoginObj] = useState({ username: '', password: '' })

    const loginUser = (event) => {
        event.preventDefault();  //
        axios.post('http://localhost:8080/user/login/', loginObj)
        .then(
            res => {
                if (res.data.statuscode === 200) {
                    alert(res.data.message);
                    sessionStorage.setItem('user', JSON.stringify({
                        'id' : res.data.userid,
                        'username' : res.data.username,
                        'name' : res.data.name
                    }))
                    navigate("/notesdashboard");
                }
                else if (res.data.statuscode === 502) {
                    alert(res.data.message);
                    setLoginObj({...loginObj, username : '', password : ''});
                    //reset username and password
                }
                else if (res.data.statuscode === 501) {
                    alert(res.data.message);
                    setLoginObj({...loginObj, password : ''});
                    //reset password
                }
            }
        )
    }

    const handleChange = (event) => {
        const { name, value } = event.target;
        setLoginObj({ ...loginObj, [name]: value });
    }

    return (
        <div className='loginDiv'>
            <form onSubmit={loginUser}>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                Username:
                            </td>
                            <td>
                                <input type="text" name="username" onChange={handleChange} value={loginObj.username} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Password:
                            </td>
                            <td>
                                <input type="password" name="password" onChange={handleChange} value={loginObj.password} />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Login"/>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} className='signupLink'>
                                <a href="/signup">New user? SignUp!</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    )
}
