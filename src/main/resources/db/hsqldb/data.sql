-- All card models
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (0,1,2,2,2); -- Start card
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (0,1,0,1,1); -- Card 0
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (1,1,0,2,2); -- Card 1
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (2,2,0,1,2); -- Card 2 left
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (2,2,0,2,1); -- Card 2 right
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (3,1,0,1,2); -- Card 3 left
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (3,1,0,2,1); -- Card 3 right
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (4,2,0,1,1); -- Card 4
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (5,1,0,1,1); -- Card 5

INSERT INTO users(username,password,email,is_admin,enabled) VALUES ('admin','admin','admin@localhost.com',true,true);
INSERT INTO users(username,password,email,is_admin,enabled) VALUES ('user','user','user@localhost.com',false,true);

INSERT INTO achievements(id,name,description,condition,condition_amount) VALUES (1,'Winner','Win one Game', 1, 1);
INSERT INTO achievements(id,name,description,condition,condition_amount) VALUES (2,'TEST admin 2','Win one Game', 3, 50);
INSERT INTO achievements(id,name,description,condition,condition_amount) VALUES (3,'TEST user 3','Win one Game', 1, 1);

INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,2);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (2,2);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (3,2);
