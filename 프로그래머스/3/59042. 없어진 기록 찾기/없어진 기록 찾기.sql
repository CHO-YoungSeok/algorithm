-- 코드를 입력하세요
SELECT
    o.animal_id as animal_id,
    o.name as name
from
    animal_outs o
where
    not exists (
        select 1
        from animal_ins i
        where o.animal_id = i.animal_id
    )
order by
    animal_id, name