insert into candidate(birthdate, number, email, name)values('1995-02-23', '064/1234567', 'candidate1@test.net', 'Candidate1 Candidate');
insert into candidate(birthdate, number, email, name)values('1996-08-02', '064/1234567', 'candidate2@test.net', 'Candidate2 Candidate');
insert into candidate(birthdate, number, email, name)values('1996-04-17', '064/1234567', 'candidate3@test.net', 'Candidate3 Candidate');

insert into skill(name)values('Java programming');
insert into skill(name)values('C# programming');
insert into skill(name)values('Database Design');
insert into skill(name)values('English');
insert into skill(name)values('German');
insert into skill(name)values('Android programming');
insert into skill(name)values('Spring boot');
insert into skill(name)values('Angular');

insert into candidate_skill(candidate_id,skill_id)values(1,1);
insert into candidate_skill(candidate_id,skill_id)values(1,2);
insert into candidate_skill(candidate_id,skill_id)values(1,7);
insert into candidate_skill(candidate_id,skill_id)values(1,8);
insert into candidate_skill(candidate_id,skill_id)values(2,1);
insert into candidate_skill(candidate_id,skill_id)values(2,3);
insert into candidate_skill(candidate_id,skill_id)values(3,1);