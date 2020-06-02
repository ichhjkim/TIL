# SQLD_SQL 기본 및 활용 1



## 데이터 조작어

| 비절차적 데이터조작어                      | 절차적 데이터 조작어                        |
| ------------------------------------------ | ------------------------------------------- |
| 사용자가 무슨 데이터를 원하는지 명세(WHAT) | 어덯게 데이터를 접근해야하는 지를 명세(HOW) |



## 테이블 변경



#### 이름 변경

- RENAME <테이블명> TO <테이블명2>;'



## 테이블 칼럼에 대한 정의 변경



### 칼럼변경

- 오라클
  - ALTER TABLE <테이블명> MODIFY (칼럼명1 데이터유형 default Not NULL 여부);
- SQL server
  - ALTER TABLE <테이블명> ALTER COLUMN <컬럼명> 데이터유형 default 여부 NOT NULL여부;



### 칼럼 삭제

- 오라클
  - ALTER TABLE <테이블명> DROP COLUMN <컬럼명>;



## NULL 이란?

NULL은 공백문자/숫자 0과 동일하지 않다.

아직 정의되지 않은 미지의 값이다.

- NULL을 검증할 떄는 IS NULL 또는 IS NOT NULL 을 써야한다.



### NULL 관련 함수

- NVL(컬럼, 결과값)/ISNULL(컬럼, 결과값) : 해당 컬럼에 해당되는 값이 NULL이면 결과값을 출력한다.
- NULLIF(컬럼, 조건): 컬럼과 조건이 같으면 NULL을 아니면 해당 컬럼값을 리턴한다.
- COALESCE(표현식1, 표현식2, ...): 임의의 개수 표현식에서 NULL이 아닌 최초의 표현식을 나타낸다. 모든 표현식이 NULL이면 NULL을 리턴한다.



## UNIQUE 특징

- 테이블 내에 중복되는 값이 없다
- NULL 값 입력 자체는 가능하다



## PK(기본키) 특징

- 주키로 테이블당 1개만 생성 가능
- UNIQUE(고유성), 최소성 만족
- `PK는 그러므로 NULL 값을 절대 가지지 않는다`.



## 참조무결성 규정



| 종류        | 의미                                                         |
| ----------- | ------------------------------------------------------------ |
| Cascade     | master 삭제시, child 같이 삭제                               |
| Set Null    | Master 삭제시, child 해당 필드 Null                          |
| Set Default | Master 삭제시 해당 필드 Default                              |
| Restrict    | Child 테이블에 PK값이 없는 경우만 Master 삭제 허용           |
| No Action   | 참조무결성을 위반하는 삭제/수정 액션을 취하지 않음           |
| Dependent   | child 테이블의 FK 생성시, Parent 테이블에 PK가 없는 경우 Child Table 데이터 입력을 허용하지 않음 |

RESTRICT -  master 있으면 삭제 못하게

DEPENDENT - master 없으면 못만들게

## 테이블 삭제



| DROP                                     | TRUNCATE                                                     | DELETE                                                       |
| ---------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| DDL                                      | DDL(일부 DML 성격)                                           | DML                                                          |
| ROLLBACK 불가능                          | ROLLBACK 불가능                                              | COMMIT 이전 ROLLBACK 가능                                    |
| AUTO COMMIT                              | AUTO COMMIT                                                  | 사용자 COMMIT                                                |
| 테이블이 사용했던 Storage를 모두 Release | 테이블이 사용했던 storage 중 최초 테이블 생성시 할당된 storage만 남기고 release | 데이터를 모두 delete해도 사용했던 storage는 release되지 않는다 |
| 데이블 정의 자체를 완전히 삭제(스키마도) | 테이블의 최초 생성된 초기 상태(스키마는 남겨져 있음)         | 데이터만 삭제                                                |

**TRUNCATE**는 UNDO를 위한 데이터를 생성하지 않기 때문에 동일 데이터량 삭제시 DELETE보다 빠르다.



## 트랜잭션-01



| 특징   | 의미                                                         |
| ------ | ------------------------------------------------------------ |
| 원자성 | 트랜잭션에서 정의된 연산들은 모두 성공적으로 실행되던지 아니면 전혀 실행되지 않은 상태로 남아있어야 한다.(All or Nothing) |
| 일관성 | 트랜잭션이 실행되지 전의 데이터베이스 내용이 잘못되어 있지 않다면, 트랜잭션이 실행된 이후에도 데이터베이스 내용에 잘못이 있으면 안된다 |
| 고립성 | 트랜잭션이 실행되는 도중에 다른 트랜잭션의 영향을 받아 잘못된 결과를 만들어서는 안된다 |
| 지속성 | 트랜잭션이 성공적으로 수행되면 그 트랜잭션이 갱신한 내용은 영구적으로 저장된다. |



### 트랜잭션의 격리성이 낮은 경우 발생할 수 있는 문제점

| 특징                | 의미                                                         |
| ------------------- | ------------------------------------------------------------ |
| Dirty Read          | 다른 트랜잭션에 의해 수정되었지만 아직 커밋되지 않은 데이터를 읽는 것 |
| Non-Repeatable Read | 한 트랜잭션 내에서 같은 쿼리를 2번 수행했는데, 그 사이에 다른 트랜잭션 값을 수정 또는 삭제하는 바람에 두 쿼리 결과가 다르게 나타나는 현상 |
| Phantom Read        | 한 트랜잭션 내에서 같은 쿼리를 2번 수행했는데 첫번째 쿼리에서 없던 유령 레코드가 두번째 쿼리에서 나타나는 현상 |
|                     |                                                              |



## 트랜잭션 02- COMMIT & ROLLBACK



### COMMIT 특징

- oracle에서는 DDL  문장 수행 후 자동으로  COMMIT을 실행 + ORACLE에서 DDL 문장의 수행은 내부적으로 트랜잭션을 종료!

- SQL server 에서는 DDL 문장 수행 후 자동으로 COMMIT을 수행하지 않는다.

  그러므로, SQL server에서 DDL은 한 트랜잭션 범주에 포함된다. 그러므로 ROLLBACK 수행 시 DDL도 함께 없어진다.

  

  | ORACLE                                                       | SQL server                                                   |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | DDL 문장 수행 : 한 트랜잭션의 이행<br />그러므로, DDL 문장 수행의 의미 = COMMIT 실행 + 한 트랜잭션 종료 | DDL 문장 이라고 특별하지 않음<br />그러므로, ROLLBACK 할 시 DDL도 포함될 수 있음 |



### ROLLBACK 

COMMIT 이전 변경 사항을 취소할 수 있다. COMMIT 하면 끝!

COMMIT 되지 않은 상위의 모든 트랜잭션을 ROLLBACk!



## 트랜잭션 03 - 시작과 저장점



 ### 시작과 종료



`BEGIN TRANSACTION`;

`(TRANSACTION) COMMIT;` 또는 `ROLLBACK (TRANSACTION);`



--> ROLLBACK을 만나면 최초의 BEGIN TRANSACTION 시점까지 모두 ROLLBACK이 수행된다.



### 저장점(SAVEPOINT)

원래는 COMMIT 이전까지 ROLLBACK 하는데, 저장점을 사용하면, 

현 시점에서 SAVEPOINT까지 트랜잭션의 일부만 롤백



## 내장함수(Built-in Function)



함수 -- `내장함수`

​			--- 단일행 함수: SELECT, WHERE, ORDER BY, UPDATE의 SET 절에서 하용가능하다.(HAVING은 없다)

​			--- 다중행 함수

​				---- 집계함수

​				---- 그룹함수

​				---- 윈도우함수

​		-- `사용자가 정의할 수 있는 함수`



함수의 입력 행수에 따라 단일행 함수와 다중행 함수로 구분한다.



풀이

1:M관계의 조인이라 하더라도 M 쪽에서 출력된 행이 하나의 단일행 함수의 입력값으로 사용되므로 사용할 수 있다.

다중행 함수도 단일행함수와 동일하게 단일값만을 반환한다

-> 단일행함수든 다중행 함수든 모두 `단일값`만을 반환!



## 날짜

오라클에서 날짜 연산은 숫자의 연산과 같다. 특정 날짜에 1을 더하면 하루를 더한 결과와 같으므로 

1/24/60 = 1분을 의미한다.



## CASE-WHEN



CASE 

​	WHEN <칼럼명> = <조건> THEN 결과값

​	ELSE 결과값2

END



-----



CASE

​	<컬럼명> WHEN 조건 THEN 결과값

​	ELSE 결과값2

END



 ## GROUP BY & HAVING 절



### GROUP BY

- 소그룹별 기준을 정한후 SELECT 절에 집계 함수를 사용

- 집계함수의 통계 정보는 `NULL값을 가진 행을 제외`하고 수행

- `GROUP BY 절에서는 ALIAS 명을 사용할 수 없다`

- 집계함수는 WHERE 절에는 올 수 없다(GROUP BY 절보다 WHERE 절이 먼저 수행되기 떄문)

  




### HAVING 절

- GROUP BY 절의 기준항목이나 소그룹의 집계함수를 이용한 조건을 표시가능
- 제한 조건을 두어 조건을 만족하는 내용만 출력
- 일반적으로 GROUP BY 뒤에 위치
- GROUP BY 없어도 쓰는거는 가능하기는 함



## ORDER BY

SQL 실행 순서에 의하면 SELECT 절 이후에 ORDER BY 절 수행 -> SELECT 절에 기술되지 않는 컬럼을 정렬하는 것은 논리적으로 맞지 않다. 하지만, 오라클은 행기반 DATABASE이기에 데이터를 엑세스 할 때 행전체 칼럼을 메모리에 로드한다. 이와 같은 특성으로 인해 SELECT절에 기술되지 않은 칼럼으로도 정렬을 할 수 있다.



#### ORDER BY 1, 2란?

켤렴 순서 기준

| NAME  | JOB     |
| ----- | ------- |
| SMITH | CLERK   |
| JONES | MANAGER |

일떄,

ORDER BY 1, 2;를 하면

NAME을 기준으로 

이 경우, 알파벳 순서대로 오름차순

그 다음 동일한 경우

JOB 컬럼을 기준으로 정렬하면 된다



ORDER BY는 SELECT절에서 오직 한개만 올 수 있기 때문에 ORDER BY는 메인쿼리의 마지막 문장에 위치해야한다.



## TOP() 예제

TOP(N) 질의문에서 N에 해당하는 값이 동일한 경우 함께 출력되도록 하는 WITH TIES 옵션을 ORDER BY와 함께 사용해야한다.



ORDER BY에 적힌 기준으로 TOP N개를 뽑는다.



## JOIN



### 특징

- 여러 테이블로부터 원하는 데이터를 조회하기 위해서는 전체 테이블 개수에서 최소 N-1개의 JOIN 조건 필요
- 일반적으로 JOIN은 PK와 FK 값의 연관성에 의해 성립된다
  - 하지만 어떤 경우에는 PK, FK 의 관계가 없어도 논리적인 값들의 연관만으로도 JOIN이 성립된다.
- EQUI JOIN은 JOIN에 관여하는 테이블 간의 컬럼 값들이 정확하게 일치하는 경우 사용
- EQUI JOIN은 = 연산자에 의해서만 수행되면 그 외 비교 연산자를 사용하는 경우는 Non EQUI JOIN이다.
- 대부분 Non EQUI JOIN을 수행할 수 있지만, 때로는 설계상의 이유로 수행이 불가능한 경우도 있다.



**순수관계연산자**

SELECT, PROJECT, JOIN, DIVIDE



**USING**: JOIN칼럼에 대해서는 ALIAS나 테이블 이름같은 접두사를 둘 수 없다. 



--다음이 모두 동일--

```sql
SELECT TEAM.REGION_NAME, TEAM.TEAM_NAME, TEAM.STADIUM_ID, STADIUM.STADIUM_NAME
FROM TEAM INNER JOIN STADIUM
ON (TEAM.STADIUM_ID = STADIUM.STADIUM_ID);
```



```sql
SELECT T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, S.STADIUM_NAME
FROM TEAM T, STADIUM S
WHERE T.STADIUM_ID = S.STADIUM_ID;
```



```sql
SELECT TEAM.REGION_NAME, TEAM.TEAM_NAME, TEAM.STADIUM_ID,STADIUM.STADIUM_NAME
FROM TEAM, STADIUM
WHERE TEAM.STADIUM_ID = STADIUM.STADIUM_ID
```



inner join은 중복된 값을 제거하지 않고 다나와서 1:N관계에서 중복된 값을 제거하려면 GROUP BY를 해야한다.



### CROSS JOIN

일반 집합 연산자의 PRODUCT의 개념으로 테이블간 JOIN 조건이 없는 경우 생길 수 있는 모든 데이터의 조합을 말한다.     

-> 양쪽 집합의 M*N 건의 데이터 조합이 발생한다.

카테시안곱

CROSS JOIN

### LEFT OUTER JOIN

조인 수행시 먼저 표기된 좌측 테이블에 해당하는 데이터를 먼저 읽은 후, 나중 표기된 우측 테이블에서 JOIN 대상 데이터를 읽어온다

A(기준)와 B를 비교해서 B의 JOIN컬럼에 같은 값이 있을 때 그 해당 데이터를 가져오고 B의 JOIN칼럼에서 같은 값이 없는 경우 B에서 가져오는 칼럼들은 NULL 값으로 채운다.

**순서**

먼저 A 데이터 다 읽고 -> ON 조건에 따라 B와 JOIN -> B의 칼럼에 해당하는 값이 없는 경우 모두 NULL 값으로 채운다



### FULL OUTER JOIN

조인 수행시 좌측, 우측 테이블의 모든 데이터를 읽어 JOIN하여 결과를 생성. 즉, TABLE에 A와 B가 있을 때 RIGHT OUTER JOIN과 LEFT OUTER JOIN의 결과를 합집합으로 처리한 결과와 동일



--모두 같은 것--

```sql
SELECT A.ID, B.ID
FROM A FULL OUTER JOIN B
ON A.ID = B.ID
```



```sql
SELECT A.ID, B.ID
FROM A LEFT OUTER JOIN B
ON A.ID = B.ID
UNION
SELECT A.ID, B.ID
FROM A RIGHT OUTER JOIN B
ON A.ID = B.ID
```



```sql
SELECT A.ID, B.ID
FROM A, B
WHERE A.ID = B.ID
UNION ALL
SELECT A.ID, NULL
FROM A
WHERE NOT EXISTS (SELECT 1 FROM B WHERE A.ID = B.ID)
UNION ALL
SELECT NULL, B.ID
FROM B
WHERE NOT EXISTS (SELECT 1 FROM A WHERE B.ID = A.ID );
```



### UNION ALL vs UNION

| UNION ALL                   | UNION                      |
| --------------------------- | -------------------------- |
| 중복 레코드 유지, 정렬 안함 | 중복 레코드 제거, 정렬 함1 |



### 집합연산자

- `UNION` : UNION기능
- `INTERSECTION`: INTERSECT 기능 -> 중복된 행은 하나의 행
- `DIFFERENCE 연산` : EXCEPT 기능(오라클은 MINUS) -> 차집합. 중복된 행은 하나의 행
- `PRODUCT`연산 : CROSS JOIN 기능으로 구현됨



## 계층형 구조

> 테이블에 계층형 데이터가 존재하는 경우 데이터를 조회하기 위해서 계층형 질의를 사용한다. **동일 테이블에 **계층적으로 `상위와 하위데이터`가 포함된 데이터를 말한다.



PRIOR : CONNECT BY 절에 사용되면, 현재 읽은 칼럼을 지정한다.  

`PRIOR` `자식 = 부모` 형태를 이용하면 계층구조에서 부모 데이터에서 자식 데이터 방향으로 전개하는 순반향을 전개

그리고` PRIOR` `부모 = 자식` 형태를 사용하면 반대로 자식 데이터에서 부모데니터로 역방향 전개



### 특징

- START WITH 절: 계층 구조의 시작점을 지정
- ORDER BY SIBLINGS BY : 형제 노드 사이에서 정렬을 지정하는 구문
- 순방향 전개란 부모노드에서 자식노드방향으로 전개하는 것
- 루트노드의 LEVEL 값은 1

- SQL server에서 계층형 질의문은 CTE(Common Table Expression)을 재귀호출함으로써 계층 구조를 전개
- SQL server에서 계층형 질의문은 앵커멤버를 실행하여 기본 결과 집합을 만들고 이후 재귀 멤버를 지속적으로 실행
- 오라클의 계층형 질의문에서 WHERE 절은 모든 전개를 진행한 이후 필터 조건으로서 조건을 만족하는 데이터만 추출하는데 활용
- 오라클의 계층형 질의문에서 PRIOR 키워드는 `CONNECT BY`는 물론 `SELECT`, `WHERE` 절에서도 사용할 수 있따. 

```sql
SELECT 사원번호, 사원명, 입사일자, 매니저 사원번호
FROM 사원
START WITH 매니저 사원번호 is NULL
CONNECT BY PRIOR 사원번호 = 매니저 사원번호
AND 입사일자 BETWEEN '2013-01-01' AND '2013-12-31'
ORDER SIBLINGS BY 사원번호;
```

START WITH ~~ IS NULL

CONNECT BY PRIOR 자식 = 부모

ORDER SIBLINGS BY 자식;

## SELF JOIN

동일 테이블 사이의 조인을 말한다. 따라서 FROM 절에 동일한 테이블이 2번 이상 나타난다. 동일 테이블 사이의 조인을 수행하면 테이블과 컬럼 이름이 모두 동일하기 떄문에 반드시 `테이블 별칭(ALIAS)`를 사용해야한다.

** GROUP BY는 ALIAS 쓰면 안됨

```sql
SELECT ALIAS1.칼럼명,
		ALIAS2.칼럼명,
FROM  테이블 ALIAS1
	  테이블 ALIAS2
WHERE ALIAS1.칼럼명2 = ALIAS2.칼럼명1;
```



## 서브쿼리



### 특징

- 서브쿼리는 단일행 또는 복수행 비교연산자와 함꼐 사용할 수 있다.

- 서브쿼리는 `SELECT`, `FROM`, `HAVING`, `ORDER BY` 절 등에서 사용할 수 있다

- 서브쿼리의 결과가 복수행 결과를 반환하는 경우에는 `IN, ALL, ANY`등의 복수행 비교연산자와 사용해야한다

- 연관 서브쿼리는 서브쿼리가 메인 쿼리 컬럼을 포함하고 있는 형태의 서브쿼리이다.

- 다중 컬럼 서브쿼리는 서브쿼리의 결과로 여러 개의 컬럼이 반환되어 메인 쿼리의 조건과 비교되는데, `SQL server` 에서는 현재 지원하지 않는 기능이다.

  단일행/다중행 함수는 단일값 반환
  
  단일행 비교연산자/다중행 비교연산자와 다름

| 단일행 비교연산자              | 다중행 비교연산자    |
| ------------------------------ | -------------------- |
| 결과는 반드시 한 행            | 여려개의 행          |
| =, <, >, <=, >=, <>(같지 않음) | IN, ANY, ALL, EXISTS |



#### 다중행 연산비교자

| 다중행 연산 | 설명                                                         |
| ----------- | ------------------------------------------------------------ |
| IN          | 서브쿼리의 결과중 하나만 동일하면 참                         |
| ALL         | 메인쿼리와 서브쿼리의 결과가 모두 동일하면 참 ALL(20, 30)    |
| ANY         | MAIN쿼리의 비교조건이 서브쿼리의 결과중 하나 이상 동일하면 참 |
| EXISTS      | 메인쿼리와 서브쿼리의 결과가 하나라도 존재하면 참            |



### 종류

- FROM 구에서 쓰는 인라인 뷰
- SELECT문에서 쓰는 **스칼라 서브쿼리**
  - WHERE구에 SELECT문을 사용하면 그냥 서브쿼리다.
  - 스칼라 서브쿼리는 반드시 **한 행**, **한 칼럼**만 반환함

- 연관 서브쿼리: 서브쿼리내에서 `Main 쿼리의 칼럼`을 사용하는 것



### 주의 사항

- 서브쿼리는 괄호로 감싸서 사용한다.

- 서브쿼리는 단일행 또는 복수행 비교연산자와 함께 사용 가능한다.  

  - 단일행 비교 연산자는 서브쿼리의 결과가 반드시 1건이하여야 하고 =, <, >, <=, >=, <>
  - 복수행 비교연산자는 서브쿼리의 결과 건수와 상관없다, in ,ALL, ANY
  - 단일행 서브쿼리의 비교연산자는 다중 행 서브쿼리의 비교연산자로 사용할 수 없지만, 다중 서브쿼리의 비교연산자는 단일행 서브쿼리의 비교연산자로도 사용할 수 있다

- 서브쿼리에서는 `ORDER BY를 사용하지 못한다.`

- 비연관 서브쿼리는 주로 메인쿼리에 값을 제공하기 위한 목적으로 사용

- 메인쿼리의 결과가 서브쿼리로 제공될 수도 있고, 서브쿼리의 결과가 메인쿼리로 제공될 수 도 있다. 이는 실행순서는 상황에 따라 달라진다. 그러므로 서브쿼리는 항상 메인쿼리에서 읽혀진 데이터에 대해 서브쿼리에서 해당조건이 만족하는지를 확인하는 방식으로 수행되지 않는다.

  

  
### 인라인뷰
> 서브쿼리의 결과가 마치 실행시에 동적으로 생성된 테이블 인것 처럼 사용할 수 있따. 인라인 뷰는 SQL이 실행될 때만 임시적으로 생성되는 **동적뷰**이기 때문에 **데이터베이스에 해당정보가 저장되지는 않는다.** 서브 쿼리의 결과가 마치 실행시에 동적으로 생성된 테이블인 것 처럼.



## 뷰

- 독립성: 테이블 구조가 변경되어도 뷰를 사용하는 응용프로그램을 변경하지 않아도 된다.
- 편리성: 복잡한 질의를 뷰로 생성함으로써 관련 질의를 단순하게 작성 가능
- 보안성: 뷰를 생성할 떄 해당 칼럼을 뺴고 생성함으로써 사용자에게 정보를 감출 수 있다. 
- 실제 데이터를 저장하고 있는 뷰를 생성하는 기능을 지원하는 DBMS도 있따.
- 뷰는 단지 정의만을 가지고 있으며, 실행시점에 질의를 재 작성하여 수행한다.



## GROUP FUNCTION



### ROLLUP

GROUP BY 칼럼에 대해 소계를 만들어 준다. 

#### 특징

- ROLLUP할 떄 GROUPBY 구에 컬럼이 2개 이상오면 순서에 따라서 결과가 달라진다.

```sql
GROUP BY ROLLUP(DEPTNO);
--> ROLLUP을 하면 부서별 합계 + 전체 합계
```

ROLLUP

### GROUPING  함수

> 소계, 합계등이 계산되면 GROUPING 함수는 1을 반환, 그렇지 않으면 0을 반환
>
> 예) GROUPING(컬럼) --> 
>
> | GROUPING(DEPTHNO) --> DEPTHNO 기준인 소계/전체합계가 계산되었느냐 아니냐 |
> | ------------------------------------------------------------ |
> | 1                                                            |
>
> 이런식이 됨



- ROLLUP

```sql
SELECT DEPTHNO,
	DECODE(GROUPING(DEPTNO), 1, "전체합계") TOT,
	DECODE(GROUPING(JOB), 1, "부서합계") T_DEPT,
	SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);
```



- **GROUPING SETS** -- `ROLLUP`과 비슷하지만 다름

  -  GROUP BY에 나오는 칼럼의 순서와 관계없이 다양한 소계를 만들 수 있따.

  - 칼럼의 순서와 관계없이 개별적으로 모두 처리

  - 다양한 소계 집합을 만들 수 있다. GROUPING SETS에 표시된 인수들에 대한 개별 집계를 구할 수 있으며, 이때 표신된 인수들간에는 계층 구조인 ROLLUP과는 달리 평등한 관계이므로 인수의 순서가 바뀌어도 결과는 같다.

    - GROUPING SETS 함수도 결과에 대한 정렬이 필요한 경우는 ORDER BY 절에 명시적으로 정렬칼럼이 표시되어야 한다.

    

  ```sql
  SELECT DEPTNO, JOB, SUM(SAL)
  FROM EMP
  GROUP BY GROUPING SETS(DEPTNO, SAL);
  ```

  

- CUBE

  - 제시한 칼럼에 대해 결합가능한 모든 집계를 계산

  - 다차원 집계를 제공, 다양한게 데이터를 분석가능

  - 예를 들어, 부서와 직업을 CUBE로 사용하면 부서별합계/직업별합계/부서별 직업별 합계/전체합계가 조회된다

    **조합할 수 있는 모든 경우의 수가 조합**

```sql
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY CUBE(DEPTHNO, JOB);
```



 

## 윈도우 함수

- 행과 행간의 관계를 정의하기 위해서 제공되는 함수
- 순위, 합계, 평균, 행 위치를 조작할 수 있다.



| 구조            | 설명                                                         |
| --------------- | ------------------------------------------------------------ |
| ARGUMENTS(인수) | 윈도우 함수에 따라서 0-N개 인수를 설정                       |
| PARTITION BY    | 전체집합을 기준에 의해 소그룹으로 나눈다                     |
| ORDER BY        | 정렬                                                         |
| WINDOWING       | 행 기준의 범위를 정한다.<br />ROWS는 물리적 결과의  행수고 RANGE는 논리적 값에 의한 범위이다 |

ARGUMENTS, PARTITION BY, WINDOWING

### 순위함수

| 순위함수   | 설명                                                        |
| ---------- | ----------------------------------------------------------- |
| RANK       | 특정함수 및 파티션에 대해 순위 계산<br />동일순위 동일한 삾 |
| DENSE_RANK | 동일한 순위를 하나의 건수                                   |
| ROW_NUMBER | 동일한 순위에 대해서 고유의 순위 부여                       |



```sql
RANK() OVER (ORDER BY SAL) ALL_RANK<컬럼이름>;
```



```sql
DENSE_RANK() OVER (ORDER BY SAL DESC) <컬럼이름>;
```

동일한 순위 하나의 건수 -> 2등 2명이어도 3등 있음.

```sql
ROW_NUMBER() OVER (ORDER BY SAL DESC) <컬럼이름>;
```

동일한 순위에 대해서 -> 고유의 순위를 부여

RANK, DENSE_RANK, ROW_NUMBER

### 집계함수

| 집계함수 | 설명 |
| -------- | ---- |
| SUM      |      |
| AVG      |      |
| COUNT    |      |
| MAX/MIN  |      |

```sql
SUM(SAL) OVER (PARTITION BY MGR) SUM MGR
```

같은 관리자에 파티션을 만들고 합계를 계산



### 행순서 관련 윈도우 함수

FRIST_VALUE : 파티션 에서 가장 처음에 나오는 값 == MIN

LAST_VALUE: 가장 나중에 나오는 값, MAX 함수

FIRST_VALUE (<컬럼>) OVER (PARTITION BY <컬럼> ORDER BY ~) ;



## 테이블 파티션

### 파티션의 기능

- 대용량의 테이블을 여러개의 데이터 파일에 분리해서 저장
- 데이터가 물리적으로 분리된 데이터 파일에 저장되면 입력, 수정, 삭제, 조회 `성능이 향상`된다.
- 파티션은 각각 파티션별로 독립적 관리 가능
- `파티션별 백업, 복구, 인덱스 생성 가능`
- 오라클에서는 **테이블 스페이스**간 이동도 가능
  - 데이터 조회시 범위를 줄여서 성능 향상



### 종류

- RANGE 파티션: 데이터 칼럼 중 값의 `범위`를 기준으로 여러개의 파티션으로 데이터를 나누어 저장
- LIST 파티션; 특정 `값`을 기준으로 분할
- Hash 파티션: 시스템이 내부적으로 `해시함수`를 사용해서 데이터를 분할



### 파티션 인덱스

- global 인덱스: 여러개의 파티션에서 하나의 인덱스 사용
- 로컬 인덱스: 해당 파티션 별로 각자의 인덱스 사용
- prefixed index: 파티션 키와 인덱스 키가 동일
- Non prefixed index : 파티션 키와 인덱스 키가 다름



## SQL 쿼리

### 생성

```sql
CREATE TABEL <테이블이름> (
	empno number(10) PRIMARY KEY,
	ename varchar(20),
	sal NUMBER(6)
);
```



### 제약 조건

```sql
CREATE TABLE EMP (
	empno number(10),
	ename varchar2(20),
	createdate date default sysdate,
	constraint emppk<기본키 이름> primary key (EMPNO)
    CONSTRAINT deptpk<외래키 이름> FOREIGN KEY(deptno)
    references dept(deptno) -- DEPTH테이블의 DEPT
    ON DELETE CASCADE
)
```

CONSTRAINT REFERENCES

FK - CONSTRAINT <외래키이름> FOREIGN KEY(테이블이름)

REFERENCES <외래테이블이름>(외래컬럼)

ON DELETE SET NULL



### 테이블명 변경

ALTER TABLE EMP RENAME TO NEW_EMP;



### 칼럼 추가

ALTER TABLE EMP ADD( age number(2) default 1);



### 칼럼 변경

ALTER TABLE EMP MODIFY ( ename varchar2(40) not null);



### 칼럼 삭제

ALTER TABLE EMP DROP COLUMN age;



### 칼럼명 변경

`ALTER TABLE` EMP `RENAME COLUMN` age `TO` new_age;



### 테이블 삭제

- DROP TABLE EMP;
  - DROP TABLE EMP `CASCADE` `CONSTRAINT` : CASCADE CONSTRAINT 참조된 제약사항도 모두 삭제

cascade constraint

### VIEW 생성

`CREATE VIEW` VIEW_T `AS `(SELECT * FROM EMP);

as

### 뷰 삭제

DROP VIEW T_EMP;



### Insert

INSERT INTO EMP(EMPNO, ENAME) VALUES (1000, '임베스트');



### UPDATE

UPDATE EMP SET ENAME = '조조'

WHERE EMPNO = 100;



### DELETE

`DELETE FROM` EMP WHERE EMPNO = 100;

from 

### GRANT, REVOKE 

GRANT/REVOKE (SELECT, INSERT ...) ON EMP TO/FROM USER;



### 인덱스 생성

```sql
CREATE INDEX INDEX_MGR ON EMP(mgr)
```

CREATE INDEX index_mgr ON EMP(mgr)