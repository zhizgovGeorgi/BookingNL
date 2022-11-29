
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

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1)
      },
    },
  }));

  
  
export default function MakeReservation(){
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}

    const[guests, setGuests]=useState('');
    const[startDate, setStartDate]=useState('');
    const[endDate, setEndDate]=useState('');
    const classes = useStyles();


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
           <TextField id="outlined-basic" label="End Date" variant="outlined" fullWidth
          value={endDate}
          onChange={(e)=>setEndDate(e.target.value)}
          />
           <TextField id="outlined-basic" label="Number of guests" variant="outlined" fullWidth
          value={guests}
          onChange={(e)=>setGuests(e.target.value)}
          />
          
           <Button variant="contained" color="secondary" >
     Make reservation
    </Button>
        </form>
        
        </Paper>
        </Container>
        
      );
}