-- ORACLE 

-- Lv2. 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

-- 메인쿼리 : group by를 통해 해당 기간의 월별 자동차ID 별 대여 횟수 출력
-- 서브쿼리 : 8,9,10월 총 (count *) 대여횟수 5회 이상인 CAR_ID 찾기

-- 해설 참고 : https://kangwlgns.tistory.com/134

SELECT EXTRACT(MONTH FROM START_DATE) MONTH,
       CAR_ID,
       COUNT(*) RECORDS
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
 WHERE CAR_ID IN (
       SELECT CAR_ID
         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE EXTRACT(MONTH FROM START_DATE) IN (8,9,10)
        GROUP BY CAR_ID 
       HAVING COUNT(*) > 4)
   AND EXTRACT(YEAR FROM START_DATE) = 2022 
   AND 8 <= EXTRACT(MONTH FROM START_DATE) AND EXTRACT(MONTH FROM START_DATE) < 11
 GROUP BY 
       EXTRACT(MONTH FROM START_DATE), CAR_ID
HAVING COUNT(*) <> 0
 ORDER BY
       MONTH ASC, CAR_ID DESC;

-- 배운 것 : 
-- GROUP BY 를 한 상태에서의 count(*)의 의미 
-- extract(날짜 from 컬럼) 함수
-- 가독성 있는 조건 설정법 ex) 1 <= 컬럼 and 컬럼 < 10 