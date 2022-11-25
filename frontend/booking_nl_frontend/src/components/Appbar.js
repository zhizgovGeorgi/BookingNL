import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import { Link } from 'react-router-dom';
import { useEffect } from 'react';
import UserService from '../functions/UserService';
import saveDestination from '../functions/DestinationService'

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));



export default function Appbar() {
  const classes = useStyles();
//const [role, setRole] = useState('');
const [buttons, setButtons] = useState(null);

  useEffect(()=>{
    const role = sessionStorage.getItem("role");
    if (role === "[Customer]" ) {
     setButtons(<>
     <Button color="white" > <Link to={'/createDestinations'}>Create Destinations</Link></Button>
     <Button onClick={UserService.logout} color="inherit" > <Link to={'/getAll'}>Log Out</Link></Button>
     </>);
     
    }
    else{
      setButtons(<>
       <Button  color="white" > <Link to={'/login'}>Log in</Link></Button>
<Button> <Link color="white" to={'/register'}>Register</Link></Button>
        </>);

    }
   
  },[])



  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          
          <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
            <MenuIcon  />
          </IconButton>
          <Typography variant="h6" className={classes.title}>
            Booking NL
          </Typography>
          <Button  color="inherit" > <Link to={'/getAll'}>Home</Link></Button>
          {buttons} 

         
         

        </Toolbar>
      </AppBar>
    </div>
  );
}