-- 코드를 작성해주세요

SELECT e1.ID, e1.GENOTYPE, e2.GENOTYPE as PARENT_GENOTYPE
FROM
    ECOLI_DATA e1
    join ECOLI_DATA e2 on (
        e1.PARENT_ID = e2.ID
    )
WHERE (
    e1.genotype & e2.genotype >= e2.genotype
)
ORDER BY e1.ID;