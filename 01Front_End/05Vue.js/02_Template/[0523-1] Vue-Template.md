> **· MVVM 패턴** (Model-View-ViewModel)
>: 뷰에서 채택하는 모델
> <img src="https://velog.velcdn.com/images/seizethedai/post/d39c0570-90ef-4966-a828-400b2f9b8c8c/image.png" width=550px >
> <img src="https://velog.velcdn.com/images/seizethedai/post/c339816d-8a08-403f-963a-5ccbb39e9753/image.png" width=550px>


<br>

# 1. 기본 디렉티브
- **v-디렉티브**: Vue 프레임워크에 지시를 내리는 속성
 	· v- 로 시작
	· html 요소와 관련된 작업 지정

> 기존 HTML ⇨ `속성명="문자열"`
> v-디렉티브 ⇨ `v-text="js표현식"`
    
<br>

### 1) v-text / v-html

- 텍스트 출력
    - `v-text` , `{{}}` : 내용을 text로 출력, html태그 이스케이프됨
    - `v-html` : 내용을 html로 출력

``` javascript
<div id="app">
  <div v-text="message"></div>
</div>

<script>
  new Vue({
    el: '#app',
    data: {
      message: '<strong>이 텍스트는 굵게 표시되지 않습니다.</strong>'
    }
  });
</script>
```
**결과>>**
&lt;strong&gt;이 텍스트는 굵게 표시되지 않습니다.&lt;/strong&gt;
<br>

```javascript
<div id="app">
  <div v-html="message"></div>
</div>

<script>
  new Vue({
    el: '#app',
    data: {
      message: '<strong>이 텍스트는 굵게 표시됩니다.</strong>'
    }
  });
</script>
```
**결과>>**
<strong>이 텍스트는 굵게 표시됩니다.</strong>

<br>

### 2) v-bind

`<태그 v-bind:속성="표현식">`
`<태그 :속성="표현식">`
(속성: HTML 속성)

- 요소의 속성을 바인딩
- 속성값을 문자열이 아닌 javascript 표현식으로 처리
<br>
- **단방향**
    - Vue 인스턴스의 데이터나 속성이 바뀌면 UI 갱신
    - 화면에 바인딩된 요소에서 값을 변경하더라도 데이터는 변경되지 않음
        - 사용자의 입력: 양방향 / 사용자 입력과 무관: 단방향 사용
    

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>v-bind</title>
  </head>
  <body>
    <!-- Vue파트 -> template (서식) -->
    <div id="app">
      <input id="a" type="text" v-bind:value="message" />
      <br />
      <img v-bind:src="imagePath" />
    </div>

    <script type="text/javascript" src="https://unpkg.com/vue"></script>
    <script type="text/javascript">
      var vm = Vue.createApp({
        name: 'App',

        // 데이터 함수가 리턴하는 객체의 속성명만 바인딩 가능 -> proxy객체로 랩핑되어있기 때문
        data() {
          return {
            message: 'v-bind 디렉티브',
            imagePath: 'https://zrr.kr/NjCG',
          };
        },
      }).mount('#app');
    </script>
  </body>
</html>

```

<img src="https://velog.velcdn.com/images/seizethedai/post/fdeca1e4-543d-46cd-8027-516974d06a5f/image.png">

<img src="https://velog.velcdn.com/images/seizethedai/post/fabe9974-ebf7-4da2-8c41-b0c7a1522cbe/image.png" width=700px>






<br>

### 3) v-model

`<태그 v-model="속성">` 

- **양방향** 데이터 바인딩
    - 속성값 변경 → UI 변경
    - UI 입력값 변경 → 속성값 변경
    - 주로 form 요소에 바인딩 (input, select, textarea 등)


```html
  <body>
    <!-- Vue파트 -> template (서식) -->
    <div id="app">
      <input type="text" v-model="name" />
      <br />
      입력한 값: <span>{{ name }}</span>
    </div>

    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',

        // 리턴하는 객체의 속성명만 바인딩 가능 -> proxy객체로 랩핑되어있기 때문
        data() {
          return { name: '' };
        },
      }).mount('#app');
    </script>
  </body>
```
<img src="https://velog.velcdn.com/images/seizethedai/post/ee82153d-c0af-4997-8d1b-6dcb27c71d63/image.png" width=400px>

<img src="https://velog.velcdn.com/images/seizethedai/post/2e585f62-dc31-4cbb-b604-53b64db84c81/image.png" width=650px>

<br>

#### - checkbox / select
> * checkbox
>① 다중선택 → 배열
>② 동의 여부 → Boolean
>> Vue: v-model이 배열인지, 문자열인지 보고 다중선택인지 단일선택인지 판단

① 다중 선택 (배열)

```html
  <body>
    <div id="app">
      <div>
        <h2>취미</h2>
        <!-- hobby: 배열 / value값이 배열에 들어감 -->
        <input type="checkbox" id="exercise" value="a" v-model="hobby" />
        <label for="exercise">운동</label>
        <input type="checkbox" id="reading" value="b" v-model="hobby" />
        <label for="reading">독서</label>
        <input type="checkbox" id="dance" value="c" v-model="hobby" />
        <label for="dance">댄스</label>
      </div>

      <div>
        <h2>상품 분류 선택</h2>
        <!-- category: 단일 선택,문자열 / value값이 문자열로-->
        <select v-model="category">
          <option value="">---상품 분류 선택---</option>
          <option value="A01">가전</option>
          <option value="A02">음식</option>
          <option value="A03">도서</option>
        </select>
      </div>
      <hr />

      <div>
        선택한 취미 : {{hobby.join(',')}} <br />
        선택한 상품 : {{category}}
      </div>
    </div>

    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return {
            hobby: [],
            category: '',
          };
        },
      }).mount('#app');
    </script>
  </body>
```
<img src="https://velog.velcdn.com/images/seizethedai/post/f795bef3-3c9c-42cc-a607-0f0a18f5a2d9/image.png">

<br>
② 단일 선택 (Boolean)

```html
  <body>
    <div id="app">
      위의 내용에 동의하십니까?
      <!-- 원래는 true/false값으로 받지만 설정한 값으로 받을 수 있음 (true-value / false-value) -->
      <input
        type="checkbox"
        v-model="agree"
        true-value="yes"
        false-value="no"
      />
      <hr />
      <span>선택된 값 : {{agree}}</span>
    </div>

    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return {
            agree: 'no',
          };
        },
      }).mount('#app');
    </script>
  </body>
```

#### - 수식어

- `v-model.lazy` : **바인딩을 늦춤**, input에서 **엔터를 치거나 포커스 이동했을 때** 입력값과 속성을 동기화
- `v-model.numer`★★ : 문자열을 **숫자로 형변환**, 형변환이 가능한 부분만 숫자로 변환
	_100abc → 100
	abc → abc(문자열)_
- `v-model.trim`★ : 문자열 **앞뒤 공백 제거**


<br>
<br>

---

<br>

# 2. 조건 렌더링 디렉티브

### 1) v-show
`v-show="표현식"` : 표현식의 true/false 여부에 따름

- 화면에 보여줄지 말지 결정
- HTML 요소는 생성하지만 화면에 보여주지 않을 수 있음 (**DOM에는 존재**)
- false :  display=none

```html
  <body>
    <div id="app">
      예금액: <input type="text" v-model="amount" />
      <img
        v-show="amount < 0"
        src="https://contactsvc.bmaster.kro.kr/img/error.png"
        title="마이너스는 허용하지 않음"
        style="width: 15px; height: 15px; vertical-align: middle"
      />
    </div>
    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return { amount: '' };
        },
      }).mount('#app');
    </script>
  </body>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/883b1777-3801-40d1-8007-ed92cc5d56cc/image.png">


<br>

### 2) v-if
`v-if="표현식"`

- 조건에 부합하지 않을 경우 랜더링 수행X (**DOM에서 제거**)
- v-show보다 더 많이 씀

```html
      <img
        v-if="amount < 0"
        src="https://contactsvc.bmaster.kro.kr/img/error.png"
        title="마이너스는 허용하지 않음"
        style="width: 15px; height: 15px; vertical-align: middle"
      />
```

<img src="https://velog.velcdn.com/images/seizethedai/post/c15edc1b-c011-4403-bf26-5df2cf4c30bb/image.png" width=700px>
 

<br>

### 3) v-else / v-else-if

- v-if와 함께 사용 (v-if 바로 다음에 사용)

```html
  <body>
    <div id="app">
      잔고: <input v-model="balance" /> <br />
      회원 등급:
      <span v-if="balance > 1000">Gold</span>
      <span v-else-if="balance >= 500">Silver</span>
      <span v-else="balance">Bronze</span>
    </div>
    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return { balance: 0 };
        },
      }).mount('#app');
    </script>
  </body>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/ead9376a-edb8-4d37-8790-8df60611deda/image.png">


<br>
<br>

---

<br>

# 3. 반복 렌더링 디렉티브

### 1) v-for ★★★

- 배열: `<태그 v-for="변수 in 배열" :key="id값">`
- 객체: `<태그 v-for="(val, key) in 객체" :key="key">`

- 반복적인 데이터 렌더링

```html
  <head>
    <title>v-for</title>
    <style>
      #list {
        width: 300px;
        border: 1px solid black;
        /* border-collapse: 표 테두리 단일선 */
        border-collapse: collapse;
      }
      #list td,
      #list th {
        border: 1px solid black;
      }
    </style>
    
  </head>
  <body>
    <div id="app">
      <table id="list">
        <thead>
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody id="contacts">
          <tr v-for="contact in contacts" :key="contact.no">
            <td>{{contact.no}}</td>
            <td>{{contact.name}}</td>
            <td>{{contact.tel}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    
    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return {
            contacts: [
              { no: 101, name: '감자', tel: '132' },
              { no: 102, name: '고구마', tel: '391' },
              { no: 103, name: '옥수수', tel: '923' },
            ],
          };
        },
      }).mount('#app');
    </script>
  </body>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/60a86260-6e6c-412a-8aeb-34c235552c1c/image.png">

```html
  <body>
    <div id="app">
      <select id="regions">
        <option disabled="disabled" selected>지역 선택</option>
        <option v-for="(val, key) in regions" :value="key" :key="key">
          {{val}}
        </option>
      </select>
    </div>
    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return {
            regions: {
              A: 'Asia',
              B: 'Brazil',
              C: 'Canada',
              D: 'Danmark',
            },
          };
        },
      }).mount('#app');
    </script>
  </body>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/2ef7f3f1-da78-454b-b7ad-0cea80813217/image.png">


> - 인덱스 번호가 필요한 경우
	`<태그 v-for="(contact, index) in contacts"`
    `<태그 v-for="(val, key, index) in regions"`

<br>

### 2) &lt;template v-for&gt;
`<template v-for="">`

- 여러 요소 묶어서 반복 렌더링
- DOM에 안 들어가면서 반복 (&lt;template&gt; 태그 DOM에 추가 X)

```html
  <body>
    <div id="app">
      <table id="list">
        <thead>
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody id="contacts">
          <template v-for="(contact, index) in contacts" :key="contact.no">
            <tr>
              <td>{{contact.no}}</td>
              <td>{{contact.name}}</td>
              <td>{{contact.tel}}</td>
            </tr>
            <tr class="divider" v-if="index % 2 == 1">
              <td colspan="3"></td>
            </tr>
          </template>
        </tbody>
      </table>
    </div>
    <script src="https://unpkg.com/vue"></script>
    <script>
      let vm = Vue.createApp({
        name: 'App',
        data() {
          return {
            contacts: [
              { no: 101, name: '감자', tel: '132' },
              { no: 102, name: '고구마', tel: '391' },
              { no: 103, name: '옥수수', tel: '923' },
            ],
          };
        },
      }).mount('#app');
    </script>
  </body>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/383a4bb9-2226-4b8a-992a-67bc32859687/image.png">


<br>

### 3) v-for 디렉티브와 key 특성

- 렌더링 횟수를 최소화 하는게 좋음
- key 특성에는 인덱스 번호 부여X (**고유한 값 부여**)

<img src="https://velog.velcdn.com/images/seizethedai/post/3a5e8ce8-be8c-413d-8752-bb614b659f15/image.png">


<br>

### 4) 데이터 변경 시 주의사항
> - Proxy 객체
> 	- Vue3의 반응성을 제공하는 핵심 문법
>	- 데이터의 변경사항 감시
> 	- 값 변경 시 렌더링을 다시하도록 유도
>	- Vue 인스턴스의 data 옵션으로 지정한 객체
>	- data로 지정된 객체는 모두 proxy로 래핑됨                                           


```html
    <script>
      let model = {
        contacts: [
          { no: 101, name: '감자', tel: '132' },
          { no: 102, name: '고구마', tel: '391' },
          { no: 103, name: '옥수수', tel: '923' },
        ],
      };

      var vm = Vue.createApp({
        name: 'App',
        data() {
          return model;
        },
      }).mount('#app');
    </script>
```

<img src="https://velog.velcdn.com/images/seizethedai/post/bace876e-70a8-4473-ad7f-7d9592962729/image.png" width=500px>

- **데이터 변경 시 Vue 인스턴스 밖에서 선언된 객체, 배열을 직접 변경하면 X**
    - **_Vue 인스턴스 데이터를 변경해야 함_**
<br>

- Vue 인스턴스는 배열의 데이터를 변경하는 메서드도 래핑하고 있음
    - Watcher에게 변경을 알려 다시 렌더링을 일으켜야 함
        - push() , splice() , sort()

```html
<!-- 다시 렌더링되지 않음, Vue가 변경을 인지 못함               -->
model.contacts[0].tel = "123"
model.contacts.push({no:104, name:"강황", tel:"452"});

<!-- 다시 렌더링 됨-->
vm.contacts[1].tel = "932"
vm.contacts.push({no:105, name:"마", tel:"435"});
```
