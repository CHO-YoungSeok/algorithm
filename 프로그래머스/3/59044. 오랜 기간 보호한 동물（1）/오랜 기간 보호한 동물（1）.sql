-- 코드를 입력하세요
SELECT
    i.name, i.datetime
from
    animal_ins i
where
    not exists (
        select 1
        from animal_outs o
        where i.animal_id = o.animal_id
    )
order by
    i.datetime
limit 3