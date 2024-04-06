-- 카테고리 : SELECT
-- Lv1. 12세 이하인 여자 환자 목록 출력하기

-- ORACLE

SELECT PT_NAME, PT_NO, GEND_CD, AGE, 
       CASE 
           WHEN TLNO IS NULL THEN 'NONE'
           ELSE TLNO
       END AS TLNO
  FROM PATIENT
 WHERE AGE <= 12 
   AND GEND_CD = 'W'
 ORDER BY 
       AGE DESC, PT_NAME;


-- CASE 문 사용으로 null 처리
-- 나이, 성별 조건 적용

-- MYSQL

SELECT PT_NAME,
       PT_NO,
       GEND_CD,
       AGE,
      (CASE
        WHEN TLNO IS NULL THEN 'NONE'
        ELSE TLNO
       END) AS TLNO
  FROM PATIENT
 WHERE AGE <= 12 
   AND GEND_CD = 'W'
 ORDER BY
       AGE DESC,
       PT_NAME ASC;