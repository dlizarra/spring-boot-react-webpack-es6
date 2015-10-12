-- Project
INSERT INTO "project"("id","name") VALUES (1, 'Project1');
INSERT INTO "project"("id","name") VALUES (2, 'Project2');
-- User
INSERT INTO "users"("id","username") VALUES (1, 'david');
INSERT INTO "users"("id","username") VALUES (2, 'mark');
-- Position
INSERT INTO "position"("id","name") VALUES (1, 'Creator');
INSERT INTO "position"("id","name") VALUES (2, 'Developer');

INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (1,1,1);
INSERT INTO "project2user2position"("project_id", "user_id", "position_id") VALUES (2,1,2);