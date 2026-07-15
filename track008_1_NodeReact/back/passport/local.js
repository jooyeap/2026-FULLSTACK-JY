/*
    passport/local.js
    --------------------------------------
    사용자가 로그인 시 입력한 email과 passport를 db와 비교하여 인증
    bcrypt 사용해서 비밀번호 해시비교
*/
const passport = require('passport');  
const { Strategy: LocalStrategy } = require('passport-local');   
const bcrypt = require('bcrypt');  
const { findUserByEmail } = require('../models/users');   
module.exports = () => {
  passport.use(new LocalStrategy(
           {  usernameField: 'email', 
              passwordField: 'password', 
           }, //설정
           async (email, password, done) => {
                try{
                    const user = await findUserByEmail(email);  
                    if (!user) {
                    return done(null, false, { message: '존재하지 않는 이메일입니다!' });
                    } 
                    const match = await bcrypt.compare(password, user.PASSWORD); 
                    if(match){ return done(null , user); }
                    else{      return done(null,   false, {message:'비밀번호가 틀렸습니다.'});      } 
                }catch(error){
                    console.error('LocalStrategy Error' , error);
                    return done(error);   
                }
           }   
        )
    );
};