import React, { useState, useEffect, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { Link, useHistory } from 'react-router-dom';
import { logout } from 'features/user/reducer/userSlice';

export default function UserDetail() {
  const detail = JSON.parse(window.localStorage.getItem('sessionUser'))
  const dispatch = useDispatch()
  const history = useHistory()

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
            <input type="button" value="로그아웃" onClick={dispatch(logout())}/>
            </li>
        </ul>
    </div>
  );
}
