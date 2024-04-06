-- ORACLE 
-- 카테고리 : String, date
-- Lv3. 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기

--1.최고 views를 가진 board_id를 찾는다
--2.이를 기준으로 조인하여 file 테이블의 정보들을 가져온다
--3. 문자열 concat() 이나 || 해주면 끝

-- #풀이1 
SELECT '/home/grep/src/' || BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT
       AS FILE_PATH
  FROM (
SELECT F.BOARD_ID,
       F.FILE_ID,
       F.FILE_NAME,
       F.FILE_EXT
  FROM USED_GOODS_FILE F
       INNER JOIN ( SELECT * 
                      FROM ( 
                            SELECT BOARD_ID,
                                   MAX(VIEWS)
                              FROM USED_GOODS_BOARD
                             GROUP BY BOARD_ID
                             ORDER BY MAX(VIEWS) DESC )
                      WHERE ROWNUM <= 1 ) B
               ON F.BOARD_ID = B.BOARD_ID 
  ORDER BY FILE_ID DESC );

-- #풀이2
SELECT '/home/grep/src/'||B.BOARD_ID||'/'||FILE_ID||FILE_NAME||FILE_EXT as FILE_PATH
 FROM USED_GOODS_BOARD B,
      USED_GOODS_FILE F
WHERE B.BOARD_ID = F.BOARD_ID
  AND B.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC;