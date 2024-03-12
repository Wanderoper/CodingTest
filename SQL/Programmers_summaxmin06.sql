-- ORACLE 
-- Lv2.중복 제거하기

-- 간단하게 distinct 후 count 하는 쉬운 문제 

SELECT COUNT(DISTINCT(NAME)) COUNT
  FROM ANIMAL_INS
 WHERE NAME IS NOT NULL;