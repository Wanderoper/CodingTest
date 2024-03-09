-- ORACLE
-- JOIN 중 일반 집합 연산자를 사용하는 문제 (Union, union all 차이점 과 order by 문법 숙지)

(SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-DD') SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
   FROM ONLINE_SALE
  WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03')
  UNION ALL
(SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-DD') SALES_DATE,
        PRODUCT_ID,
        NULLIF(PRODUCT_ID, PRODUCT_ID) USER_ID,
        SALES_AMOUNT
   FROM OFFLINE_SALE
  WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03')

  ORDER BY
        SALES_DATE ASC,
        PRODUCT_ID ASC,
        USER_ID ASC

-- union 등 일반 집합 연산자 사용 시는 order by 가 맨 뒤에 와야한다
-- 컬럼값을 null로 표현하려면 컬럼을 null 로 표현해도 됨 (나는 nullif 로 처리함)