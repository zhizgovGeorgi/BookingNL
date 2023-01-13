
import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import DestinationService from '../functions/DestinationService';
import axios from 'axios';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './Home';
import {useNavigate} from 'react-router-dom';
import { toast } from 'react-toastify';
import ReservationService from '../functions/ReservationService'

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1)
      },
    },
  }));

  // useEffect(()=>{
  //     const role = sessionStorage.getItem("role");
  //     if (role !== "[Admin]") {
  //      navigate("/");
  
  //     }
  // },[])
  
export default function MakeReservation(){
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}

    const[guests, setGuests]=useState('');
    const[startDate, setStartDate]=useState('');
    const[endDate, setEndDate]=useState('');
    const classes = useStyles();
    const navigate = useNavigate();

    const makeReservation = async () =>{
      const reservation={startDate, endDate, guests}
      ReservationService.makeReservation({reservation}).then(res=>{
        navigate('/') 
      })}
    return (
      
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Make a reservation</u></h1>
        <form className={classes.root} noValidate autoComplete="off">
        <TextField id="date"label="Start Date"type="date"defaultValue="2017-05-24"value={startDate}
    onChange={(e)=>setStartDate(e.target.value)}
    className={classes.textField}
    InputLabelProps={{
      shrink: true,
    }}
  />
          <TextField id="date"label="End Date"type="date"defaultValue="2017-05-24"value={endDate}
    onChange={(e)=>setEndDate(e.target.value)}
    className={classes.textField}
    InputLabelProps={{
      shrink: true,
    }}
  />
           <TextField id="outlined-basic" label="Number of guests" type="number"variant="outlined" fullWidth
          value={guests}
          onChange={(e)=>setGuests(e.target.value)}
          />
          
           <Button onClick={makeReservation} variant="contained" color="secondary" >
     Make reservation
    </Button>
        </form>
        
        </Paper>
        </Container>
        
      );
}