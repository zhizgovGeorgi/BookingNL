import axios, { AxiosHeaders } from "axios";


const destinationsURL = 'http://localhost:9091/destinations';
const jwtToken = window.sessionStorage.getItem('accessToken');

const getAllDestinations = async () => {
    try {
          return await axios.get(`${destinationsURL}`);
    } catch (error) {
        console.log('Error with idk', error);
    }
}

const saveDestination = (destination) => {
    
    console.log(destination)
     return axios.post(`${destinationsURL}`, destination.destination,{
        headers:{
            'Authorization': "Bearer " + jwtToken
        }
     }).then(response=>{
        console.log('kur',response.data)
     });
}


const deleteDestination = (id) => {
    return axios.delete(`${destinationsURL}/${id}`, {
        headers:{
            'Authorization':"Bearer " + jwtToken
        }
    }).then(response=>{
        console.log('kur',response.data)
    });
}

const getDestination = (id) =>{
    return axios.get(`${destinationsURL}/${id}`).then(response=>{
        console.log('kur',response.data)
    });
}
export default  {
    getAllDestinations,
    deleteDestination,
    saveDestination,
    getDestination
}
