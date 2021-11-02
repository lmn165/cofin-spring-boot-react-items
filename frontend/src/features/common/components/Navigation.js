import React from 'react'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

export default function Navigation (){
    return (<>
        <div class="navi">
            <Ul>
                <Li><Link to='/'>Home</Link></Li>
                <Li><Link to='/add'>add</Link></Li>
                <Li><Link to='/detail'>detail</Link></Li>
                <Li><Link to='/list'>list</Link></Li>
                <Li><Link to='/login'>login</Link></Li>
                <Li><Link to='/modify'>modify</Link></Li>
                <Li><Link to='/remove'>remove</Link></Li>
            </Ul>
        </div>
</>)
}


const Ul = styled.ul`
background-color: #FFDAB9;
text-decoration:none
text-align: center;


`
const Li = styled.li`
float: left;
margin-left: 1em;
font-size:20px;
text-align:center;
display:inline-block;
`