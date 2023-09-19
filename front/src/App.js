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
        <Route path="/login" element={<Login />} />
        <Route path="/loginWelcome" element={<LoginWelcome />} />
      </Routes>
    </Router>
  );
}

export default App;
