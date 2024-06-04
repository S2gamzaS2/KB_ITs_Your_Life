let person = {
  name: '홍길동',
  eat: function (food) {
    console.log(`${this.name}이 ${food}을 먹는다`);
  },
};

person.eat('밥');
