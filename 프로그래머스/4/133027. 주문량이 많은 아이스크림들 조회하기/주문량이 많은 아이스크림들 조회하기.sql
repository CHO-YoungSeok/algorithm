-- 코드를 입력하세요
SELECT
    coalesce(f.flavor, j.flavor) as flavor
from (
    select flavor, sum(total_order) as total
    from first_half
    group by flavor
) f
full outer join (
    select flavor, sum(total_order) as total
    from july
    group by flavor
) j
on
    f.flavor = j.flavor
order by
    (coalesce(f.total, 0) + coalesce(j.total, 0)) desc
fetch first 3 rows only;

