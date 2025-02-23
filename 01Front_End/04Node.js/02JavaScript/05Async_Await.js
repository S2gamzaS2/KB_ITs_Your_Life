// 프라미스 객체
const promise = new Promise((resolve, reject) => {
  console.log('프로미스 시작~!');
  setTimeout(() => {
    console.log('setTimeout 끝!');
    resolve('프로미스 비동기 구현 성공~!');
  }, 2000);
});

promise.then((result) => {
  console.log(result);
});

// async/await
async function asyncFunc() {
  const data = await promise;
  console.log(data);
}

asyncFunc();
