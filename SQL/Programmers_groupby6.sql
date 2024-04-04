-- ORACLE 
-- 카테고리 : Group by
-- Lv3. 즐겨찾기가 가장 많은 식당 정보 출력하기

-- 단순 group by 사용문제

-- 1. 각 food_type 별로 max(favorites)을 어떻게 구할것인가
-- -> 일단 음식종류 기준으로 group 해서 최고 즐겨찾기수를 구한다
-- 2. 1에서 찾은 즐겨찾기 수에 해당하는 컬럼들을 매칭하면 된다 

SELECT FOOD_TYPE,
       REST_ID,
       REST_NAME,
       FAVORITES
  FROM REST_INFO
 WHERE (FOOD_TYPE, FAVORITES) IN
       (SELECT FOOD_TYPE, 
               MAX(FAVORITES)
          FROM REST_INFO
         GROUP BY 
               FOOD_TYPE)
 ORDER BY FOOD_TYPE DESC;
