let p = new Promise((resolve, reject) => {
  resolve('first');
});

p.then((result) => {
  console.log(result);
  return 'second'; // 문자열리턴x, "second"를 가지는 promise 객체 리턴
})
  .then((result) => {
    console.log(result);
    throw new Error('에러!');
    return 'third';
  })
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.log(`에러 발생: ${error}`);
  });
