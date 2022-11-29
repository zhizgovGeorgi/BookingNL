import DestinationService from "../functions/DestinationService";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import Button from '@material-ui/core/Button';
import CreateDesination from "./CreateDestination";
import React from 'react';




export default function SingleDestination() {
    const {id}= useParams();
    const navigate = useNavigate();
    const [destination, setDestination] = useState(null);
    const [buttons, setButtons] = useState(null);

    const deleteDestination = async()=>{
        DestinationService.deleteDestination(id);
       navigate("/");
      }

      const getDestination = () =>
        DestinationService.getDestination(id)
      

  useEffect(()=>{
    const role = sessionStorage.getItem("role");
    if (role === "[Admin]" ) {
     setButtons(<>
     <Button onClick={deleteDestination} color="white" > Delete destination</Button>
     </>);
     
    }
  },[])

  useEffect(() => {
    getDestination().then(res => {
      setDestination(res.data);
    })
  }, []);

 

  return (
    <div >
      {destination &&
        <div key={destination.id}>
         Name: {destination.name}, 
         Location: {destination.location},
        Price per person per night: {destination.pricePerNight} euro
        </div>
      }
    {buttons}
    </div>
  );

}
