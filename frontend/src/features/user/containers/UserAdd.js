import React from 'react';
import { useDispatch } from 'react-redux';
import { exist, joinPage } from 'features/user/reducer/userSlice'
import { useForm } from 'react-hook-form'
import styled from 'styled-components'
import Layout from 'features/common/components/Layout';

export default function UserAdd() {
    const dispatch = useDispatch()
    const { register, handleSubmit, formState: { errors } } = useForm();
    // history.push('/login')
  return (
    <Layout>
    <Main>
         <h1>회원 가입을 환영합니다.</h1>
    <form method='POST' onSubmit={
        handleSubmit(async(data) => await dispatch(joinPage({...data, 
                                    regDate: new Date().toLocaleDateString()}))
                                    )}>
        <ul>
            <li>
                <label>
                    아이디 : <input type="text" id="username" name="username"
                    aria-invalid={errors.username ? "true" : "false"}
                    {...register('username', { required: true, maxlength: 10})}
                    />
                    {errors.username && errors.username.type === "required" && (
                      <Span role="alert">This is required</Span>
                    )}
                    {errors.username && errors.username.type === "maxLength" && (
                      <Span role="alert">Max length exceeded</Span>
                    )}
                    <button onClick={() => dispatch(
                            exist(document.getElementById('username').value))}>중복체크</button>
                </label>
                <small>1~15자리 이내의 영문과 숫자</small>
            </li>
            <li>
                <label>
                    이메일 : <input type="email" id="email" name="email"
                    aria-invalid={errors.email ? "true" : "false"}
                    {...register('email', { required: true, maxLength: 30 })}
                  />
                </label>
            </li>
            <li>
                <label>
                    비밀 번호 : <input type="password" id="password" name="password" 
                    aria-invalid={errors.password ? "true" : "false"}
                    {...register('password', { required: true, maxLength: 30 })}
                  />
                  {errors.password && errors.password.type === "required" && (
                    <Span role="alert">This is required</Span>
                  )}
                  {errors.password && errors.password.type === "maxLength" && (
                    <Span role="alert">Max length exceeded</Span>
                  )}
                </label>
            </li>
            <li>
                <label>
                    이름 : <input type="text" id="name" name="name" 
                    aria-invalid={errors.name ? "true" : "false"}
                    {...register('name', { required: true, maxLength: 30 })}
                    />
                </label>
            </li>
           
            <li>
                <input type="submit" onClick={ e => handleSubmit(e)} value="회원가입"/>
            </li>

        </ul>
    </form>
    </Main>
    </Layout>
  );
}
const Span = styled.span`
    color: red
`
const Main = styled.div`
width: 500px;
margin: 0 auto;
text-decoration:none
text-align: center;
`