
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function LoginWelcome() {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    // 로컬 스토리지에서 저장된 사용자 데이터 가져오기
    const storedData = localStorage.getItem('loginData');
    if (storedData) {
      setUserData(JSON.parse(storedData));
    } 
  }, []);

  return (
    <div>
      <h1>로그인 환영 페이지</h1>
      {userData && (
        <div>
          <p>안녕하세요, {userData.firstName}, {userData.lastName}님!</p>
          {/* 필요한 사용자 정보를 표시 */}
        </div>
      )}
      <Link to="/">Home</Link>
    </div>
  );
}

export default LoginWelcome;