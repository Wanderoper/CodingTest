-- ORACLE

SELECT USER_ID, PRODUCT_ID
  FROM ONLINE_SALE
 GROUP BY 
       USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
 ORDER BY 
       USER_ID ASC,
       PRODUCT_ID DESC;

-- GROUP 으로 모든 컬럼을 묶는것도 가능!
-- 모두 묶은 상태에서 2 row 이상 나온 것에 대한 것이므로 count 사용