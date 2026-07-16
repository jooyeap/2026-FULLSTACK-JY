// 1. React Test Library - dom
import '@testing-library/jest-dom';

// 2. react 테스트가 끝나면 cleanup을 자동실행하여 dom 정리
import { cleanup } from '@testing-library/react';
afterEach(() => {
  cleanup();
}); 