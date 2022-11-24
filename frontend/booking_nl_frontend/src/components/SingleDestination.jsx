import DestinationService from "../functions/DestinationService";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";



export default function SingleDestination(id) {
   const{state} = useLocation();
  

    const [destination, setDestination] = useState('');

    setDestination(state);


    useEffect(()=>{
     DestinationService.getDestination(id).then(res => setDestination(res.data));
    },[])

    return (
        <div >
           {destination.name}
        </div>
    );
}