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
INSERT INTO cards(initiative,top_side,bottom_side,left_side,right_side) VALUES (3,0,0,0,0); -- Energy card

-- EASY DIFFICULTY (YELLOW)
-- Puzzle 1
INSERT INTO puzzles(id, difficulty) VALUES (1, 0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (1,1,2,2,0);

-- Puzzle 2
INSERT INTO puzzles(id, difficulty) VALUES (2, 0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,10,2,3,0);

-- Puzzle 3
INSERT INTO puzzles(id, difficulty) VALUES (3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,10,1,3,0);

-- Puzzle 73
INSERT INTO puzzles(id, difficulty) VALUES (73,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,10,1,3,0);

-- Puzzle 74
INSERT INTO puzzles(id, difficulty) VALUES (74,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,10,1,3,0);

-- Puzzle 75
INSERT INTO puzzles(id, difficulty) VALUES (75,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,10,4,3,0);

-- Puzzle 76
INSERT INTO puzzles(id, difficulty) VALUES (76,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,10,4,3,0);

-- Puzzle 77
INSERT INTO puzzles(id, difficulty) VALUES (77,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,10,3,2,0);

-- Puzzle 78
INSERT INTO puzzles(id, difficulty) VALUES (78,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,10,1,3,0);

-- Puzzle 79
INSERT INTO puzzles(id, difficulty) VALUES (79,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,10,3,3,0);

-- Puzzle 80
INSERT INTO puzzles(id, difficulty) VALUES (80,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,10,3,3,0);

-- Puzzle 81
INSERT INTO puzzles(id, difficulty) VALUES (81,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,10,4,3,0);

-- Puzzle 82
INSERT INTO puzzles(id, difficulty) VALUES (82,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,10,4,3,0);

-- Puzzle 83
INSERT INTO puzzles(id, difficulty) VALUES (83,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,10,1,3,0);

-- Puzzle 84
INSERT INTO puzzles(id, difficulty) VALUES (84,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,10,0,3,0);

-- Puzzle 85
INSERT INTO puzzles(id, difficulty) VALUES (85,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,10,4,2,0);

-- Puzzle 86
INSERT INTO puzzles(id, difficulty) VALUES (86,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,10,4,2,0);

-- Puzzle 87
INSERT INTO puzzles(id, difficulty) VALUES (87,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,10,3,3,0);

-- Puzzle 88
INSERT INTO puzzles(id, difficulty) VALUES (88,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,10,3,2,0);

-- Puzzle 89
INSERT INTO puzzles(id, difficulty) VALUES (89,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,10,2,3,0);

-- Puzzle 90
INSERT INTO puzzles(id, difficulty) VALUES (90,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,10,3,3,0);

-- Puzzle 91
INSERT INTO puzzles(id, difficulty) VALUES (91,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (91,10,1,3,0);

-- Puzzle 92
INSERT INTO puzzles(id, difficulty) VALUES (92,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,10,2,3,0);

-- Puzzle 93
INSERT INTO puzzles(id, difficulty) VALUES (93,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,10,4,3,0);

-- Puzzle 94
INSERT INTO puzzles(id, difficulty) VALUES (94,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,10,3,2,0);

-- Puzzle 95
INSERT INTO puzzles(id, difficulty) VALUES (95,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,10,1,2,0);

-- Puzzle 96
INSERT INTO puzzles(id, difficulty) VALUES (96,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,10,0,2,0);

-- Puzzle 97
INSERT INTO puzzles(id, difficulty) VALUES (97,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,10,3,3,0);

-- Puzzle 98
INSERT INTO puzzles(id, difficulty) VALUES (98,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,10,3,2,0);

-- Puzzle 99
INSERT INTO puzzles(id, difficulty) VALUES (99,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,10,3,2,0);

-- Puzzle 100
INSERT INTO puzzles(id, difficulty) VALUES (100,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,10,3,2,0);

-- Puzzle 101
INSERT INTO puzzles(id, difficulty) VALUES (101,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,10,1,3,0);

-- Puzzle 102
INSERT INTO puzzles(id, difficulty) VALUES (102,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,10,2,3,0);

-- Puzzle 103
INSERT INTO puzzles(id, difficulty) VALUES (103,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,10,2,3,0);

-- Puzzle 104
INSERT INTO puzzles(id, difficulty) VALUES (104,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,10,3,3,0);

-- Puzzle 105
INSERT INTO puzzles(id, difficulty) VALUES (105,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,10,3,3,0);

-- Puzzle 106
INSERT INTO puzzles(id, difficulty) VALUES (106,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,10,0,3,0);

-- Puzzle 107
INSERT INTO puzzles(id, difficulty) VALUES (107,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,10,4,3,0);

-- Puzzle 108
INSERT INTO puzzles(id, difficulty) VALUES (108,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,10,4,2,0);

-- Puzzle 109
INSERT INTO puzzles(id, difficulty) VALUES (109,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,10,3,3,0);

-- Puzzle 110
INSERT INTO puzzles(id, difficulty) VALUES (110,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,10,3,2,0);

-- Puzzle 111
INSERT INTO puzzles(id, difficulty) VALUES (111,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,10,3,2,0);

-- Puzzle 112
INSERT INTO puzzles(id, difficulty) VALUES (112,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,10,2,3,0);

-- Puzzle 113
INSERT INTO puzzles(id, difficulty) VALUES (113,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,10,3,3,0);

-- Puzzle 114
INSERT INTO puzzles(id, difficulty) VALUES (114,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,10,1,3,0);

-- Puzzle 115
INSERT INTO puzzles(id, difficulty) VALUES (115,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,10,2,3,0);

-- Puzzle 116
INSERT INTO puzzles(id, difficulty) VALUES (116,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,10,1,2,0);

-- Puzzle 117
INSERT INTO puzzles(id, difficulty) VALUES (117,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,10,1,3,0);

-- Puzzle 118 (Puzzle 008)
INSERT INTO puzzles(id, difficulty) VALUES (118,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,10,1,3,0);

-- Puzzle 119
INSERT INTO puzzles(id, difficulty) VALUES (119,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,10,3,3,0);

-- Puzzle 120
INSERT INTO puzzles(id, difficulty) VALUES (120,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,10,3,2,0);

-- Puzzle 121
INSERT INTO puzzles(id, difficulty) VALUES (121,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,10,3,2,0);

-- Puzzle 122
INSERT INTO puzzles(id, difficulty) VALUES (122,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,10,3,1,0);

-- Puzzle 123
INSERT INTO puzzles(id, difficulty) VALUES (123,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,10,4,1,0);

-- Puzzle 124
INSERT INTO puzzles(id, difficulty) VALUES (124,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,10,2,3,0);

-- Puzzle 125
INSERT INTO puzzles(id, difficulty) VALUES (125,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,10,3,3,0);

-- Puzzle 126
INSERT INTO puzzles(id, difficulty) VALUES (126,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,4,0,0);

-- Puzzle 127
INSERT INTO puzzles(id, difficulty) VALUES (127,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,10,4,0,0);

-- Puzzle 128
INSERT INTO puzzles(id, difficulty) VALUES (128,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,10,4,2,0);

-- Puzzle 129
INSERT INTO puzzles(id, difficulty) VALUES (129,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,10,4,2,0);

-- Puzzle 130
INSERT INTO puzzles(id, difficulty) VALUES (130,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,10,2,2,0);

-- Puzzle 131
INSERT INTO puzzles(id, difficulty) VALUES (131,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,10,3,1,0);

-- Puzzle 132
INSERT INTO puzzles(id, difficulty) VALUES (132,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (132,10,4,1,0);

-- Puzzle 133
INSERT INTO puzzles(id, difficulty) VALUES (133,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (133,10,4,1,0);

-- Puzzle 134
INSERT INTO puzzles(id, difficulty) VALUES (134,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (134,10,1,1,0);

-- Puzzle 135
INSERT INTO puzzles(id, difficulty) VALUES (135,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (135,10,1,1,0);

-- Puzzle 136
INSERT INTO puzzles(id, difficulty) VALUES (136,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,4,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (136,10,3,3,0);

-- Puzzle 137
INSERT INTO puzzles(id, difficulty) VALUES (137,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,4,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (137,10,3,2,0);

-- Puzzle 138
INSERT INTO puzzles(id, difficulty) VALUES (138,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (138,10,1,2,0);

-- Puzzle 139
INSERT INTO puzzles(id, difficulty) VALUES (139,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (139,10,1,3,0);

-- Puzzle 140
INSERT INTO puzzles(id, difficulty) VALUES (140,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (140,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (140,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (140,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (140,10,4,0,0);

-- Puzzle 141
INSERT INTO puzzles(id, difficulty) VALUES (141,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (141,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (141,10,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (141,10,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (141,10,4,0,0);

-- Puzzle 142
INSERT INTO puzzles(id, difficulty) VALUES (142,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (142,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (142,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (142,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (142,10,3,2,0);

-- Puzzle 143
INSERT INTO puzzles(id, difficulty) VALUES (143,2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (143,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (143,10,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (143,10,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (143,10,3,1,0);


INSERT INTO statistics(number_games, number_single_player_wins, number_single_player_losses, number_multi_player_wins, number_multi_player_losses) VALUES (34, 10, 4, 7, 13);
INSERT INTO statistics(number_games, number_single_player_wins, number_single_player_losses, number_multi_player_wins, number_multi_player_losses) VALUES (42, 20, 9, 11, 2);

INSERT INTO users(statistics_id, username,password,email,is_admin,enabled) VALUES (1, 'admin','admin','admin@localhost.com',true,true);
INSERT INTO users(statistics_id, username,password,email,is_admin,enabled) VALUES (2, 'user','user','user@localhost.com',false,true);

INSERT INTO multiplayer_games(date_ended, date_started, p1energy_left, p2energy_left) VALUES (null, '2022-11-09 11:08:21.139157', 3, 3);
INSERT INTO usergames(user_id, game_id, player, role) VALUES (1, 1, 1, 'player');
INSERT INTO usergames(user_id, game_id, player, role) VALUES (2, 1, 2, 'player');
INSERT INTO singleplayer_game(date_ended, date_started, user_id) VALUES (null, '2022-11-09 11:08:21.139157', 1);

INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('Winner','Win one Game', 1, 1);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('TEST admin 2','Win one Game', 3, 50);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('TEST user 3','Win one Game', 1, 10);
INSERT INTO achievements(name,description,condition,condition_amount) VALUES ('Gamer','Create one multiplayer game', 4, 1);

INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,1);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,2);
INSERT INTO achievement_user(user_id,achievement_id) VALUES (1,3);

INSERT INTO board(id,background,height,width) VALUES (1,'resources/images/Background.png',560 ,560);

