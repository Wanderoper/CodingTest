-- ORACLE 

-- 풀이방법 1 : WHERE 절 (중첩서브쿼리 사용)
-- 문제에서 1건만 찾으라고 하지 않았으므로 틀리지 않음 N건일 경우 조금 더 생각 필요 (rownum 사용)

SELECT PRODUCT_ID,
       PRODUCT_NAME,
       PRODUCT_CD,
       CATEGORY,
       PRICE
  FROM FOOD_PRODUCT
 WHERE PRICE = ( SELECT MAX(PRICE)
                  FROM FOOD_PRODUCT );

-- 풀이방법 2 : FROM 절 (인라인 뷰 사용)

SELECT PRODUCT_ID,
       PRODUCT_NAME,
       PRODUCT_CD,
       CATEGORY,
       PRICE
  FROM (SELECT *
          FROM FOOD_PRODUCT
         ORDER BY 
               PRICE DESC)
 WHERE ROWNUM = 1;