# mini
## :bento: 장보기 프로젝트(Mart Project)

JAVA Swing Mini Project

-----------------------------------------
### :rice_ball: 기획의도
```
코로나로 인해 밖에 자주 나가지도 않아 마트에 
장 보러 가기도 힘든 상황에서 집에서 
손쉽게 음식 재료들을 구입할 수 있는 프로그램입니다.
```

### :memo: 프로젝트 소개
```
#KH마트
> 제한된 예산 내에서 상품을 구매할 때에 빠르게 가격을 계산할 수 있고, 
미성년자에게 팔 수 없는 상품을 제한 하는 프로그램을 만들고자 합니다.
```
### :corn: 유사프로그램 분석
* 마켓컬리 : 알뜰 쇼핑 이벤트
* SSG/이마트몰 : e-요리
* 배달의 민족 : 배달 시 나이 주류 제한

<공통점>
로그인 & 회원가입, 장바구니 페이지, 상품페이지, 이벤트 & 쿠폰 페이지, 마이페이지

### :fork_and_knife: 팀원
+ :strawberry: 김수민 - 로그인 & 회원가입
+ :tangerine: 이은솔 - 마이페이지
+ :lemon: 권세희 - 상품페이지
+ :watermelon: 정희준 - 장바구니페이지
+ :peach: 최승아 - 결제페이지
+ :apple: 이예지 - 레시피페이지
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/borasumin">
      <img src="https://avatars3.githubusercontent.com/u/73922587?s=460&v=4" alt="suminprofile"/><br />
      <sub>
      <b>
      borasumin<br/>
      :strawberry:
      </b>
      </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/essol2">
      <img src="https://avatars1.githubusercontent.com/u/73922496?s=460&v=4" alt="essol2profile"/><br />
      <sub>
      <b>
      essol2<br/>
      :tangerine:  
      </b>
      </sub>
      </a>
    </td>
     <td align="center">
      <a href="https://github.com/kwonsehee">
      <img src="https://avatars1.githubusercontent.com/u/48790779?s=460&u=d4c51c01b79d4caaa2b2f3b28ccf2e23075daf9e&v=4" alt="seheeprofile"/><br />
      <sub>
      <b>
      권세희<br/>
      :lemon:  
      </b>
      </sub>
      </a>
    </td>
      <td align="center">
      <a href="https://github.com/gmlgml98">
      <img src="https://avatars2.githubusercontent.com/u/73922783?s=460&v=4" alt="profile"/><br />
      <sub>
      <b>
      gmlgml98<br/>
      :watermelon: 
      </b>
      </sub>
      </a>
    </td>
       <td align="center">
      <a href="https://github.com/seungahh">
      <img src="https://avatars3.githubusercontent.com/u/73922848?s=460&u=472b1f342de5ef26b95a81ae7f4d0365ed1cf995&v=4" alt="seungaprofile"/><br />
      <sub>
      <b>
      seungahh<br/>
      :peach:  
      </b>
      </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Lee-ye-ji">
      <img src="https://avatars3.githubusercontent.com/u/59958929?s=460&u=f084b39c32e884337be6b229f6796c2283960844&v=4" alt="yejiprofile"/><br />
      <sub>
      <b>
      Lee-ye-ji<br/>
      :apple:  
      </b>
      </sub>
      </a>
    </td>
 </tr>
 <table>

### :hamburger: 기능 

+ :strawberry: 로그인 & 회원가입
```
1) 회원가입 시 받을 정보 
- 아이디 (중복 확인 기능 추가)
비밀번호 
(영문 대소문자, 특수문자 혼합 확인 기능 추가)
- 이름
- 나이 (미성년자 / 성인 확인하기 위해)
- 카드 번호 
2) 로그인 시
- 로그아웃 전까지 로그인 상태 유지
- 아이디, 비번 오류 -> 로그인 실패
```

+ :tangerine: 마이페이지
```
1) 회원정보 수정
- 본인확인 -> 비밀번호 확인
- 비밀번호, 카드번호 변경 가능
2) 포인트 충전
- 충전 금액 입력 후 결제 비밀번호 확인
- 충전 후 금액 변경
4) 보유 포인트 확인
5) 보유 쿠폰 확인
```

+ :lemon: 상품페이지
```
1) 상품 가격 / 재고 / 미성년자 표기
2) 상품 장바구니 담기 
- 장바구니 담기를 선택하면 장바구니에 상품 추가 
3) 나이 제한 (미성년자 / 성인)
4) 장바구니 부분과 연결
- 결제하기 -> 보유 금액/ 상품의 가격 확인
- 상품재고가 1 이상인 것을 체크 후 결제 
```
+ :watermelon: 장바구니페이지
```
1)  선택 물건 표시(수량,가격 등), 나이제한 표시
2) 수량 변동 시 
 -  가격의 합 변동
 - 재고 부족 시 -> 수량 부족 창 띄우기
3) 상품 제거 가능 
4) 구매 버튼 선택 시 
 -  결제 창 이동
```

+ :peach: 결제페이지
```
1 ) 결제 가능한 경우 
-> 계산금액 < 보유금액 
(보유 금액이 있는 경우)
2 ) 결제 불가능 한 경우 
-> 계산금액 > 보유금액
3) 결제 후 -> 보유 금액 차감
```

+ :apple: 레시피페이지
```
1) 오늘의 추천 메뉴
 - 선택지에 따라 메뉴가 달라지는 기능
( ex. 선택지 - 양식/ 일식/ 한식 / 등)
2) 재료 카테고리 
- 재료 키워드(ex.돼지고기)를 검색 시 
관련 요리들이 보여지는 기능
```

### :tropical_drink: 기획서 및 코드 분석
https://docs.google.com/presentation/d/1FAZUuA_0UAWSZ6AQQM63A7ubA6qk5b6a9u0yYaltHzs/edit#slide=id.ga80a82c5de_0_0

### :floppy_disk: 개발 환경
|  Language  |    IDE     |  Library   |
| ---------- | :--------- |----------: |
|    JAVA    |   Eclipse  |  Google    |
----------------------------------------------------------------------
## :computer: [프로그램 시현 영상]
![ezgif com-gif-maker](https://user-images.githubusercontent.com/59958929/101500475-e3df7800-39b1-11eb-8b18-8e40576f80e7.gif)


---------------------------------------------------------------





