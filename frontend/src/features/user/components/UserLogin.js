import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
import { loginPage } from 'features/user/reducer/userSlice'
import { useForm } from 'react-hook-form'
import styled from 'styled-components'

export default function UserLogin() {
  const dispatch =useDispatch()
  const { register, handleSubmit, formState: { errors } } = useForm();
  return (
    <div>
      <h1>유저 로그인</h1>
      <form method="POST"
      onSubmit={
        handleSubmit(async(data) => await dispatch(loginPage(data)))
      }>
        <ul>
          <li><label for="id">아이디</label>
          <input type="text" id="username"
              name="username" 
              aria-invalid={errors.username ? "true" : "false"}
              {...register('username', { required: true, maxLength: 5 })}/>
              {errors.username && errors.username.type === "required" && (
                <Span role="alert">This is required</Span>
              )}
              {errors.username && errors.username.type === "maxLength" && (
                <Span role="alert">Max length exceeded</Span>
              )}
              </li>
          <li><label for="pw">비밀번호</label>
          <input type="password" id="password" name="password" 
          aria-invalid={errors.password ? "true" : "false"}
          {...register('password', { required: true, maxLength: 30 })}/>
          {errors.password && errors.password.type === "required" && (
            <Span role="alert">This is required</Span>
          )}
          {errors.password && errors.password.type === "maxLength" && (
            <Span role="alert">Max length exceeded</Span>
          )}
          </li>
          <li><input type="button" title="로그인" value="로그인"/></li>
        </ul>
      </form>
    </div>
  );
}


const Span = styled.span`
    color: red;
    font-weight: bold;
`