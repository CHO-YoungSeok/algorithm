-- 코드를 입력하세요
SELECT
    p.product_code,
    sum(p.price * off.SALES_AMOUNT) as SALES
from
    PRODUCT p 
    inner join OFFLINE_SALE off
        on p.PRODUCT_ID = off.PRODUCT_ID
group by
    product_code
order by
    SALES desc,
    p.product_code asc;
    
    