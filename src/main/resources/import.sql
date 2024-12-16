INSERT INTO company(id, address, name) VALUES (1, 'hauptstrasse 14', 'Jobsy');
INSERT INTO company(id, address, name) VALUES (2, 'kreuzberg 14', 'Meta');
INSERT INTO company(id, address, name) VALUES (3, 'OstKreuz 200', 'Google');


INSERT INTO job(id, city, description, title , type, company_id) VALUES (1, 'berlin', 'job description', 'Software engineer', 'FULL_TIME', 1);
INSERT INTO job(id, city, description, title , type, company_id) VALUES (2, 'berlin', 'job description', 'frontend engineer', 'FULL_TIME', 1);
INSERT INTO job(id, city, description, title , type, company_id) VALUES (3, 'berlin', 'job description', 'part time engineer', 'PART_TIME', 1);
INSERT INTO job(id, city, description, title , company_id) VALUES (4, 'berlin', 'job description', 'part time engineer', 2);
