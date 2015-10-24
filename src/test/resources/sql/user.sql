-- project
INSERT INTO "project"("id","name") VALUES (1, 'Project1');
INSERT INTO "project"("id","name") VALUES (2, 'Project2');
-- users
INSERT INTO "users"("id","username", "password", "enabled") VALUES (1, 'david', 'david', 1);
INSERT INTO "users"("id","username", "password", "enabled") VALUES (2, 'mark', 'mark', 1);
-- Role
INSERT INTO "role"("id", "rolename", "user_id") VALUES (1, 'ROLE_ADMIN', 1);
INSERT INTO "role"("id", "rolename", "user_id") VALUES (2, 'ROLE_USER', 1);
INSERT INTO "role"("id", "rolename", "user_id") VALUES (3, 'ROLE_USER', 2);

-- project2User2Position
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (1,1,1);
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (2,1,2);
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (2,2,2);