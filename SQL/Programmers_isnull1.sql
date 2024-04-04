-- ORACLE 
-- 카테고리 : IS NULL (NULL을 처리하는 방법을 배워보기)
-- Lv1. 경기도에 위치한 식품창고 목록 출력하기

-- 1. CASE문 : 컬럼 값에 따라 값을 조절해준다 
-- 2. LIKE절 : 일부 조건에 대해 일치하는 결과 찾기

SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       CASE 
        WHEN FREEZER_YN IS NULL THEN 'N'
        ELSE FREEZER_YN
       END AS FREEZER_YN
  FROM FOOD_WAREHOUSE
 WHERE ADDRESS LIKE '%경기도%'
 ORDER BY
       WAREHOUSE_ID ASC;