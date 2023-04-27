/* 
[설명]
- 가게 상반기 주문 정보 : FIRST_HALF 
    -> SHIPMENT_ID(공장~가게 출하번호), FLAVOR(맛), TOTAL_ORDER(총주문량)
- 아이스크림 성분 정보 : ICECREAM_INFO 
    ->  FLAVOR(맛)[PK][FK], INGREDITENT_TYPE(성분타입-sugar_based,fruit_based)
- 총주문량 > 3000 and 주성분=과일 -> 총주문량 큰 순서대로 조회
[접근]
- 조인, select
*/
SELECT F.FLAVOR
FROM FIRST_HALF F, ICECREAM_INFO I
WHERE F.FLAVOR = I.FLAVOR AND F.TOTAL_ORDER > 3000 AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;