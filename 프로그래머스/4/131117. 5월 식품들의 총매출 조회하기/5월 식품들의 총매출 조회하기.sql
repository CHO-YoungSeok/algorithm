-- 코드를 입력하세요
SELECT
    p.product_id, p.product_name, sum(p.price * o.amount) as total_price
from
    food_product p
inner join food_order o
    on p.product_id = o.product_id
where
    o.PRODUCE_DATE >= '2022-05-01' 
    and o.PRODUCE_DATE < '2022-06-01'
group by
    p.product_id
order by
    total_price desc,
    p.product_id asc 