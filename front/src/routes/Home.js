
import React from 'react';
import { Link } from 'react-router-dom';

function Home() {

    const handleLogout = async () => {
        try {
            const response = await fetch('http://localhost:8080/members/logout', {
                method: 'POST'
        });
            if (response.ok) {
                localStorage.removeItem('loginData');
                console.log('sucess');
            } else {
            console.error(response.statusText);
            console.error('fail');
            }
        } catch (error) {
            console.error(error);
            console.error('Can not call the API');
        }
    };

    return (
        <div>
            <h1>Home page</h1>

        <div><Link to="/cart">Cart</Link></div>
        <div><Link to="/login">Login</Link></div>
        <div><Link to="/registration">Registration</Link></div>
        <div><Link to="/products">Products</Link></div>

        <div>
            <button onClick={handleLogout}>Logout</button>
        </div>
    </div>
    );
}

export default Home;