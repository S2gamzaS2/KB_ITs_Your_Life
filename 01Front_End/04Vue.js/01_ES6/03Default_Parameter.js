function addContact(name, mobile, home = '없음', address = '없음') {
  let str = `name=${name}, mobile=${mobile}, home=${home}, address=${address}`;
  console.log(str);
}

addContact('홍길동', '010-1234-3333');
addContact('이몽룡', '010-1212-1212', '02-02020', '서울시');
