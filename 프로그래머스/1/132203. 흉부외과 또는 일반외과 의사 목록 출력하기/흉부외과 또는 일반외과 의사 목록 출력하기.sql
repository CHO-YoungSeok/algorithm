-- 코드를 입력하세요
SELECT
    DR_NAME,
    DR_ID,
    MCDP_CD,
    date_format(hire_ymd, '%Y-%m-%d') as HIRE_YMD
from 
    DOCTOR 
where
    mcdp_cd = 'CS' or
    mcdp_cd = 'GS'
order by
    hire_ymd desc,
    dr_name;
    