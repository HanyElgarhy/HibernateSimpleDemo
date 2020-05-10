insert into course (id,name,created_date,updated_date) values (100,'Spring',sysdate,sysdate)
insert into course (id,name,created_date,updated_date) values (101,'Java',sysdate,sysdate)
insert into course (id,name,created_date,updated_date) values (102,'C++',sysdate,sysdate)

insert into passport (id,number) values(2000,'E2020')
insert into passport (id,number) values(2001,'E2021')
insert into passport (id,number) values(2002,'E2022')

insert into student (id,name,passport_id) values(1000,'Hany',2000)
insert into student (id,name,passport_id) values(1001,'John',2001)
insert into student (id,name,passport_id) values(1002,'Jennifer',2002)

insert into review (id,rating,description,course_id) values(3000,'1','Amazing',100)
insert into review (id,rating,description,course_id) values(3001,'2','Poor course',101)
insert into review (id,rating,description,course_id) values(3002,'3','not bad',102)

insert into student_course (student_id,course_id) values (1000,102)
insert into student_course (student_id,course_id) values (1000,101)
insert into student_course (student_id,course_id) values (1000,100)
insert into student_course (student_id,course_id) values (1002,102)