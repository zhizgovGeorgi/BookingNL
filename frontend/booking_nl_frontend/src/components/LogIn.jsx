import React, {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import login from '../functions/login'
import { Outlet } from 'react-router-dom';
import axios from 'axios';
import { Home } from '@material-ui/icons';


const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1)
    },
  },
}));

export default function LogIn() {
 
  
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}
    const [email, setEmail]=useState('');
    const [password, setPassword]=useState('');
      const classes = useStyles();
  
  

     
      // const logIn = async () =>{
      //   const getRequest={email, password}
      //   let res = await api.post("/login", getRequest)
      //   sessionStorage.setItem("token", JSON.stringify(res));
      //   console.log(sessionStorage.getItem("token"));
      // }
      
      const logIn = async()=>{
        login({email, password});
           //console.log(sessionStorage.getItem("token"));
      }


  return (
    
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Log in</u></h1>
    <form className={classes.root} noValidate autoComplete="off">
      <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <TextField required type={"password"} id="outlined-basic" label="Password" variant="outlined" fullWidth
      value={password}
      onChange={(e)=>setPassword(e.target.value)}
       />
       <Button variant="contained" color="secondary" onClick={logIn}>
 Log In
</Button>
    </form>
    
    </Paper>
    </Container>
    
  );
}
