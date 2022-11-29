import './App.css';
import AppBar from './components/Appbar';
import Register from './components/Register';
import { Home } from './components/Home';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LogIn from './components/LogIn';
import CreateDestination from './components/CreateDestination'
import SingleDestination from './components/SingleDestination';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import MakeReservation from './components/MakeReservation';


function App() {
  return (
    <div className="App">
     <ToastContainer
position="top-right"
autoClose={5000}
hideProgressBar={false}
newestOnTop={false}
closeOnClick
rtl={false}
pauseOnFocusLoss
draggable
pauseOnHover
theme="dark"
/>
     
      <BrowserRouter>
      <AppBar/>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/createDestinations' element={<CreateDestination />} />
          
          <Route path='/register' element={ <Register/>} />
          <Route path={`/singleDestination/:id`} element={ <SingleDestination/>} />
          <Route path='/login' element={ <LogIn/>} />
          <Route path='/makeReservation' element={ <MakeReservation/>} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
 