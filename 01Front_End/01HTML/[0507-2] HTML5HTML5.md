# 1. 글자 태그

## 1) 제목 / 본문 글자 태그

`제목 글자` 
- &lt;h1&gt;, &lt;h2&gt;···&lt;h6&gt;
<br>

`본문 글자`
- &lt;p&gt; : 본문 단락 생성
- &lt;br&gt; : 줄 바꿈
- &lt;hr&gt; : 수평 줄 삽입

<img src="https://velog.velcdn.com/images/seizethedai/post/1ae1a102-2d20-4083-98ac-525fa7496f7b/image.png" width=300px>


> * _**특수 문자 표기**_ <br>
> 공백 : `&nbsp;` (NO-BREAK SPACE) <br>
> < : `&lt;` <br>
> &gt; : `&gt;` <br>
> & : `&amp;`

<br>

## 2) 앵커 태그

- a 태그 (anchor) <br>
    : 다른 웹페이지나 웹 페이지 내부의 특정 위치로 이동할 때 사용

- 하이퍼링크 생성 <br>
    `<a href="이동할 웹페이지 주소">출력 글자</a>`
    
- 웹 페이지 내부에 연결 <br>
    : id 속성을 추가로 사용
    
    <img src="https://velog.velcdn.com/images/seizethedai/post/7cf3f120-67a0-4cb6-9481-d19da9ab0ee2/image.png" width=400px>

```html
  <body>
    <a href="http://www.google.com">Google</a>
    <a href="http://www.daum.net">Daum</a>
    <a href="http://www.naver.com">Naver</a>
    <hr/>
    <a href="#alpha">Alpha 부분</a>
    <a href="#beta">Beta 부분</a>
    <a href="#gamma">Gamma 부분</a>
    <hr />
    <h1 id="alpha">Alpha</h1>
    <p>
      Lorem···
    </p>
    <h1 id="beta">Beta</h1>
    <p>
      Lorem···
    </p>
    <h1 id="gamma">Gamma</h1>
    <p>
      Lorem···
    </p>
    <p>
      Lorem···
    </p>
  </body>
```
<br>

# 2. 목록 태그
`ul` (unordered list) <br>
 : 순서 없는 목록 생성
 
`ol` (ordered list) <br>
: 순서 있는 목록 생성
    
`li` (list item) <br>
: 목록 요소 생성

<img src="https://velog.velcdn.com/images/seizethedai/post/4831eb5c-a6bb-46a5-8b02-aa584beef1e6/image.png" width=250px>


```html
  <body>
    <!-- 순서X -->
    <ul>
      <li>사과</li>
      <li>바나나</li>
      <li>오렌지</li>
    </ul>

    <!-- 순서O -->
    <ol>
      <li>사과</li>
      <li>바나나</li>
      <li>오렌지</li>
    </ol>
    <br />
    
    <!-- 중첩 목록 -->
    <ul>
      <li>
        <b>과일</b>
        <ol>
          <li>사과</li>
          <li>딸기</li>
          <li>바나나</li>
        </ol>
      </li>
      <li>
        <b>채소</b>
        <ol>
          <li>오이</li>
          <li>상추</li>
          <li>양배추</li>
        </ol>
      </li>
    </ul>
  </body>
```
<br>

# 3. 테이블 태그

## 1) 표 만들기

`<table>`
 : 표 삽입
 
`<tr>`
: 행(row) 삽입
    
`<th>`
: 제목 셀(heading) 생성

`<td>`
: 일반 셀(data) 생성

**&lt;table&gt; → &lt;tr&gt; → &lt;th&gt;/&lt;td&gt;**



<img src="https://velog.velcdn.com/images/seizethedai/post/47023ad2-8189-4fba-818e-ea92bc166341/image.png" width=300px>

```html
  <body>
    <!-- border : 표의 테두리 지정 -->
    <table border="1">
      <thead>
        <tr>
          <th></th>
          <th>월</th>
          <th>화</th>
          <th>수</th>
          <th>목</th>
          <th>금</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1교시</td>
          <td>영어</td>
          <td>국어</td>
          <td>과학</td>
          <td>미술</td>
          <td>기술</td>
        </tr>
        <tr>
          <td>2교시</td>
          <td>도덕</td>
          <td>체육</td>
          <td>영어</td>
          <td>수학</td>
          <td>사회</td>
        </tr>
      </tbody>
    </table>
  </body>
```

<br>

## 2) 테이블 태그 속성
- table <br>
`border` : 표의 테두리 굵기 지정

- th, td <br>
`colspan` : 셀 너비 지정 <br>
`rowspan` : 셀 높이 지정

<img src="https://velog.velcdn.com/images/seizethedai/post/d9fdccff-0bd6-4b86-854b-74e04f132f1b/image.png" width=150px>

```html
    <table border="1">
      <tr>
        <th colspan="2">지역별 홍차</th>
      </tr>
      <tr>
        <th rowspan="3">중국</th>
        <td>정산소종</td>
      </tr>
      <tr><td>기문</td></tr>
      <tr><td>운남</td></tr>
      <tr>
        <th rowspan="4">인도 및 스리랑카</th>
        <td>아삼</td>
      </tr>
      <tr><td>실론</td></tr>
      <tr><td>다질링</td></tr>
      <tr><td>닐기리</td></tr>
    </table>
```
> &lt;thead&gt;, &lt;tbody&gt;, &lt;tfoot&gt; 생략 가능

<br>

# 4. 미디어 태그

> **img** 태그는 내용을 가질 수 없음 <br>
> **audio** 태그와 **video** 태그는 내용을 가질 수 있음

- `<img>` 태그 속성
    - scr : 이미지 경로
    - alt : 이미지 없을 때 나오는 글 지정
    - width : 너비
    - height : 높이
    <br>
- `<audio>` `<video>` 태그 속성
    - scr : 음악, 비디오 파일 경로
    - preload : 음악, 비디오 준비 중일 때 데이터를 모두 불러올지 여부
    - autoplay : 자동 재생 여부
    - loop : 반복 여부
    - controls : 재생 도구 출력 여부
    <br>
    
- 웹 브라우저마자 지원하는 파일 확장자 다름 <br>
	→ 웹 브라우저가 재생 가능한 파일인지 확인하는 작업 필요<br>
	→ type="audio(video)/확장자"
    <br>
- 동영상 불러오는 동안 다른 이미지 보여주기 <br>
	→ poster=" "

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Media Tag</title>
  </head>
  <body>
    <!-- 이미지 -->
    <img src="https://buly.kr/4xVNC09" alt="강아지" width="300px" />
    <img src="Nothing" alt="이미지가 없습니다" width="300px" />

    <!-- 오디오 -->
    <audio src="kalimba.mp3" controls="controls"></audio>
    <!-- 웹 브라우저마다 지원하는 파일 확장자가 다른 문제 → source 태그 -->
    <audio controls="controls">
      <source src="Kalimba.mp3" type="audio/mp3" />
    </audio>

    <!-- 비디오 -->
    <video controls="controls">
      <source src="Wildlife.mp4" type="video/mp4" />
    </video>

    <!-- 동영상 불러오는 동안 다른 이미지 보여주기 -->
    <video controls="controls" poster="https://buly.kr/4xVNC09">
  </body>
</html>
```
