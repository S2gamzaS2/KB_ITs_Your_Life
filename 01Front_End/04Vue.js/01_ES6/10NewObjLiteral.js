// 객체 속성 작성 시 속성명과 변수명이 동일할 경우 변수명만

let p1 = {
  name: '아이패드',
  price: 20000,
  quantity: 2,
  order: function order(rate) {
    this.amount = this.price * this.quantity;
    console.log('주문금액: ' + this.amount);
  },

  // 같은 코드
  order2(rate) {
    this.amount = this.price * this.quantity;
    console.log('주문금액2: ' + this.amount);
  },
};

p1.order();
p1.order2();
