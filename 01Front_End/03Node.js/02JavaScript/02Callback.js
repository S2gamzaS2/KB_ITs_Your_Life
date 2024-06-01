const order = (coffee, callback) => {
  console.log(`${coffee} 주문 접수`);
  setTimeout(() => {
    callback(coffee);
  }, 2000);
};

const display = (menu) => console.log(`${menu} 완료!`);

order('아메리카노', display);

// 아메리카노 주문 접수
// 아메리카노 완료!
