import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './components/login';
import Signup from './components/signup';
import NotesDashboard from './components/notesDashboard';
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route exact path='/' element={<Login/>}></Route>
        <Route exact path='/login' element={<Login/>}></Route>
        <Route exact path='/signup' element={<Signup/>}></Route>
        <Route exact path='/notesdashboard' element={<NotesDashboard/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
