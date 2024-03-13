-- ORACLE 
-- Lv4. 저자 별 카테고리 별 매출액 집계하기

-- FROM 절 subquery - inline view 를 이용하는 문제 

-- 우선 book 과 author를 조인하고 
-- 이를 이용한 인라인 뷰와 sales 테이블을 조인한다
-- group by 로 조건대로 묶어주고 sum() 을 이용해 저자, 카테고리별로 구해주면 된다

-- [SOLUTION #1] : 임시뷰를 사용, 성능상 좋지 않음 

SELECT I.AUTHOR_ID,
       I.AUTHOR_NAME,
       I.CATEGORY,
       SUM(S.SALES * I.PRICE) TOTAL_SALES
  FROM 
(SELECT B.*,
        A.AUTHOR_NAME
   FROM BOOK B
        INNER JOIN AUTHOR A
                ON B.AUTHOR_ID = A.AUTHOR_ID) I -- I stands for INFO
        INNER JOIN BOOK_SALES S                 -- S stands for SALES
                ON I.BOOK_ID = S.BOOK_ID
 WHERE TO_CHAR(S.SALES_DATE, 'YYYY-MM') LIKE '2022-01%'
 GROUP BY 
       I.AUTHOR_ID, 
       I.AUTHOR_NAME,
       I.CATEGORY
 ORDER BY 
       I.AUTHOR_ID ASC, 
       I.CATEGORY DESC;

-- [SOLUTION #2] : #1과 동일하지만 성능상 임시뷰보다 낫다 (가독성도) 

-- 코드를 입력하세요
WITH INLINE AS (
 SELECT B.*,
        A.AUTHOR_NAME
   FROM BOOK B
        INNER JOIN AUTHOR A
                ON B.AUTHOR_ID = A.AUTHOR_ID
)

SELECT I.AUTHOR_ID,
       I.AUTHOR_NAME,
       I.CATEGORY,
       SUM(S.SALES * I.PRICE) TOTAL_SALES
  FROM INLINE I -- I stands for INFO
        INNER JOIN BOOK_SALES S                 -- S stands for SALES
                ON I.BOOK_ID = S.BOOK_ID
 WHERE TO_CHAR(S.SALES_DATE, 'YYYY-MM') LIKE '2022-01%'
 GROUP BY 
       I.AUTHOR_ID, 
       I.AUTHOR_NAME,
       I.CATEGORY
 ORDER BY 
       I.AUTHOR_ID ASC, 
       I.CATEGORY DESC;