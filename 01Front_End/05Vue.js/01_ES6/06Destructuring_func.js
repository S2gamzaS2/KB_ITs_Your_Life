function addContact1({ name, phone, email = '이메일 없음', age = 0 }) {
  console.log(name, phone, email, age);
}

addContact1({ name: '이몽룡', phone: '010-1234-1234' }); // 가장 바람직

function addContact2(contact) {
  if (!contact.email) contact.email = '이메일 없음';
  if (!contact.age) contact.age = 0;
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}

addContact2({ name: '박몽룡', phone: '010-4567-4567' });

function addContact3(name, phone, email = '이메일 없음', age = 0) {
  console.log(name, phone, email, age);
}

addContact3('곽몽룡', '010-8901-8901');
