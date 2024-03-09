-- ORACLE

SELECT I.REST_ID,
       I.REST_NAME,
       I.FOOD_TYPE,
       I.FAVORITES,
       I.ADDRESS,
       ROUND(
       SUM(R.REVIEW_SCORE)/COUNT(R.REVIEW_SCORE)
       ,2) SCORE
  FROM REST_INFO I
       INNER JOIN REST_REVIEW R
               ON I.REST_ID = R.REST_ID
 WHERE I.ADDRESS LIKE '서울%'
 GROUP BY
       I.REST_ID,
       I.REST_NAME,
       I.FOOD_TYPE,
       I.FAVORITES,
       I.ADDRESS
 ORDER BY
       SCORE DESC,
       FAVORITES DESC;

-- SELECT 절에서 alias 준 컬럼명은 order by 등에서 해당 컬럼명으로 바로 사용 가능

-- '서울' 포함된 결과를 찾을때는 = 이 아니라 like 을 써야함