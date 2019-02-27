insert into status (id, name) values (1, 'Active');
insert into status (id, name) values (2, 'In-Active');

insert into health (id, name) values (1, 'Poor');
insert into health (id, name) values (2, 'Neutral');
insert into health (id, name) values (3, 'Good');
insert into health (id, name) values (4, 'Healthy');

insert into groups (id, name) values (1, 'Signator');
insert into groups (id, name) values (2, 'Approver');

insert into employee (id, name) values (1, 'William Birkins');
insert into employee (id, name) values (2, 'Elisabeth Shaw');
insert into employee (id, name) values (3, 'Tom Riddle');

insert into project (id, name, description, summary, is_deleted, state_id, health_id) values (100, 'First Project', 'First Desc', 'First Summary', false, 1, 1);
insert into project (id, name, description, summary, is_deleted, state_id, health_id) values (101, 'Second Project', 'Second Desc', 'Second Summary', false, 1, 1);