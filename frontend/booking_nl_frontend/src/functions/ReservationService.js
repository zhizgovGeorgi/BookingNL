import axios, { AxiosHeaders } from "axios";
import { toast } from "react-toastify";


const reservationURL = 'http://localhost:8080/reservations';
const jwtToken = window.sessionStorage.getItem('accessToken');

const makeReservation=(reservation)=>{
    return axios.post(`${reservationURL}`, reservation.reservation,{
        headers:{
            'Authorization': "Bearer " + jwtToken
        }
     }).then(response=>{
        toast.success("Reservation successfuly created!")

     }).catch((err) => {

        if (err.response.status === 403) {
  
          toast.error(err.response.message);
  
        }else{

            throw new Error();
    
          }
    })
     ;
}

const getReservations=(userId)=>{
    try {
        return  axios.get(`${reservationURL}`, userId.userId,{
            headers:{
                'Authorization': "Bearer " + jwtToken
            }
         });
  } catch (error) {
      console.log('Error with idk', error);
  }
}
export default  {
    makeReservation,
    getReservations
}