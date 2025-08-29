-- 코드를 입력하세요
SELECT
    b.title, b.board_id, r.reply_id, r.WRITER_ID, r.contents,
    date_format(r.CREATED_DATE, '%Y-%m-%d') as created_date
from
    USED_GOODS_REPLY r, USED_GOODS_BOARD b
where
    b.board_id = r.board_id
    and b.created_date >= '2022-10-01'
    and b.created_date < '2022-11-01'
order by
    r.created_date, b.title
