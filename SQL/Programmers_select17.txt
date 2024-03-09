-- ORACLE 

-- 풀이방법 1 : 
-- 문제에서 1건만 찾으라고 하지 않았으므로 틀리지 않음

SELECT PRODUCT_ID,
       PRODUCT_NAME,
       PRODUCT_CD,
       CATEGORY,
       PRICE
  FROM FOOD_PRODUCT
 WHERE PRICE = (
                SELECT MAX(PRICE)
                  FROM FOOD_PRODUCT
                  );

-- 풀이방법 2 : 