use test;
db.users.find();

db.users.insertOne({name: "공연정", age: 25}); // 데이터 하나만 삽입
db.users.insertMany([{name:"김연비", age: 30}, {name: "박혜원", age: 28}]); // 여러개 삽입 - 배열

db.users.find();

// 실습2 - InsertOne 메서드 - 뽀로로, 9살 / 루피, 8살
db.users.insertOne({name: "뽀로로", age: 9});
db.users.insertOne({name: "루피", age: 8});
// insertMany 메서드 사용 - 모든 교육생 컬렉션에 추가
db.users.insertMany([{name:"김이수", age: 25}, {name: "정지희", age: 25}, {name: "최민준", age: 26}], {name: "권오현", age: 32});
db.users.find();

// 수정 ($set)
db.users.updateOne(
    {name: "na"},
    {$set: {name:"나건우"}}
);

// 비교식
db.users.updateMany(
    { name : {$ne: "나건우"}},
    {$set: {position: "RM 아님"}}
); // name 필드가 "나건우"가 아닌 모든 도큐먼트의 position- RM아님

db.users.updateMany(
    { age : {$lte: 30}},
    {$set: {status: "파릇파릇~"}}
);

// 삭제
db.users.deleteOne({name: "뽀로로"});
db.users.find();
db.users.deleteMany({age: {$lte: 10}});

// read(검색
db.users.findOne({name: "이효석"});
db.users.find();
db.users.find({age: {$lt: 30}});

db.users.find({
    $and: [
        { position: "RM"},
        { age: {$gt: 20}}
    ]
});

db.users.find({
    $or: [
    {name: {$ne: "이효석"}},
    {age: {$lt: 25}}
    ]
});

// 실습
use test2;
// insertOne
db.users.insertOne({name: "감자", age: 8});
// insertMany - 배열
db.users.insertMany([{name: "고구마", age: 10}, {name: "옥수수", age: 5}]);
// 나이가 7 이상인 도큐먼트에 status 필트 추가 - 값: 굿
db.users.updateMany({age: {$gt: 7}}, {$set: {status: "굿"}});
// 나이가 8 이상이면서 이름이 "고구마"인 데이터 삭제
db.users.deleteMany({
    $and :[
    {age: {$gt: 8}},
    {name: "고구마"}
    ]
 });
 // 나이가 7 이상인 데이터만 출력
db.users.find({age: {$gt: 7}});
