-- 코드를 작성해주세요
select
    p.id, p.email, p.first_name, p.last_name
from
    developers p
where
    p.skill_code & (
        select sum(code)
        from SKILLCODES
        where CATEGORY = 'Front End'
    ) > 0
order by
    p.id
