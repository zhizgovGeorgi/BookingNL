import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import DestinationService from '../functions/DestinationService';
import axios from 'axios';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './Home';
import {useNavigate} from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1)
      },
    },
  }));

  
  
  export default function CreateDesination() {
  
    const navigate = useNavigate();
    

    useEffect(()=>{
      const role = sessionStorage.getItem("role");
      if (role !== "[Customer]") {
       navigate("/");
  
      }
  },[])
  
      const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}
    const [name, setName]=useState('');
    const [location, setLocation]=useState('');
    const [pricePerNight, setPricePerNight]=useState('');
      const classes = useStyles();
      
      
  
      
    
   const saveDestination = async () =>{
    const destination={name, location, pricePerNight}
    let res = DestinationService.saveDestination({destination})
    console.log(res);
  }
  
  
    return (
      
      <Container>
          <Paper elevation={3} style={paperStyle}>
              <h1 style={{color:"blue"}}><u>Create new destination</u></h1>
      <form className={classes.root} noValidate autoComplete="off">
      <TextField id="outlined-basic" label="Name" variant="outlined" fullWidth
        value={name}
        onChange={(e)=>setName(e.target.value)}
        />
         <TextField id="outlined-basic" label="Location" variant="outlined" fullWidth
        value={location}
        onChange={(e)=>setLocation(e.target.value)}
        />
         <TextField id="outlined-basic" label="Price per night" variant="outlined" fullWidth
        value={pricePerNight}
        onChange={(e)=>setPricePerNight(e.target.value)}
        />
        
         <Button variant="contained" color="secondary" onClick={saveDestination}>
   Create Destination
  </Button>
      </form>
      
      </Paper>
      </Container>
      
    );
  }