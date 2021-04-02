

## 스프링 MVC 첫 세팅
1. 우측 상단 gradle눌러서 새로고침 한번
2. src/main/resources폴더로 가서 application.properties 파일에
   `server.port = 80`으로 수정
3. src/main/java에 MvcApplication클래스 main메서드 실행해서 서버띄우기
4. 한글 인코딩 필터 설정 (main/resources/application.properties)
```
# 서버 포트 변경
server.port = 80

# 한글 인코딩 적용
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true
```

## 스프링 MVC 기본 설정
1. 뷰리졸버 등록
- 메인메서드가 있는 클래스 혹은 config클래스 (@Configuration)에 아래의 내용을 작성
```java
//뷰 리졸버 등록 : 컨트롤러가 리턴한 문자열을 가지고 뷰 파일을 포워딩해주는 객체
@Bean
public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
}
```

2. 데이터베이스 설정
   - C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에서 ojbc6.jar
   - 아래 설정 경로 WEB-INF/lib에 추가하기
   '''groovy
   //database 관련 라이브러리 추가
   //jdbc 라이브러리
   compile "org.springframework.boot:spring-boot-starter-jdbc"
   //오라클 라이브러리(11g edition - gradle, maven 랑센스 문제 공식 지원 불가)
   compile fileTree(dir: '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])   
'
     
- 스프링에게 Datasource정보 알려주기 (Hikari DataSource)
## JSP 파일 템플릿
```jsp

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>
```

-DB 실습준비작업 ORACLE
sqlplus
sys /as sysdba
oracle
CREATE USER java_web1 IDENTIFIED BY 202104;
GRANT CONNECT, DBA TO java_web1;

-- 시퀀스 생성
CREATE SEQUENCE seq_score;

CREATE TABLE tbl_score (
stu_num NUMBER(10),
name VARCHAR2(50) NOT NULL,
kor NUMBER(3) NOT NULL,
eng NUMBER(3) NOT NULL,
math NUMBER(3) NOT NULL,
total NUMBER(3),
average NUMBER(5, 2)
);

ALTER TABLE tbl_score ADD CONSTRAINT pk_score PRIMARY KEY (stu_num);

SELECT * FROM tbl_score;

INSERT INTO tbl_score VALUES (seq_score.nextval, '김철수',90,90,90,270,90.00);
INSERT INTO tbl_score VALUES (seq_score.nextval, '박영희',80,80,80,240,90.00);
INSERT INTO tbl_score VALUES (seq_score.nextval, '고길동',70,70,70,210,70.00);
COMMIT;

	//마이바티스 라이브러리
	compile "org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.0"