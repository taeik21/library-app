# library-app (도서 관리 API 서버)

Spring Data JPA를 활용해 생상성을 극대화하고, 클라우드 환경에 직접 백그라운드 배포를 이룬 도서 관리 API 서버입니다.

## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot, Spring Data JPA
- **Infrastructure:** AWS EC2, Gabia

## Key Features
- 도서 등록, 수정, 삭제 및 대출/반납 상태 관리 API
- 사용자 대출 기록 추적 기능
- 도메인 연결 및 백그라운드 서비스 배포

## Technical Decisions & Troubleshooting

### 1. Spring Data JPA를 통한 반복 코드 제거
순수 JPA나 SQL을 작성할 때 발생하는 반복적인 CRUD 코드를 `JpaRepository` 인터페이스를 통해 단축했습니다.

### 2. 응답 스펙을 위한 DTO 분리
- **문제:** 엔티티를 직접 API 응답으로 반환할 경우, 엔티티 구조가 변경되면 API 스펙 또한 변동되어 유지보수가 힘들어집니다.
- **해결:** 컨트롤러 계층과 서비스 계층 사이에 **DTO 패턴**을 도입했습니다. API가 요구하는 데이터만 담아 반환함으로써 엔티티를 보호하고 응답 스펙의 독립성을 보장했습니다.

### 3. 실제 서비스 배포 경험
`localhost`에서만 동작하던 애플리케이션을 외부 사용자가 24시간 접속할 수 있도록 구성했습니다. 가비아를 통해 도메인을 구입하고, AWS EC2 인스턴스에 백그라운드 실행 방식으로 서버를 배포하였습니다.
