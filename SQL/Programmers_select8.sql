-- ORACLE

SELECT ROUND(
       SUM(DAILY_FEE) / COUNT(CAR_TYPE)
       ,0) AVERAGE_FEE
  FROM CAR_RENTAL_COMPANY_CAR
 WHERE CAR_TYPE = 'SUV';

-- ROUND 함수 (값, 소수점 표시값)
-- SUM 함수 ( 더할 컬럼 ) -- 주의 : 다른 컬럼과 사용시 group by 사용해야함
-- COUNT 함수 ( 갯수 셀 컬럼 ) -- distinct와 함께 COUNT(DISCOUNT(컬럼)) 과 같이 사용 가능 