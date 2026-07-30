// sagas/index.js

import { all, fork } from 'redux-saga/effects';
import authSaga from './authSaga';
import postSaga from './postSaga';

export default function *rootSaga(){
    yield all([
       fork( authSaga ),
       fork( postSaga ), 
    ]);
}

// fork : 기다리지 않음 (다른일 할수있게 양보) - 동시실행이 가능함
// call : 기다림 (어떠한 일이 끝날때까지 기다리기) - 결과물이 필수적일때