-- 코드를 입력하세요
SELECT
    f.flavor
from
    first_half f
    join (
        select flavor, sum(total_order) as j_total_order
        from july
        group by flavor
    ) j
    on f.flavor = j.flavor
order by
    (f.total_order + j_total_order) desc
limit 3
