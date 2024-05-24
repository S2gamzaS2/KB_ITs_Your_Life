let msg = 'GLOBAL'; // 전역변수

function outer() {
  let msg = 'OUTER'; // 지역변수
  console.log(msg);

  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }

  console.log(msg);
}

outer();
console.log(msg);
