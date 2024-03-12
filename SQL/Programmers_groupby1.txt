-- ORACLE 
-- Lv3.조건에 맞는 사용자와 총 거래금액 조회하기

-- FROM 절 subquery 인라인 뷰를 활용하는 문제

-- 먼저 board에서 원하는 쿼리를 작성하여 결과문을 만든 후 (차근차근하기)
-- from 절 서브쿼리로 조인을 하여 (기본키 id) order 만 해주면 된다 

SELECT U.USER_ID, U.NICKNAME, B.TOTAL_SALES
  FROM USED_GOODS_USER U
       INNER JOIN 
       (SELECT WRITER_ID, SUM(PRICE) TOTAL_SALES
          FROM USED_GOODS_BOARD
         WHERE STATUS = 'DONE'
         GROUP BY 
               WRITER_ID
        HAVING SUM(PRICE) >= 700000) B
            ON U.USER_ID = B.WRITER_ID
 ORDER BY 
       B.TOTAL_SALES ASC;
 