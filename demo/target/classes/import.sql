insert into Submission (id, task_id, user_id, solve, subdate) values (1, 2, 1,'solve1','2017/11/20 10:30:01');
insert into Submission (id, task_id, user_id, solve, subdate) values (2, 2, 1,'solve2','2017/12/25 13:39:11');

insert into Task (id, task_name, description) values (1, 'task1', 'this is the description for the first task');
insert into Task (id, task_name, description) values (2, 'task2', 'this is the description for the second task');
insert into Task (id, task_name, description) values (3, 'task3', 'this is the description for the third task');


insert into User (id, user_name, pass_word, enabled, role) values (1, 'Rami', 'abcdef4', 1, 'ROLE_ADMIN');
insert into User (id, user_name, pass_word, enabled, role) values (2, 'Kinan', 'abcdef3', 1, 'ROLE_ADMIN');