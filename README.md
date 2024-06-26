#  👨🏻‍💻 혼자 진행하는 Spring 프로젝트
- SpringBoot 에 대한 개념을 잊지 않고, 기술들을 복습 및 학습하기 위해 진행하는 미니 프로젝트입니다.


## 프로젝트 개요
> **🤩 프로젝트 이름 : SpringBoard** <br/>
**📆 개발기간: 2024.06.09 ~ing** <br/>
**🛠️ 언어 : Spring Boot** <br />


## 기술 스택
- BE : SpringBoot, Spring Security, Spring Data JPA, Sring Batch
- DB : MySQL, Redis
- Search : Query DSL, Elastic Search

## ERD
<img width="853" alt="스크린샷 2024-06-09 오후 4 59 37" src="https://github.com/kyungmin1221/SpringBootBoard/assets/105621255/9d9f2cc5-5a99-4632-a040-27f01a76bcfd">

## 주요 기능 구상 
1. 사용자 관리

- 회원가입 및 로그인
- JWT 기반 인증 시스템
- Access Token 및 Refresh Token을 이용한 사용자 인증

2. 포트폴리오 관리

- 포트폴리오 작성, 조회, 수정, 삭제 기능
- 포트폴리오 조회 시 Redis 캐싱을 이용한 성능 최적화
- 캐싱을 적용했을 때와 하지 않았을 때의 성능 비교

3. 검색 기능

- QueryDSL을 사용한 게시글 검색 기능
- Elasticsearch를 이용한 전체 텍스트 검색 기능

4. 배치 작업

- Spring Batch를 이용한 정기적인 데이터 처리 작업

