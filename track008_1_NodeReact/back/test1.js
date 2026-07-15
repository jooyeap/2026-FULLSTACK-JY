const {
    createUser, findUserByEmail, findUserById, verifyUser,
    getAllUsers, updateUserNickname, deleteUser, findUserByNickname
} = require('./models/users');

async function runTests(){
    try {
        // 1. 회원가입
        await createUser('1@1', '1', 'first', '000-1111-2222', 1, '1.png');
        console.log('✅ createUser 성공');
        // 2. 이메일로 조회
        await findUserByEmail('1@1');
        console.log('✅ userByEmail 성공');

    } catch (err) {
        console.error('❌ 테스트 중 오류 발생', err)
    }
}

runTests();