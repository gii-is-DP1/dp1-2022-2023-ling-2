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
