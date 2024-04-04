-- ORACLE 
-- 카테고리 : Group by
-- Lv2. 성분으로 구분한 아이스크림 총 주문량

-- join 과 group by 사용문제

-- 1. join 이용 : 외래키로 설정된 flavor 를 이용하여 join 해준다 
-- 2. 가져오는 컬럼 : 이 때 가져오는 컬럼은 I.재료, F.주문량 으로 가져오면 된다
-- 3. group by : 재료별 주문량을 sum() 하기 위해 재료를 기준으로 group by 해준다 
-- 4. order by : 이때 주문량이 증가하는 순서대로 asc 해주면 된다

SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
  FROM FIRST_HALF F 
       INNER JOIN ICECREAM_INFO I 
               ON F.FLAVOR = I.FLAVOR
 GROUP BY I.INGREDIENT_TYPE
 ORDER BY TOTAL_ORDER ASC;