# MySQL 
# 카테고리 : JOIN 
# Lv4. 5월 식품들의 총매출 조회하기

#문제조건이용하기
#1. Order와 Product의 join 조건인 product_id 를 이용한다

#접근방법
#1. 조인한 뒤, 총 매출 (= 가격 * 판매량) 을 구하면 된다 
#2. 주의할 점은 창고 위치에 따라 중복된 상품종류가 있으므로 group by 절을 이용해야한다

SELECT P.PRODUCT_ID, 
       P.PRODUCT_NAME,
       SUM(O.AMOUNT * P.PRICE) AS TOTAL_SALES
  FROM FOOD_PRODUCT P
       INNER JOIN FOOD_ORDER O
               ON P.PRODUCT_ID = O.PRODUCT_ID
 WHERE EXTRACT(YEAR FROM O.PRODUCE_DATE) = 2022
   AND EXTRACT(MONTH FROM O.PRODUCE_DATE) = 5
 GROUP BY
       P.PRODUCT_ID,
       P.PRODUCT_NAME
 ORDER BY  
       TOTAL_SALES DESC,
       PRODUCT_ID ASC;