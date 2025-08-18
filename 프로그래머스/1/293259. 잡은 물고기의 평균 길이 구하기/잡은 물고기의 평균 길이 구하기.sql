-- 코드를 작성해주세요
select
    round((f1.zero * 10 + f2.gSum) / (f1.zero + f2.gCount), 2) as average_length
from (
    select
        count(*) as zero
    from 
        fish_info
    where length is null
) f1, (
    select  
        sum(length) as gSum,
        count(*) as gCount
    from
        fish_info
    where
        length is not null
) f2
