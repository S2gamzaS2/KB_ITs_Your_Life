let likePizza = false;

// pizza = 프라미스 객체
const pizza = new Promise((resolve, reject) => {
  if (likePizza) resolve('피자를 주문합니다'); // 성공 시 반환 값
  else reject('피자 주문 실패'); // 실패 시 반환 값
});

// 메서드 체이닝 (프라미스 체이닝)
pizza.then((result) => console.log(result)).catch((err) => console.log(err));

console.log('마지막 코드'); // 프라미스가 비동기라 이 코드가 먼저 실행 됨

// 마지막 코드
// 피자 주문 실패
