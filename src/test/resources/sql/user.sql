-- project
INSERT INTO "project"("id","name") VALUES (1, 'Project1');
INSERT INTO "project"("id","name") VALUES (2, 'Project2');
-- users
INSERT INTO "users"("id","username") VALUES (1, 'david');
INSERT INTO "users"("id","username") VALUES (2, 'mark');
-- project2User2Position
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (1,1,1);
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (2,1,2);
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (2,2,2);