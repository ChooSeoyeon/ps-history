/*
- return: 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회
    - 전화번호가 NULL인 경우는 출력대상에서 제외
    - 회원ID를 기준으로 오름차순 정렬
*/
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE TLNO IS NOT NULL AND DATE_OF_BIRTH LIKE '%-03-%' AND GENDER='W'
ORDER BY MEMBER_ID ASC;