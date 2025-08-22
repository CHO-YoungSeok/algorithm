-- 코드를 입력하세요
SELECT
    i.ANIMAL_ID, i.animal_type, i.NAME
from 
    animal_ins i
    inner join animal_outs o
        on i.ANIMAL_ID = o.ANIMAL_ID
    where
        not i.SEX_UPON_INTAKE = o.SEX_UPON_OUTCOME