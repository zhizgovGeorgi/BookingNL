import jwtDecode from "jwt-decode";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../functions/UserService";
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

export default function Profile() {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;
    const [firstName, setFName]=useState('');
    const [lastName, setLName]=useState('');
    const [adress, setAddress]=useState('');

    const updateUserDetails=()=>{
      const userRequest={email, firstName, lastName, adress}
      console.log(userRequest)
    UserService.updateUserDetails({userRequest})
    }

      const getUser = () =>
        UserService.getUser(email)
      
        
//   useEffect(()=>{
//     const role = sessionStorage.getItem("role");
//     if (role !== "[Admin]" && role !== "[Customer]" ) {
//     navigate("/");
     
//     }
//   },[])

  useEffect(() => {
    getUser().then(res => {
      setUser(res.data);
    })
  }, []);

 

  return (
    <div className="userInfo" >
      {user &&
        <div key={user.id}>
    <TextField id="outlined-basic" label="First Name" variant="outlined" fullWidth
      value={firstName}
      onChange={(e)=>setFName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Last Name" variant="outlined" fullWidth
      value={lastName}
      onChange={(e)=>setLName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Address" variant="outlined" fullWidth
      value={adress}
      onChange={(e)=>setAddress(e.target.value)}
      />
<Button variant="contained" color="secondary" onClick={updateUserDetails}>
 Update
</Button>
         
        </div>
      }
    </div>
  );

}