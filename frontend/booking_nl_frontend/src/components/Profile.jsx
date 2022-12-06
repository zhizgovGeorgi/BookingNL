import jwtDecode from "jwt-decode";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../functions/UserService";

export default function Profile() {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;


      const getUser = () =>
        UserService.getUser(email)
      

//   useEffect(()=>{
//     const role = sessionStorage.getItem("role");
//     if (role !== "[Admin]" && role !== "[Customer]" ) {
//     navigate("/");
     
//     }
//   },[])

  useEffect(() => {
    getUser().then(res => {
      setUser(res.data);
    })
  }, []);

 

  return (
    <div className="userInfo" >
      {user &&
        <div key={user.id}>
         Name: {user.firstName}, 
         Last Name: {user.lastName},
        Email: {user.email},
        Adress: {user.adress}
        </div>
      }
    </div>
  );

}