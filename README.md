# springboot를 이용한 블로그 만들기 후기

이 프로젝트는 혼자서 진행하였습니다.
혼자만의 힘으로 서비스를 출시하는게 목표였기때문에 욕심부리지 않고 핵심 기능을 제외한 나머지는 
무시하고 가는게 좋다고 생각하여 간단하게 요구분석을 작성하고 더 필요한 기능 등은 천천히 추가하는 방식(MVP, Minimum Viable Product)으로 프로젝트를 진행하였습니다.

- 요구분석
1. 게시글등록
2. 게시글삭제
3. 게시글수정
4. 댓글기능
5. 페이징기능
6. 회원가입 (중복체크)
7. 로그인 / 로그아웃
8. 구글,네이버 로그인기능 
9. 배포 (AWS)
10. 배포 자동화 (Travis CI)
11. 무중단 배포
12. 파일업로드,다운로드


저는 독학으로 공부한다음 프로젝트를 진행하였기 때문에 부족한 부분을 보완해 나가며, 코딩을 이렇게 하는 방식이 정말 옳은 것인지, 더 간단하게 할 방법은 없는 것인지, 최신방식은 어떠한것인지 등에 고민이 많아져서 시간이 더 소모되었습니다. 하지만 오히려 이 부분이 서버템플릿의 스프링부트 권장방식인 thymeleaf를 사용하는 등 자신이 몰랏던 기술에 대해 도전하게 되었던 것 같습니다.

그리고 저는 테스트 코드에 대해 중요성을 모르고 프로젝트를 진행하였는데 매번 코드를 작성 및 수정할때마다 프로그램을 실행한뒤 API테스트 도구로 HTTP요청하고 요청결과를 검증하는 식으로 하였는데 이 작업이 얼마나 멍청한지 알게되었습니다. 결국 테스트코드 작성은 숙제로 남게 되었습니다.

아쉬운 점으로는 숙제로 남게된 테스트 코드와 디자인적으로 아쉬웠다는 점입니다. 이 프로젝트를 교훈삼아 여러가지 기술을 보완 및 습득해야할 계기가 되었습니다.  


- 기술스택

HTML CSS Javascript

Bootstrap JQuery 

Springboot Springsecurity Oauth2 JPA Thymeleaf

AWS TravisCI NginX
