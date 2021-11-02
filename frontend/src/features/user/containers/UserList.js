import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { UserListForm } from '..';
import { listPage } from 'features/user/reducer/userSlice';


export default function UserList() {
  const [list, setList] = useState([])
  const dispatch = useDispatch()
 
  useEffect(() => {
    dispatch(listPage())
  }, [])
  return (
    <div>
      <h1>사용자 목록</h1>
      <UserListForm list={list}/>
    </div>
  );
}