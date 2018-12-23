CREATE SEQUENCE s_member INCREMENT BY 1 ; --회원시퀀스

CREATE TABLE nullt (
nullt number(1) 
);

insert into nullt
values('');

insert into member(M_NO,EMAIL,name,PW)
values(s_member.nextval,'y','y','y');

SELECT NVL(n.NULLT, 1) FROM nullt n;
SELECT*FROM member;
SELECT*FROM nullt;

--프로시져
CREATE OR REPLACE PROCEDURE p_join(
test_M_mem_num c_member.mem_num%type, --아이디
test_sj_day date --날짜
)
is
m_num c_member.mem_num%type;
begin
select count(*) into m_num 
from c_member m,c_sj_today today WHERE m.MEM_NUM = test_M_mem_num AND today.day = test_sj_day and m.MEM_NUM = TODAY.MEM_NUM;

if m_num = 0 THEN 
insert into c_sj_today values(seq_cally_c_sj_today.nextval,test_M_mem_num,test_sj_day,'','');
END IF;
    commit;
end;
--
call p_join(23,TO_DATE('2018-11-8','YYYY-MM-dd'))