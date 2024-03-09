-- ORACLE

SELECT G.TITLE,
       G.BOARD_ID,
       R.REPLY_ID,
       R.WRITER_ID,
       R.CONTENTS,
       TO_CHAR(R.CREATED_DATE, 'YYYY-MM-DD') CREATED_DATE
  FROM USED_GOODS_BOARD G
       INNER JOIN USED_GOODS_REPLY R
               ON G.BOARD_ID = R.BOARD_ID
 WHERE TO_CHAR(G.CREATED_DATE, 'YYYY-MM') = '2022-10'
 ORDER BY 
       R.CREATED_DATE,
       G.TITLE;
       

-- 게시글의 날짜와 댓글의 날짜 혼동 주의
-- where 절 조건줄 때도 to_char 함수를 이용하여 비교