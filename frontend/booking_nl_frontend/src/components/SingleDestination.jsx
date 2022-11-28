import DestinationService from "../functions/DestinationService";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";
import { useParams } from "react-router-dom";
import Button from '@material-ui/core/Button';




export default function SingleDestination() {
    const {id}= useParams();
    const [destination, setDestination] = useState('');

    useEffect(()=>{
        
     DestinationService.getDestination(id).then(res => (res.data));
    },[])

    return (
        <div >
            {id}
           {destination.name}

           {/* <Button onClick={DestinationService.deleteDestination(id)} color="white" > Delete destination</Button> */}

        </div>
    );
}