# 🖐️ 핸즈업 (HandsUp): 대학생들을 위한 온라인 공론장

> 💻 개발 기간 | 2025.11.22 ~ 2025.11.23

<p align="center">
  <img width="800" alt="handsup-main" 
       src="https://github.com/user-attachments/assets/7a4a00a7-9f12-41b5-a6ce-d414276038e6" />
</p>

---
<br/>

## 💎 서비스 소개

> **내 손으로 만드는 대학교, 핸즈업🖐️**

**핸즈업은 우리 대학에 대해 누구나 의견을 낼 수 있는 온라인 공론장입니다.** 매년 주민들이 광장에 모여 중대사를 거수투표로 결정하는 스위스의 전통적인 직접민주주의 제도 “란츠 게마인데”를 본떠 만들었습니다. 학생과 학생회 양측에서 민주적으로 교내 정치에 참여할 수 있는 소통창구를 제공합니다.

<br/>

<p align="center">
  <img width="822" alt="안건 등록하기" src="https://github.com/user-attachments/assets/b9c8a8a2-759e-4dc5-9f25-c891c982660f" />
  <br/>
  <strong>학생들이 자율적으로 투표하고 싶은 안건을 등록할 수 있습니다.</strong>
</p>
<br/>

<p align="center">
  <img width="822" alt="안건 추천하기" src="https://github.com/user-attachments/assets/83a4f8d7-1ba3-4645-9da2-f3899d99af61" />
  <br/>
  <strong>안건 탭 페이지에서 등록된 안건들을 학생들이 추천할 수 있으며, 일정 추천 수가 넘어가면 ‘투표 안건’으로 넘어가 투표 기간에 투표를 진행하게 됩니다.</strong>
</p>
<br/>

<p align="center">
  <img width="822" alt="안건 투표하기" src="https://github.com/user-attachments/assets/413fa507-f2e7-4b50-b169-b2edcd663c2c" />
  <br/>
  <strong>추천하기 단계에서 선정된 안건들을 학생들이 찬성/반대로 손을 들어 투표할 수 있습니다.</strong>
</p>
<br/>

<p align="center">
  <img width="822" alt="정책변화" src="https://github.com/user-attachments/assets/6d8937fa-0478-4d66-a39c-cd6d4f80fce4" />
  <br/>
  <strong>진행 중인 투표 목록은 실시간으로 확인할 수 있으며, 이후 총학생회가 해당 안건을 실제 교내 정치에 도입한 과정 및 결과를 학생들에게 공유하도록 합니다.</strong>
</p>
<br/>

## 👨‍💻 팀원 소개

<br/>

<table align="center">
  <tr>
    <td align="center">
      <img width="200" height="200" alt="member1" src="https://github.com/user-attachments/assets/843828c1-f0f1-4333-82f6-2efc049d4880" /><br/>
      <b>곽재민</b><br/>
      <code>Backend Developer</code><br/>
      <a href="https://github.com/woals2840">GitHub</a>
    </td>
    <td align="center">
      <img width="200" height="200" alt="member2" src="https://github.com/user-attachments/assets/6d9590b3-1590-4e28-bb43-c57612216554" /><br/>
      <b>정원준</b><br/>
      <code>Backend Developer</code><br/>
      <a href="https://github.com/dietken1">GitHub</a>
    </td>
  </tr>
</table>
<br/>

## ⚙️ 기술 스택
### ✤ Tech Stack
| 👀 Category | ⚒️ Tech | 📝 Description |
|:----------:|:------:|:-------------:|
| **`Backend`** | Spring Boot, Java 17, Gradle | 핵심 비즈니스 로직 및 API 서버 구현 |
| **`Reverse Proxy`** | Nginx | 요청 라우팅 및 리버스 프록시 |
| **`Database`** | MySQL | 영속 데이터 저장 |
| **`Infrastructure`** | AWS, Docker | 서버 인프라 구성 및 컨테이너화 |
| **`CI/CD`** | GitHub Actions | CI/CD 자동화 |
| **`Collaboration`** | GitHub, Notion, Swagger, Figma, Postman | 협업, 문서화 및 API 명세 관리 |

<br/>

## 📊 ERD
<br/>
<p align="center">
<img width="1122" height="673" alt="ERD-placeholder" src="https://github.com/user-attachments/assets/ddfe553a-5158-4e3d-bcfc-4028158d87f5" />
</p>
<br/>

## 📏 개발 컨벤션
### Git
**✤ `Git Workflow`**
- **`Issue`** → **`Branch`** → **`PR`** → **`Review`** → **`Merge`** 의 흐름을 준수합니다.
- `main` 또는 `develop` 브랜치에 직접 커밋하지 않습니다.
<br/>

**✤ `Branch & Commit`**
- **Branch**: `<prefix>/#<issue-number>` (e.g., `feat/#12`, `fix/#25`)
- **Commit Message**: `[<prefix>/#<issue-number>] 설명` (e.g., `[feat/#1] 로그인 API 구현`)
  <br/>

**✤ `Pull Request`**
- **PR Title**: `[prefix/#<issue-number>] 설명`

---

### Code
**✤ `네이밍 규칙`**
- **Class**: PascalCase  
- **Method / Variable**: camelCase  
- **DB Table**: snake_case  
- **Constant**: UPPER_SNAKE_CASE  

**✤ `메서드 네이밍`**
- 조회: `find...()`, `get...()`
- 생성: `create...()`, `save...()`
- 수정: `update...()`
- 삭제: `delete...()`

**✤ `DTO 네이밍`**
- **Request**: `...Request` (e.g., `CreateIssueRequest`)
- **Response**: `...Response` (e.g., `IssueInfoResponse`)
  
<br/>

## 🌳 백엔드 패키지 구조
```
src/main/java/com/soptkathonserverandroid2
├── Application.java
├── domain
│   ├── issue
│   │   ├── controller
│   │   ├── dto
│   │   │   ├── request
│   │   │   └── response
│   │   ├── entity
│   │   │   └── enums
│   │   ├── repository
│   │   └── service
│   ├── recommend
│   │   ├── controller
│   │   ├── entity
│   │   ├── repository
│   │   └── service
│   ├── user
│   │   ├── entity
│   │   │   └── enums
│   │   ├── repository
│   │   └── service
│   └── vote
│       ├── controller
│       ├── dto
│       │   ├── request
│       │   └── response
│       ├── entity
│       ├── repository
│       └── service
└── global
    ├── config
    ├── exception
    │   ├── code
    │   └── dto
    └── handler
```
