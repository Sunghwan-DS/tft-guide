# 도메인 주도 설계(DDD) 기반 마이크로서비스(MSA) 모델링
## 0. 목차
1. 마이크로서비스 개념
2. 마이크로서비스 개발 프로세스
3. 도메인 주도 설계(전략적 설계)
4. 도메인 주도 설계(전술적 설계)
5. 마이크로서비스 아키텍처 패턴
6. 커뮤니케이션 유형
7. 전략적 설계 기번 - 이벤트 스토밍 워크샵
8. 휴리스틱 설계 - 설계 의사 결정
9. 실습 - 이벤트 스토밍
10. 실습 - 마이크로서비스 별 도메인 모델 정의

## 1. 마이크로서비스 개념
### 1.1. 모노리스
##### 모노리스 시스템
- 애플리케이션이 한 덩어리로 구성
- 단일 프로세스 실행
- 한꺼번에 수정, 배포되어야 함
- 하나가 실패하면 모두 실패됨을 의미
- 모노리스를 클라우드 인프라에서 활용 시에
  - 스케일 아웃의 대상은 모노리스 전체가 됨
  - 그것만으로 충분히 확장성, 탄력성이 보장이 가능하나 비용 상 효율적이지 않음

##### 마이크로서비스
- 마이크로서비스는 애플리케이션이 여러 개의 서비스 조각으로 구성됨
  - 서비스는 각기 독립적인 기능을 제공
  - 서비스가 사용하는 저장소는 다른 서비스와 완벽히 격리됨
  - 따라서 독립적으로 수정 가능하며 별도 배포, 확장 가능
  - 하나의 서비스 실패는 전체 실패가 아닌 부분적인 실패를 의미
- 마이크로서비스 정의
  - Public I/F(Interface), 데이터 캡슐화
  - Martin Fowler
  - 확장 시, 특정 기능별 독립적으로 확장 가능
  - 특정 서비스의 변경 시, 서비스만 빌드, 배포
  - 독립적으로 서로 다른 언어로 개발 가능
  - 여러 개의 작은 서비스 집합으로 개발하는 접근 방법
  - 각 서비스는 개별 프로세스에서 실행
  - HTTP 자원 API 같은 가벼운 수단을 사용하여 통신
  - 서비스는 Biz 기능 단위로 구성
    - 중앙 집중적인 관리 최소화
  - 각 서비스는 서로 다른 언어, 데이터, 저장 기술 사용

## 2. 마이크로서비스 개발 프로세스
### 2.1. 마이크로서비스 개발을 위한 공정
- 스크럼 적용
- 아키텍처 정의
- 프론트 엔드/백엔드 설계
- 제품 백로그 -> 스프린트 계획수립 -> 스프린트 백로그 -> 스프린트 -> 마이크로서비스

### 2.2. 아키텍처 정의
- Outer Architecture 정의
  - Cloud Infra 정의
    - IaaS, PaaS, CaaS
  - Platform 구성요소, MSA 패턴
    - 라우팅, 로드 밸런싱, 인증/인가, 로깅, 트레이싱, 모니터링
  - DevOps Infra 정의
    - 형상관리, 빌드, 배포(CI/CD)
- Inner Architecture 정의
  - Front End
    - 기술 stack 정의
    - 내부 구조 정의
  - Back End
    - 기술 stack, 프레임웍
    - 내부 구조 정의
  - 통신
    - 서비스 간
    - 레거시 연계

### 2.3. 설계/구현
- divide and conquer
- 마이크로서비스 식별
  - 조직구성, 구성원 역량, 비지니스 서비스 성격, 변경/배포 빈도, 사용량, 운영 조직
  - 다양한 마이크로서비스 도출 기법
- 백 엔드 설계
  - 도메인 모델 설계
  - API 설계
  - 데이터 모델 설계
- 프론트 엔드 설계
  - UI 흐름
  - UI 레이아웃 정의
- 테스트
  - 단위
  - API
  - EtoE
- 배포
  - CI/CD

### 2.4. 마이크로서비스 도출
- 고려사항
  - 도메인 : 업무 영역, 제공서비스
  - 구성원 역량, 운영 조직 구조
  - 서비스 변경/배포 빈도
  - 사용량 : 트랜잭션 빈도
  - 데이터베이스 주제 영역 / 오너쉽

### 2.5. 도메인 주도 설계
- How 관점
- 업무 경계 (바운디드 컨텍스트, 어그리거드)

### 2.6. 시스템 복잡성
- 로컬 복잡성 : 각각의 개별 마이크로서비스의 복잡성
- 글로벌 복잡성 : 전체 시스템의 복잡성, 서비스 간의 상호작용과 의존성

### 2.7. 서브 시스템, 업무 영역
- 기능 분해를 통해 도출
- What 관점 : 업무를 제공하는 서비스, 비지니스 능력(조직이 하는 일)

### 2.8. 백 엔드 설계
- 비지니스 로직 설계 : 도메인 모델링
- 데이터 설계 : 데이터 모델링
- API 설계
  - REST API 설계 원칙
  - 성숙도

### 2.9. REST API 설계
- Contract(계약)
- REST 구성
  - Representational State Transfer : 자원의 정보를 주고 받는 구조
  - 자원(Resource) : URI 로 표햔(http://service/apis)
  - 행위(Verb) : HTTP Method(POST, GET, PUT, DELETE)
  - 표현(Representations) : HTTP POST http://service/apis {"apis" : {"name" : "sample"}}
- 행위 : HTTP Method 활용
  - POST   : 리소스 생성
  - GET    : 리소스 조회
  - PUT    : 리소스 수정
  - DELETE : 리소스 삭제
- HTTP 상태 코드
  - 200-level 성공
  - 400-level 잘못된 요청
  - 500-level 서버 에러
- REST API 디자인 가이드
  - Web API Design (http://www.apigee.com)
    - https://pages.apigee.com/rs/apigee/images/api-design-ebook-2012-03.pdf
    - REST API 설계는 아키텍처 스타일이지 표준은 아님. 유연하게 적용
    - API 의 목표는 개발자의 생산성과 성공을 극대화(실용주의)
- 자원
  - 간결하고 직관적인 기준 URL 유지. 가이드 문서가 필요없도록
  - 자원(Resource) 별로 두 가지 형식의 기준 URL 사용
    - GET /dogs      : 목록 조회
    - POST /dogs     : 개체 생성
    - PUT /dogs/1    : 1번 개체 수정
    - DELETE /dogs/1 : 1번 개체 삭제
    - GET /dogs/1    : 1번 개체 조회
  - 동사 보다는 명사 사용, 단수 명사보다는 복수 사용
    - /getDogs, /setDogs : X
    - GET /dogs, POST /dogs/{puppy}/owner/{terry}
- Idempotent (멱등성), Not Post
- Stateless, easy scale
- Versioning
  - /v1/products
  - /v2/products
- REST API 성숙도 모델
  - Richardson Maturity Model
  - https://martinfowler.com/articles/richardsonMaturityModel.html
    - Level 0: RPC
    - Level 1 : Resources
    - Level 2 : HTTP Verbs
    - Level 3: HATEOAS(Hypermedia As The Engine Of Application State)
- 명세방법 : 문서, Swagger

### 2.10. 프론트 엔드 설계
- UI 레이아웃 정의
  - 화면 흐름
  - UI 입출력 항목, 이벤트
