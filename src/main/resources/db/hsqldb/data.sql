-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

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
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (6,0,0,0,0); -- Block card

-- All decks
INSERT INTO deck() VALUES ();
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,2,1);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,3,9);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,4,4);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,5,4);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,6,2);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,7,2);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,8,2);
INSERT INTO deck_card(deck_id,card_id,quantity) VALUES (1,9,1);


-- EASY DIFFICULTY (YELLOW)
-- Puzzle 1
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (1,1,2,2,0);

-- Puzzle 2
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,10,2,3,0);

-- Puzzle 3
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,10,1,3,0);

-- Puzzle 4
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (4,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (4,10,1,2,0);

-- Puzzle 5
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (5,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (5,10,1,1,0);

-- Puzzle 6
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (6,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (6,10,3,1,0);

-- Puzzle 7
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (7,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (7,10,3,2,0);

-- Puzzle 8
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (8,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (8,10,3,3,0);

-- MEDIUM DIFFICULTY (ORANGE)
-- Puzzle 9
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (9,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (9,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (9,10,3,3,0);

-- Puzzle 10
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (10,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (10,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (10,10,3,3,0);

-- Puzzle 11
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (11,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (11,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (11,10,3,2,0);

-- Puzzle 12
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (12,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (12,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (12,10,3,3,0);

-- Puzzle 13
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (13,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (13,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (13,10,3,2,0);

-- Puzzle 14
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (14,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (14,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (14,10,3,1,0);

-- Puzzle 15
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (15,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (15,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (15,10,3,1,0);

-- Puzzle 16
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (16,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (16,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (16,10,3,1,0);

-- Puzzle 17
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (17,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (17,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (17,10,3,2,0);

-- MEDIUM DIFFICULTY (GREEN)
-- Puzzle 18
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (18,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (18,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (18,10,2,4,0);

-- Puzzle 19
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (19,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (19,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (19,10,1,4,0);

-- Puzzle 20
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (20,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (20,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (20,10,3,4,0);

-- Puzzle 21
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (21,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (21,10,1,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (21,10,1,1,0);

-- Puzzle 22
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (22,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (22,10,2,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (22,10,1,1,0);

-- Puzzle 23
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (23,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (23,10,2,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (23,10,3,1,0);

-- Puzzle 24
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (24,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (24,10,3,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (24,10,3,1,0);

-- Puzzle 25
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (25,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (25,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (25,10,1,4,0);

-- Puzzle 26
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (26,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (26,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (26,10,2,4,0);

-- Puzzle 27
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (27,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (27,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (27,10,2,4,0);

-- Puzzle 28
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (28,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (28,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (28,10,3,4,0);

-- MEDIUM DIFFICULTY (RED)
-- Puzzle 29
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (29,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (29,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (29,10,4,2,0);

-- Puzzle 30
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (30,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (30,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (30,10,3,2,0);

-- Puzzle 31
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (31,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (31,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (31,10,1,2,0);

-- Puzzle 32
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (32,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (32,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (32,10,0,2,0);

-- Puzzle 33
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (33,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (33,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (33,10,3,3,0);

-- Puzzle 34
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (34,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (34,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (34,10,4,3,0);

-- Puzzle 35
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (35,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (35,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (35,10,1,3,0);

-- Puzzle 36
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (36,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (36,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (36,10,1,3,0);

-- Puzzle 37
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (37,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (37,10,4,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (37,10,3,1,0);

-- Puzzle 38
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (38,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (38,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (38,10,4,1,0);

-- Puzzle 39
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (39,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (39,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (39,10,1,1,0);

-- Puzzle 40
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (40,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (40,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (40,10,1,1,0);

-- Puzzle 41
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (41,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (41,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (41,10,4,2,0);

-- Puzzle 42
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (42,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (42,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (42,10,4,3,0);

-- Puzzle 43
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (43,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (43,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (43,10,1,2,0);

-- Puzzle 44
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (44,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (44,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (44,10,1,2,0);

-- Puzzle 45
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (45,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (45,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (45,10,4,4,0);

-- Puzzle 46
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (46,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (46,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (46,10,1,3,0);

-- Puzzle 47
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (47,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (47,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (47,10,1,3,0);

-- Puzzle 48
INSERT INTO puzzles(difficulty) VALUES (1);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (48,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (48,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (48,10,4,4,0);

-- MEDIUM DIFFICULTY (BLUE)
-- Puzzle 49
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (49,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (49,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (49,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (49,10,4,3,0);

-- Puzzle 50
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (50,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (50,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (50,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (50,10,4,3,0);

-- Puzzle 51
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (51,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (51,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (51,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (51,10,2,3,0);

-- Puzzle 52
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (52,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (52,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (52,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (52,10,3,3,0);

-- Puzzle 53
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (53,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (53,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (53,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (53,10,4,2,0);

-- Puzzle 54
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (54,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (54,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (54,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (54,10,4,2,0);

-- Puzzle 55
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (55,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (55,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (55,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (55,10,2,3,0);

-- Puzzle 56
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (56,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (56,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (56,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (56,10,3,3,0);

-- Puzzle 57
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (57,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (57,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (57,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (57,10,4,3,0);

-- Puzzle 58
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (58,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (58,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (58,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (58,10,4,3,0);

-- Puzzle 59
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (59,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (59,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (59,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (59,10,1,3,0);

-- Puzzle 60
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (60,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (60,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (60,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (60,10,2,3,0);

-- Puzzle 61
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (61,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (61,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (61,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (61,10,4,4,0);

-- Puzzle 62
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (62,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (62,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (62,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (62,10,4,4,0);

-- Puzzle 63
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (63,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (63,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (63,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (63,10,2,3,0);

-- Puzzle 64
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (64,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (64,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (64,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (64,10,3,3,0);

-- Puzzle 65
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (65,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (65,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (65,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (65,10,3,2,0);

-- Puzzle 66
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (66,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (66,10,0,4,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (66,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (66,10,3,1,0);

-- Puzzle 67
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (67,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (67,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (67,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (67,10,4,4,0);

-- Puzzle 68
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (68,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (68,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (68,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (68,10,4,4,0);

-- Puzzle 69
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (69,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (69,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (69,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (69,10,1,3,0);

-- Puzzle 70
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (70,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (70,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (70,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (70,10,1,3,0);

-- Puzzle 71
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (71,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (71,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (71,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (71,10,4,3,0);

-- Puzzle 72
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (72,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (72,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (72,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (72,10,4,3,0);

-- Puzzle 73
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,3,2,0);

-- Puzzle 74
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,1,3,0);

-- Puzzle 75
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,3,3,0);

-- Puzzle 76
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,3,3,0);

-- Puzzle 77
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,4,3,0);

-- Puzzle 78
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,4,3,0);

-- Puzzle 79
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,1,3,0);

-- Puzzle 80
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,0,3,0);

-- Puzzle 81
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,4,2,0);

-- Puzzle 82
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,4,2,0);

-- Puzzle 83
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,3,3,0);

-- Puzzle 84
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,3,2,0);

-- Puzzle 85
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,2,3,0);

-- Puzzle 86
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,3,3,0);

-- Puzzle 87
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,1,3,0);

-- Puzzle 88
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,2,3,0);

-- Puzzle 89
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,4,3,0);

-- Puzzle 90
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,3,2,0);

-- Puzzle 91
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,1,2,0);

-- Puzzle 92
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,0,2,0);

-- Puzzle 93
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,3,3,0);

-- Puzzle 94
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,3,2,0);

-- Puzzle 95
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,3,2,0);

-- Puzzle 96
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,3,2,0);

-- Puzzle 97
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,1,3,0);

-- Puzzle 98
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,2,3,0);

-- Puzzle 99
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,2,3,0);

-- Puzzle 100
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,3,3,0);

-- Puzzle 101
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,3,3,0);

-- Puzzle 102
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,0,3,0);

-- Puzzle 103
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,4,3,0);

-- Puzzle 104
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,4,2,0);

-- Puzzle 105
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,3,3,0);

-- Puzzle 106
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,3,2,0);

-- Puzzle 107
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,3,2,0);

-- Puzzle 108
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,2,3,0);

-- Puzzle 109
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,3,3,0);

-- Puzzle 110
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,1,3,0);

-- Puzzle 111
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,2,3,0);

-- Puzzle 112
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,1,2,0);

-- Puzzle 113
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,1,3,0);

-- Puzzle 114
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,1,3,0);

-- Puzzle 115
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,3,3,0);

-- Puzzle 116
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,3,2,0);

-- Puzzle 117
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,3,2,0);

-- Puzzle 118
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,3,1,0);

-- Puzzle 119
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,4,1,0);

-- Puzzle 120
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,2,3,0);

-- Puzzle 121
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,3,3,0);

-- Puzzle 122
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,4,0,0);

-- Puzzle 123
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,4,0,0);

-- Puzzle 124
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,4,2,0);

-- Puzzle 125
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,4,2,0);

-- Puzzle 126
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,2,2,0);

-- Puzzle 127
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (127,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (127,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (127,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (127,10,3,1,0);

-- Puzzle 128
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,4,1,0);

-- Puzzle 129
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,4,1,0);

-- Puzzle 130
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,1,1,0);

-- Puzzle 131
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,1,1,0);

-- Puzzle 132
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,4,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,3,3,0);

-- Puzzle 133
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,4,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,3,2,0);

-- Puzzle 134
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,1,2,0);

-- Puzzle 135
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,1,3,0);

-- Puzzle 136
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,4,0,0);

-- Puzzle 137
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,4,0,0);

-- Puzzle 138
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,3,2,0);

-- Puzzle 139
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,3,1,0);


INSERT INTO statistics(number_games, number_single_player_wins, number_single_player_losses, number_multi_player_wins, number_multi_player_losses) VALUES (34, 10, 4, 7, 13);
INSERT INTO statistics(number_games, number_single_player_wins, number_single_player_losses, number_multi_player_wins, number_multi_player_losses) VALUES (42, 20, 9, 11, 2);

INSERT INTO users(statistics_id, username,password,email,is_admin,enabled) VALUES (1, 'admin','admin','admin@localhost.com',true,true);
INSERT INTO users(statistics_id, username,password,email,is_admin,enabled) VALUES (2, 'user','user','user@localhost.com',false,true);

-- Game 1
INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated) VALUES
                                                                                            (3, 1, 0, false, 2,     1,       '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                            (3, 1, 1, false, null,  null,   '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                            (8, 1, 1, false, null,  null,   '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                            (6, 1, 1, false, null,  null,   '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                            (6, 1, 2, false, null,  null,   '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157');
INSERT INTO singleplayer_game(date_ended, date_started, user_id, puzzle_id, last_placed_card_id, energy, game_status) VALUES (null, '2022-11-09 11:08:21.139157', 1, 1, 1, 3, 1);
INSERT INTO singleplayer_game_game_cards(singleplayer_id, game_cards_id) VALUES (1, 1),
                                                                                (1, 2),
                                                                                (1, 3),
                                                                                (1, 4),
                                                                                (1, 5);

-- Game 2
INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated) VALUES
                                                                                             (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (6, 1, 0, 0, 2, 1, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (8, 1, 0, 3, 1, 1, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157');

INSERT INTO singleplayer_game(date_ended, date_started, user_id, puzzle_id, last_placed_card_id, energy, game_status) VALUES (null, '2022-11-09 11:08:21.139157', 1, 2, 8, 3, 1);
INSERT INTO singleplayer_game_game_cards(singleplayer_id, game_cards_id) VALUES (2, 6),
                                                                                (2, 7),
                                                                                (2, 8),
                                                                                (2, 9);


-- Game 3
INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated) VALUES
                                                                                             (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (6, 1, 0, 0, 2, 1, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157'),
                                                                                             (8, 1, 0, 3, 1, 1, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157');

INSERT INTO singleplayer_game(date_ended, date_started, user_id, puzzle_id, last_placed_card_id, energy, game_status) VALUES (null, '2022-11-09 11:08:21.139157', 1, 2, 8, 0, 1);
INSERT INTO singleplayer_game_game_cards(singleplayer_id, game_cards_id) VALUES (3, 10),
                                                                                (3, 11),
                                                                                (3, 12),
                                                                                (3, 13);


INSERT INTO singleplayer_game(date_ended, date_started, user_id, game_status) VALUES (null, '2022-11-09 11:08:21.139157', 1, 1);

-- Multiplayer game 1
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 1, 1, 3, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (2, 1, 2, 3, 0);

-- Multiplayer game 2 (user 1 active)
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status, active_player_id, round) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 1, 1, 1);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 2, 1, 3, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (2, 2, 2, 3, 0);

INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated) VALUES
                                                                                      (1, 1, 0, 0, 2, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157'),
                                                                                      (1, 2, 0, 0, 4, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157'),
                                                                                      (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157');
INSERT INTO multiplayer_games_game_cards(multiplayer_id, game_cards_id) VALUES (2, 14),
                                                                               (2, 15),
                                                                               (2, 16);

-- Multiplayer game 3 (user 2 active)
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status, active_player_id, round) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 1, 2, 1);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 3, 1, 3, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (2, 3, 2, 3, 0);

INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated) VALUES
                                                                                      (1, 1, 0, 0, 2, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157'),
                                                                                      (1, 2, 0, 0, 4, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157'),
                                                                                      (3, 1, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157');
INSERT INTO multiplayer_games_game_cards(multiplayer_id, game_cards_id) VALUES (3, 17),
                                                                               (3, 18),
                                                                               (3, 19);

-- Multiplayer game 4 (user 2 active, should advance round)
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status, active_player_id, round) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 1, 2, 3);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 4, 1, 2, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (2, 4, 2, 2, 0);

INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated, round) VALUES
                                                                                      (1, 1, 0, 0, 2, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                      (1, 2, 0, 0, 4, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                      (3, 2, 1, 0, 4, 2, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', 3),
                                                                                      (2, 1, 0, 0, 2, 2, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', 3);
INSERT INTO multiplayer_games_game_cards(multiplayer_id, game_cards_id) VALUES (4, 20),
                                                                               (4, 21),
                                                                               (4, 22),
                                                                               (4, 23);

-- Multiplayer game 5 (user 2 active, should advance round after card is placed)
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status, active_player_id, round) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 1, 2, 3);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 5, 1, 2, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (2, 5, 2, 3, 0);

INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated, round) VALUES
                                                                                             (1, 1, 0, 0, 2, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                             (1, 2, 0, 0, 4, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                             (3, 2, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', null),
                                                                                             (2, 1, 0, 0, 2, 2, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', 3);
INSERT INTO multiplayer_games_game_cards(multiplayer_id, game_cards_id) VALUES (5, 24),
                                                                               (5, 25),
                                                                               (5, 26),
                                                                               (5, 27);

-- Multiplayer game 6 (user 2 active, should not advance round after card is placed)
INSERT INTO multiplayer_games(date_ended, date_started, is_public, search_date, game_status, active_player_id, round) VALUES (null, '2022-11-09 11:08:21.139157', 0, '2022-11-09 11:07:21.139157', 1, 2, 3);
INSERT INTO usergames(user_id, game_id, player, energy, role) VALUES (1, 6, 1, 2, 0);
INSERT INTO usergames(user_id, game_id, player, energy, role, ability_used) VALUES (2, 6, 2, 3, 0, 2); -- Boost used

INSERT INTO game_card(card_id, user_id, status, rotation, x, y, created, updated, round) VALUES
                                                                                             (1, 1, 0, 0, 2, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                             (1, 2, 0, 0, 4, 3, '2022-11-09 10:08:21.139157', '2022-11-09 10:08:21.139157', null),
                                                                                             (3, 2, 0, 0, 4, 2, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:22.139157', 3),
                                                                                             (3, 2, 1, 0, null, null, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', 3),
                                                                                             (2, 1, 0, 0, 2, 2, '2022-11-09 11:08:21.139157', '2022-11-09 11:08:21.139157', 3);
INSERT INTO multiplayer_games_game_cards(multiplayer_id, game_cards_id) VALUES (6, 28),
                                                                               (6, 29),
                                                                               (6, 30),
                                                                               (6, 31),
                                                                               (6, 32);

-- Achievements
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('Winner','Win one Game', 1, 1);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('TEST admin 2','Win one Game', 3, 50);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('TEST user 3','Win one Game', 1, 10);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('Gamer','Create one multiplayer game', 4, 1);

INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,1);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,2);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,3);


