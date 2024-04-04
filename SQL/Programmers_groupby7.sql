-- ORACLE 
-- 카테고리 : Group by
-- Lv3. 카테고리 별 도서 판매량 집계하기

-- 단순 group by 사용문제

-- 1. join : 두 테이블을 join 한다
-- 2. where : 날짜조건에 대해 선택한다

SELECT B.CATEGORY,
       SUM(S.SALES)
  FROM BOOK B 
       INNER JOIN BOOK_SALES S 
               ON B.BOOK_ID = S.BOOK_ID
 WHERE EXTRACT(YEAR FROM S.SALES_DATE) = 2022
   AND EXTRACT(MONTH FROM S.SALES_DATE) = 1
 GROUP BY 
       B.CATEGORY
 ORDER BY 
       B.CATEGORY ASC;