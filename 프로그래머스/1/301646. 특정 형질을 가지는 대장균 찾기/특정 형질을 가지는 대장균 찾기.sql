-- 코드를 작성해주세요

select count(*) as COUNT
from ECOLI_DATA
where (
    GENOTYPE & 2 = 0
    and (
        genotype & 4 = 4 
        or
        genotype & 1 = 1
    )
);