import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './routes/Home';
import Login from './routes/Login';
import Registration from './routes/Registration';
import LoginWelcome from './routes/LoginWelcome';
import Products from './routes/Products';
import ProductDetail from './routes/ProductDetail';

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/login' element={<Login />} />
        <Route path='/registration' element={<Registration />} />
        <Route path='/loginWelcome' element={<LoginWelcome />} />
        <Route path='/products' element={<Products />} />
        <Route path='/product/:id' element={<ProductDetail />} />
      </Routes>
    </Router>
  );
}

export default App;
