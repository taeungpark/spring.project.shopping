import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './routes/Home';
import Login from './routes/Login';
import LoginWelcome from './routes/LoginWelcome';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        {/* <Route path="/cart" element={<Cart />} /> */}
        <Route path="/login" element={<Login />} />
        <Route path="/loginWelcome" element={<LoginWelcome />} />
        {/* 다른 라우트도 추가할 수 있습니다 */}
      </Routes>
    </Router>
  );
}

export default App;
