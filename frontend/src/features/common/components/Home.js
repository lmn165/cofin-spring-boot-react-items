import { Logout } from "features/user";
import React from "react";
// import { useHistory } from "react-router";

export default function Home() {
    // const history = useHistory()
    // const sessionName = window.localStorage.length > 0 ? JSON.parse(window.localStorage.getItem('sessionUser')).name : 'None'

return (<div>
    {/* <h1>홈페이지 화면 입니다~~</h1> */}
    {localStorage?.length > 0 ? 
    <h2>{JSON.parse(window.localStorage.getItem('sessionUser')).name} 님 접속중</h2> : 
    <h2>로그인 필요</h2>}
    {localStorage?.length == 0 ? 
        <> <button onClick = {() => window.location.href='/add'}>회원가입</button>
        <button onClick = {() => window.location.href='/login'}>로그인</button></> :
        <Logout/>}
</div>)
}