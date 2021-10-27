import React, { useState, useEffect, useCallback } from 'react';
import { Link, useHistory } from 'react-router-dom';

export default function UserDetail() {
  const history = useHistory()  // history 는 이동할 때 사용하는 hook
  const [detail, setDetail] = useState({
    userId:'', username:'', password:'', email:'', name:'', regDate: new Date().toLocaleDateString()
  })

  const userDetail  = () => {
    const sessionUser = JSON.parse(localStorage.getItem('sessionUser'))
    // alert(`사용자 아이디: ${sessionUser.userId}`)
    // alert('pause!')
    userDetail(sessionUser)
    .then(res => {
        // alert(`회원정보 조회 성공: ${res.data}`)
        setDetail(res.data)
    })
    .catch(err => {
        alert(`조회 실패: ${err}`)
    })
  }
  useEffect(() => {
    userDetail ()
  }, [])

  const logout = e => {
    e.preventDefault()
    localStorage.setItem('sessionUser','')
    history.push('/')
}

  return (
    <div>
        <h1>회원 정보</h1>
        <ul>
            <li>
                <label>
                    <span>아이디: {detail.username}</span> 
                </label>
            </li>
            <li>
                <label>
                    <span>이메일: {detail.email}</span> 
                </label>
            </li>
            <li>
                <label>
                    <span>비밀번호: ******** </span> 
                </label>
            </li>
            <li>
                <label>
                    <span>이름: {detail.name}</span> 
                </label>
            </li>
            <li>
                <input type="button" value="회원정보수정" onClick={()=> history.push('/modify')}/>
            </li>
            <li>
            <input type="button" value="로그아웃" onClick={logout}/>
            </li>
        </ul>
    </div>
  );
}
