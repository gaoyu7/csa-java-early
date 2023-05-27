use csa;
-- 1.
create table cqupt_student
(
    studentid varchar(10),
    name      varchar(20),
    sex       varchar(2),
    age       int,
    Fee       decimal(10, 2),
    address   varchar(50),
    memo      varchar(300)
);
-- 5.
create table choosebb
(
    Bb1 varchar(30)                      null,
    Bb2 int                              null,
    Bb3 decimal(6)                       null,
    Bb4 varchar(20) default '系统测试值' not null,
    Bb5 varchar(10)                      not null
        primary key
);

alter table choosebb
    add Bb5 varchar(10) primary key;

-- 8.
-- 对 Bb2 属性建立升序索引 Index_bb2
CREATE INDEX Index_bb2 ON ChooseBb (Bb2 ASC);

-- 对 Bb4 属性建立降序索引 Index_bb4
CREATE INDEX Index_bb4 ON ChooseBb (Bb4 DESC);

-- 15.
drop table test;
create table test
(
    Name    varchar(20)    null,
    Age     int            null,
    Score   decimal(10, 2) null,
    Address varchar(60)    null
);

insert into test(name, age, score, address)
VALUES ('赵一', 20, 580.00, '重邮宿舍12-3-5'),
       ('钱二', 19, 540.00, '南福苑5-2-9'),
       ('孙三', 21, 555.50, '学生新区21-5-15'),
       ('李四', 22, 505.00, '重邮宿舍8-6-22'),
       ('周五', 20, 495.50, '学生新区23-4-8'),
       ('吴六', 19, 435.00, '南福苑2-5-12');

update test
set Age = Age + 5
where Age <= 20;

-- 18.
delete
from test
where Score < 550
  and Address like '%重邮宿舍%';

select *
from test;

-- 28. 32. 34.
drop table choose;
create table choose
(
    SNO      varchar(20),
    CourseID varchar(30),
    Score    decimal(5, 2)
);
insert into choose
values ('S00001', 'C1', 95),
       ('S00001', 'C2', 80),
       ('S00001', 'C3', 84),
       ('S00002', 'C1', 80),
       ('S00002', 'C2', 85),
       ('S00003', 'C1', 78),
       ('S00003', 'C3', 70);
-- 28.
SELECT MAX(Score), MIN(Score), SUM(Score), AVG(Score)
FROM choose;

create table course
(
    CourseID       varchar(15),
    CourseName     varchar(30),
    CourseBeforeID varchar(15)
);

insert into course
values ('C1', '计算机引论', null),
       ('C2', 'C语言', 'C1'),
       ('C3', '数据结构', 'C2');

create table student
(
    SNO     varchar(20),
    Name    varchar(10),
    Age     integer,
    College varchar(30)
);
insert into student
values ('S00001', '张三', 20, '计算机学院'),
       ('S00002', '李四', 19, '通信学院'),
       ('S00003', '王五', 21, '计算机学院');

-- 32.
select SNO, Score
from choose
where CourseID = 'C1'
  and Score < (select Score from choose where CourseID = 'C1' and SNO = (select SNO from student where Name = '张三'));

-- 34.
select distinct SNO
from choose
where CourseID = 'C1'
union
select distinct SNO
from choose
where CourseID = 'C2';