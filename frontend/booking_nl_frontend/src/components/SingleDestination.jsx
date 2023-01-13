import DestinationService from "../functions/DestinationService";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import Button from '@material-ui/core/Button';
import CreateDesination from "./CreateDestination";
import React from 'react';
import '../customcss/SingleDestination.css';
import jwtDecode from "jwt-decode";
import { Link } from 'react-router-dom';





export default function SingleDestination() {
    const {id}= useParams();
    const navigate = useNavigate();
    const [destination, setDestination] = useState(null);
    const [buttons, setButtons] = useState(null);
    let currentDate = new Date();
    let cDay = currentDate.getDate();
    let cMonth = currentDate.getMonth() + 1;
    let cYear = currentDate.getFullYear();
    let dateOfVisit= (cDay + "/" + cMonth + "/" + cYear);
      
    const [visit, setVisit] = useState({
      id: 0,
      destinationId: id,
      dateOfVisit: dateOfVisit
  })


    const deleteDestination = async()=>{
      const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;
      console.log(email)
        DestinationService.deleteDestination(id, email);
       navigate("/");
      }

      const getDestination = () =>
        DestinationService.getDestination(id)


        const visitDestination = () =>{
        DestinationService.visitDestination(visit).then(res=>{
        })}

  useEffect(()=>{
    const role = sessionStorage.getItem("role");
    
    if (role === "[Admin]" ) {
     setButtons(<>
     <Button id="deleteButon" onClick={deleteDestination} color="white" > Delete destination</Button>
     </>);
     
    }
    else if (role === "[Customer]" ) {
      setButtons(<>
<Button  color="inherit" > <Link to={`/makeReservation/${id}`}>Make a reservation</Link></Button>      </>);
      
     }
  },[])

  useEffect(() => {
    getDestination().then(res => {
      setDestination(res.data);
    })
    visitDestination();
  }, []); 


 

  return (
    <div className="destinationInfo" >
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
