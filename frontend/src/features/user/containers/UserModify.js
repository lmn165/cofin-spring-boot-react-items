import React, { useCallback, useState } from 'react';
import { useDispatch } from 'react-redux';
import { useHistory  } from 'react-router-dom';
import { modifyPage } from '../reducer/userSlice';
import Layout from 'features/common/components/Layout';
import styled from 'styled-components'

export default function UserModify() {
    const history = useHistory()
    const dispatch = useDispatch()
    const sessionUser = JSON.parse(localStorage.getItem('sessionUser')); 
    const [modify, setModify] = useState({
        userId: sessionUser.userId,
        username:sessionUser.username, 
        password:sessionUser.password, 
        email:sessionUser.email, 
        name:sessionUser.name, 
        regDate: sessionUser.regDate
    })
    const {userId, username, password, email, name} = modify
    const handleChange = e => {
            const { value, name } = e.target
            setModify({
                ...modify,
                [name] : value
            })
        }
  return (
      <Layout>
    <Main>
         <h1>회원정보 수정</h1>
    <form onSubmit={
        useCallback(
            e => {
                e.preventDefault()
                dispatch(modifyPage({...modify}))
                // alert(`회원수정 정보: ${JSON.stringify(modifyRequest)}`)
            }
        )
    } method='PUT'>
        <ul>
            <li>
              <label>
                    <span>회원번호 : {sessionUser.userId} </span>
                </label>
            </li>
            <li>
                <label>
                    <span>아이디 : {sessionUser.username} </span>
                </label>
            </li>
            <li>
                <label>
                    이메일 : <input type="email" id="email" name="email" placeholder={sessionUser.email}
                                  value={email}
                                 onChange={handleChange}/>
                </label>
            </li>
            <li>
                <label>
                    비밀 번호 : <input type="password" id="password" name="password" placeholder={sessionUser.password} 
                    value={password}
                    onChange={handleChange}/>
                </label>
            </li>
            <li>
                <label>
                    이름 : <input type="text" id="name" name="name" placeholder={sessionUser.name}
                    value={name}
                    onChange={handleChange}/>
                </label>
            </li>
           
            <li>
                <input type="submit" value="수정확인"/>
            </li>

        </ul>
    </form>
    </Main>
    </Layout>
  );
}
const Main = styled.div`
width: 500px;
margin: 0 auto;
text-decoration:none
text-align: center;
`