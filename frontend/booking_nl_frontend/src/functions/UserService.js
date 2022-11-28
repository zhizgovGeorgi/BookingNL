import axios from "axios";


const userURL = 'http://localhost:9091/api';



const register = (user) => {
    //return axios.post(`${userURL}/register`, user);
    console.log(user)
     return axios.post(`${userURL}/register`, user.user,{
     }).then(response=>{
        console.log('kur',response.data)
     }).catch((err) => {

      if (err.response.status === 500) {

        alert("Something went wrong, try again later!");

      }else{

          throw new Error();
  
        }
  });
}

const logout = () => {
   sessionStorage.clear();
   window.location.reload();
}



export default  {
 register,
 logout
}
