import './App.css';
import AppBar from './components/Appbar';
import Register from './components/Register';
import { Home } from './components/Home';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LogIn from './components/LogIn';
import CreateDestination from './components/CreateDestination'
import SingleDestination from './components/SingleDestination';


function App() {
  return (
    <div className="App">
     
     
      <BrowserRouter>
      <AppBar/>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/createDestinations' element={<CreateDestination />} />
          
          <Route path='/register' element={ <Register/>} />
          <Route path={`/singleDestination/:id`} element={ <SingleDestination/>} />
          <Route path='/login' element={ <LogIn/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
 