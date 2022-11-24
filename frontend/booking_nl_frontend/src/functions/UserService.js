import axios from "axios";


const userURL = 'http://localhost:9091/api';



const register = (user) => {
    //return axios.post(`${userURL}/register`, user);
    console.log(user)
     return axios.post(`${userURL}/register`, user.user,{
     }).then(response=>{
        console.log('kur',response.data)
     });
}

const logout = () => {
   sessionStorage.clear();
}



export default  {
 register,
 logout
}
