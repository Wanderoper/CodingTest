-- MYSQL 
-- Lv2.조건에 맞는 아이템들의 가격의 총합 구하기

-- 함수만 사용하는 쉬운문제 

SELECT SUM(PRICE) TOTAL_PRICE
  FROM ITEM_INFO
 WHERE RARITY = 'LEGEND';