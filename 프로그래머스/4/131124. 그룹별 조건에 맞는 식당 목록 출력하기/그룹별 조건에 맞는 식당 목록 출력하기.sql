-- 코드를 입력하세요
SELECT
    m.member_name,
    r2.review_text,
    date_format(r2.review_date, '%Y-%m-%d') as REVIEW_DATE
from (
    select member_id, count(member_id) as count
    from rest_review
    group by member_id
    order by count desc
    limit 1
) r1 
    join MEMBER_PROFILE m
    on m.member_id = r1.member_id
    join rest_review r2
    on m.member_id = r2.member_id
order by
    review_date asc,
    review_text asc

    

