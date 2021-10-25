import { createAsyncThunk, createSlice } from "@reduxjs/toolkit"
import { userAPI } from "features/user"

const userJoinPage = async(x) => {
  const res = await userAPI.userJoin(x)
  return res.data
}
const userFetchOnePage = async(x) => {
  const res = await userAPI.userFetchOne(x)
  return res.data
}
const userFetchListPage = async() => {
  const res = await userAPI.userFetchList()
  return res.data
}
const userLoginPage = async(x) => {
  const res = await userAPI.userLogin(x)
  return res.data
}
const userModifyPage = async(x) => {
  const res = await userAPI.userModify(x)
  return res.data
}
const userRemovePage = async(x) => {
  const res = await userAPI.userRemove(x)
  return res.data
}

export const joinPage = createAsyncThunk('/join', userJoinPage) 
export const FetchOnePage = createAsyncThunk('/one', userFetchOnePage) 
export const FetchListPage = createAsyncThunk('/list', userFetchListPage) 
export const LoginPage = createAsyncThunk('/login', userLoginPage) 
export const ModifyPage = createAsyncThunk('/modify', userModifyPage) 
export const RemovePage = createAsyncThunk('/remove', userRemovePage) 


export default userSlice.reducer;