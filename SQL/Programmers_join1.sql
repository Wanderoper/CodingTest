-- ORACLE 
-- 카테고리 : JOIN 
-- Lv4. 주문량이 많은 아이스크림들 조회하기

--문제조건이용하기
--1. july 테이블의 flavor는 first_half 테이블의 flavor를 참조하는 FK 관계에 있다. 이를 이용하여 조인하면 된다

--문제점
--1. july 테이블의 일부 flavor의 경우 출하지점이 다르므로 다른 shipment_id 가 부여되어있다. 이를 처리하지 않고 조인하게 되면 --first_half에 해당하는 sum(total_order)가 두번 이상 적용되므로 적절하지 않은 결과를 나타낼 수 있다. 

--접근방법
--1. 먼저 july 테이블을 flavor 별로 group 하여 sum을 해준 뒤, 해당 결과 set 을 이용하여 first_half에 조인한다

SELECT FLAVOR FROM (
SELECT F.FLAVOR AS FLAVOR,
       (F.TOTAL_ORDER + J.TOTAL_ORDER) AS TOTAL_ORDER
  FROM FIRST_HALF F
       LEFT OUTER JOIN 
                 (SELECT FLAVOR,
                         SUM(TOTAL_ORDER) AS TOTAL_ORDER
                    FROM JULY
                   GROUP BY FLAVOR) J
               ON F.FLAVOR = J.FLAVOR
 ORDER BY TOTAL_ORDER DESC)
 WHERE ROWNUM <=3;