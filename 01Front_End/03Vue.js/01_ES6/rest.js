function makeStudent(name, korean, math) {
  let student = {
    이름: name,
    국어: korean,
    수학: math,
    Add: function () {
      return this.국어 + this.수학;
    },
    Avg: function () {
      return this.Add() / 2;
    },

    toString: function () {
      return this.이름 + '\t' + this.Add() + '\t' + this.Avg();
    },
  };
  return student;
}

console.log(makeStudent('홍길동', 98, 100).Add());
