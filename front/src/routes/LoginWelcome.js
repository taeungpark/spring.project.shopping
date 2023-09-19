
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function LoginWelcome() {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    const storedData = localStorage.getItem('loginData');
    if (storedData) {
      setUserData(JSON.parse(storedData));
    } 
  }, []);

  return (
    <div>
      <h1>Welcome!</h1>
      {userData && (
        <div>
          <p>Hello!, {userData.firstName}, {userData.lastName}!</p>
        </div>
      )}
      <Link to="/">Home</Link>
    </div>
  );
}

export default LoginWelcome;