import React, { useState } from 'react';
// import { useSelector, useDispatch } from 'react-redux';
// import {
//   decrement,
//   increment,
//   incrementByAmount,
//   incrementAsync,
//   incrementIfOdd,
//   selectCount,
// } from './counterSlice';
// import styles from './Counter.module.css';


export default function UserAdd() {

  return (
    <div>
        <h1>회원 가입을 환영합니다</h1>
        <form>
            <ul>
                <li>
                    <label>
                        아이디: <input type="text" id="user_id" size="10" minlength="4" maxlength="15"/>
                    </label>
                    <small>4~15자리 이내의 영문과 숫자</small>
                </li>
                <li>
                    <label>
                        이메일: <input type="email" id="user_email"/>
                    </label>
                </li>
                <li>
                    <label>
                        비밀번호: <input type="password" id="user_pwd"/>
                    </label>
                </li>
                <li>
                    <label>
                        비밀번호 확인: <input type="password" id="check_pwd"/>
                    </label>
                </li>
                <li>
                    <input type="submit" value="회원가입"/>
                </li>
            </ul>
        </form>
    </div>
  );
}
