select
    c.car_id,
    c.car_type,
    TRUNCATE(((100 - p.discount_rate) / 100.0) * c.daily_fee * 30, 0) AS fee
from
    CAR_RENTAL_COMPANY_CAR c
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        on c.car_id = h.car_id
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
        on p.car_type = c.car_type
where
    c.car_type  in ('세단', 'suv')
    and p.duration_type = '30일 이상'
    and (((100 - p.discount_rate) / 100.0) * c.daily_fee * 30) < 2000000
    and 500000 <= (((100 - p.discount_rate) / 100.0) * c.daily_fee * 30)
    and not exists (
        select 1
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        where
            c.car_id = h.car_id
            and h.end_date >= '2022-11-01'
            and h.start_date <= '2022-11-30'
    )
group by c.car_id
ORDER BY fee DESC, c.car_type ASC, c.car_id DESC;