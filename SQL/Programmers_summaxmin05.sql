-- ORACLE 
-- Lv2. 동물 수 구하기 

SELECT COUNT(DISTINCT(ANIMAL_ID))
  FROM ANIMAL_INS;

-- animal_id는 기본키이지만 조건에 제시되지 않아 혹시 모를 경우 대비 distinct 적용 후 count 했음