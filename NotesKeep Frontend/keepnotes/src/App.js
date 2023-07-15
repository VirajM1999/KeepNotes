import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/login';
import Signup from './components/signup';
import NotesDashboard from './components/notesDashboard';
import NewNote from "./components/newNote";
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route exact path='/' element={<Login/>}></Route>
        <Route exact path='/login' element={<Login/>}></Route>
        <Route exact path='/signup' element={<Signup/>}></Route>
        <Route exact path='/notesdashboard' element={<NotesDashboard/>}></Route>
        <Route exact path='/newnote' element={<NewNote/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
