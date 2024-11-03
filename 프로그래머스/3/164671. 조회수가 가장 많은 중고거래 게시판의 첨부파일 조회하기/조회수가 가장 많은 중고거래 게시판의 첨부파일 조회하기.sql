/*
- given: 
    - USED_GOODS_BOARD(중고거래 게시판 정보)
    - USED_GOODS_FILE(중고거래 게시판 첨부파일 정보)
- return: 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
    - 첨부파일 경로는 FILE ID를 기준으로 내림차순 정렬
    - 기본적인 파일경로는 /home/grep/src/
    - 게시글 ID를 기준으로 디렉토리가 구분
    - 파일이름은 파일 ID, 파일 이름, 파일 확장자로 구성되도록 출력
    - FILE_PATH: /home/grep/src/{BOARD_ID}/{FILE_ID}+{FILE_NAME}+{FILE_EXT}
*/
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD B, USED_GOODS_FILE F
WHERE B.BOARD_ID = F.BOARD_ID AND B.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC;