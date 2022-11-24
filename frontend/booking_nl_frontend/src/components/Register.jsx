import React, {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import UserService from '../functions/UserService';
import axios from 'axios';
import { Outlet } from 'react-router-dom';


const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1)
    },
  },
}));

export default function Register() {

  
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}
  const [firstName, setFName]=useState('');
  const [lastName, setLName]=useState('');
  const [adress, setAddress]=useState('');
  const [email, setEmail]=useState('');
  const [password, setPassword]=useState('');
  const role = 'Customer';
    const classes = useStyles();

    
    // const register=(e)=>{
    //   e.preventDefault()
    //   const user={firstName, lastName, adress, email, password, role}
    //   console.log(user)
    //   fetch("http://localhost:9091/customers",{
    //     method:"POST",
    //     headers:{"Content-Type":"application/json"},
    //     body:JSON.stringify(user)
    //   }).then(()=>{
    //     console.log("New user added!")
    //   })
    // }
 const register = async () =>{
  const user={firstName, lastName, adress, email, password}
  UserService.register({user})
}


  return (
    
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Register</u></h1>
    <form className={classes.root} noValidate autoComplete="off">
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
      <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <TextField type={"password"} id="outlined-basic" label="Password" variant="outlined" fullWidth
      value={password}
      onChange={(e)=>setPassword(e.target.value)}
       />
       <Button variant="contained" color="secondary" onClick={register}>
 Register
</Button>
    </form>
    
    </Paper>
    </Container>
    
  );
}
