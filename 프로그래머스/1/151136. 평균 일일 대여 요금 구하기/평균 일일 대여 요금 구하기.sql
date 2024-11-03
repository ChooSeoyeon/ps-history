# given: 
# return: CAR_RENTAL_COMPANY_CAR 테이블에서 CAR_TYPE이 'SUV'인 자동차들의 평균 일일 대여 요금
#   - 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림 (ex. 19)
#   - 컬럼명은 AVERAbE_FEE

SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';