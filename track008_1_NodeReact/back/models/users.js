/////////////////// required ///////////////////

// user, password, connectString
const dbConfig = require('../config/db'); 
const oracledb = require('oracledb');
const bcrypt = require('bcrypt');

// oracle 초기화
oracledb.initOracleClient(); 
const options = {outFormat: oracledb.OUT_FORMAT_OBJECT ,
                 autoCommit: true };

/////////////////// 각 기능 sql구문 ///////////////////

// 1. create - insert
async function createUser(email, password, nickname, mobile, mbtiTypeId, ufile){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const hashedPassword = await bcrypt.hash(password, 10);
        const result = await conn.execute(`
            insert into appuser (
                app_user_id,
                email,
                password,
                nickname,
                mobile,
                mbti_type_id,
                ufile
            ) values (
                appuser_seq.nextval,
                :email,
                :password,
                :nickname,
                :mobile,
                :mbtiTypeId,
                :ufile
            )`,
            {email, password:hashedPassword, nickname, mobile, mbtiTypeId, ufile},
            options); // sql, 사용자 입력값, 옵션
    } catch(err) {
        console.log('createUser Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}



// 2. 사용자 조회 - email 로
async function findUserByEmail(email){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
                select *
                from appuser
                where email = :email
            `,
            {email},
            options); // 실행
        return result.rows[0]; // 결과 처리
    } catch(err) {
        console.log('findUserByEmail Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 3. 사용자 조회 - id 로
async function findUserById(appUserId){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
                select app_user_id
                from appuser
                where app_user_id = :appUserId
            `,
            {appUserId},
            options);
        return result.rows[0];
    } catch(err) {
        console.log('findUserById Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 4. 로그인 - sql 빼기 pass / 로그아웃
async function verifyUser(email, password){
    const user = await findUserByEmail(email);
    if(!user) return null;

    const match = await bcrypt.compare(password, user.PASSWORD);
    if(!match) return null;

    return {
        id: user.app_user_id,
        email: user.email,
        nickname: user.nickname
    }
}

// 5. 전체 조회
async function getAllUsers(){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
            select *
            from appuser
            order by created_at desc
        `,
        {},
        options);
        return result.rows;
    } catch(err) {
        console.log('getAllUsers Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 6. 닉네임 수정
async function updateUserNickname(nickname, appUserId){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
                update appuser
                set nickname = :nickname
                where app_user_id = :appUserId
            `,
            {nickname, appUserId},
            options);
    } catch(err) {
        console.log('updateUser Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 7. 사용자 삭제
async function deleteUser(appUserId){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
                delete from appuser
                where app_user_id = :appUserId
            `,
            {appUserId},
            options);
    } catch(err) {
        console.log('deleteUser Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 8. 닉네임 으로 조회
async function findUserByNickname(nickname){
    let conn;
    try {
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
                select app_user_id, email, nickname
                from appuser
                where nickname = :nickname
            `,
            {nickname},
            options);
        return result.rows;
    } catch(err) {
        console.log('findUserByNickname Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 9. 이메일 중복검사
async function checkEmail(email){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
            select count(*) as cnt
            from appuser
            where email = :email
        `,
        {email},
        options);
        console.log(result.rows);
        return result.rows[0].CNT > 0;
    } catch(err) {
        console.log('checkEmail Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

// 10. 닉네임 중복검사
async function checkNickname(nickname){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(`
            select count(*) as cnt
            from appuser
            where nickname = :nickname
        `,
        {nickname},
        options);
        return result.rows[0].CNT > 0;
    } catch(err) {
        console.log('checkNickname Error', err)
        throw err;
    } finally {
        if(conn) await conn.close();
    }
}

/////////////////// export ///////////////////
module.exports = { 
    createUser, findUserByEmail, findUserById, verifyUser,
    getAllUsers, updateUserNickname, deleteUser, findUserByNickname,
    checkEmail, checkNickname
};