-- ORACLE 
-- Lv2. 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기

-- 관건은 도메인에 여러 값이 있을 때 어떻게 처리할지 이다
-- 방법 1. like , or 사용하여 노가다
-- 방법 2. regexp_like 이용

SELECT CAR_TYPE,
       COUNT(*) CARS
  FROM CAR_RENTAL_COMPANY_CAR
 -- WHERE (OPTIONS LIKE '%통풍시트%' OR
 --        OPTIONS LIKE '%열선시트%' OR
 --        OPTIONS LIKE '%가죽시트%')
 WHERE REGEXP_LIKE(OPTIONS, '통풍시트|열선시트|가죽시트')
 GROUP BY
       CAR_TYPE
 ORDER BY
       CAR_TYPE ASC;