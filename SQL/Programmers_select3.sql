-- 카테고리 : SELECT
-- Lv1. 흉부외과 또는 일반외과 의사 목록 출력하기

-- ORACLE

SELECT DR_NAME, DR_ID, MCDP_CD, TO_CHAR(HIRE_YMD, 'YYYY-mm-dd') AS HIRE_YMD
  FROM DOCTOR
 WHERE MCDP_CD = 'CS'
    OR MCDP_CD = 'GS' 
 ORDER BY 
       HIRE_YMD DESC, DR_NAME;


-- MYSQL

-- MYSQL에서는 date_format()함수이며 각 파라미터에 대해 다른 포매팅이 설정된다

SELECT DR_NAME,
       DR_ID,
       MCDP_CD,
       DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
  FROM DOCTOR
 WHERE MCDP_CD IN ('CS', 'GS')
 ORDER BY
       HIRE_YMD DESC, 
       DR_NAME ASC;