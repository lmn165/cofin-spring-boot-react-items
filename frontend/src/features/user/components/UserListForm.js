import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { listPage } from '../reducer/userSlice'

const UserListForm = () => {
    const dispatch = useDispatch()
    // const users = useSelector(state => state.userReducer.userState)
    const users = useSelector(state => state.userReducer.userState)
    useEffect(() => {
        // dispatch(listPage())
    }, [users])
    return (<table border='1px' style={{textAlign:'center'}}>
    <thead>
    <tr><th>사용자번호</th>
        <th>사용자아이디</th>
        <th>이름</th>
        <th>이메일</th></tr>
    </thead>
    <tbody>
     {users.map((user)=>( 
        <tr><td>{user.userId}</td>
        <td>{user.username}</td>
        <td>{user.name}</td>
        <td>{user.email}</td></tr>
    ))}
    </tbody>
    </table>)
}

export default UserListForm