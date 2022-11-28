import { useEffect } from 'react';
import { useState } from 'react';
import DestinationService from '../functions/DestinationService'
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import ButtonBase from '@material-ui/core/ButtonBase';
import Button from '@material-ui/core/Button';
import { Link } from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
import SingleDestination from './SingleDestination';


export  function ShowAllDestinations  ()  {
   const [destinations, setDestinations] = useState([]);

   useEffect(()=>{
    DestinationService.getAllDestinations().then(res => setDestinations(res.data));
   },[])

   //const navigate = useNavigate();
const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    margin: 'auto',
    maxWidth: 500,
  },
  image: {
    width: 128,
    height: 128,
  },
  img: {
    margin: 'auto',
    display: 'block',
    maxWidth: '100%',
    maxHeight: '100%',
  },
}));   
 return ( 
    <div  className="singleDestination">
  {destinations.map((destination) => (
    <div key={destination.id}> 
       <div >
      <Paper>
        <Grid container spacing={2}>
          <Grid item>
            <ButtonBase>
              
            </ButtonBase>
          </Grid>
          <Grid item xs={12} sm container>
            <Grid item xs container direction="column" spacing={2}>
              <Grid item xs>
                <Typography gutterBottom variant="subtitle1">
                 {destination.name}
                </Typography>
                <Typography variant="body2" gutterBottom>
                  {destination.location}
                </Typography>
                <Typography variant="body2" color="textSecondary">
                  {destination.id}
                </Typography>
              </Grid>
              <Grid item>
                {/* <Typography  variant="body2" style={{ cursor: 'pointer' }}>
                  Remove
                </Typography> */}
                <Button  color="white" > <Link to={`/singleDestination/${destination.id}`}>Show</Link></Button>
              </Grid>
            </Grid>
            <Grid item>
              <Typography variant="subtitle1">{destination.price}</Typography>
            </Grid>
          </Grid>
        </Grid>
      </Paper>
    </div>
    </div>

    ))}
    </div>
 );


  }


    

