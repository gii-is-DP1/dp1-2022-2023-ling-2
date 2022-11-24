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

-- EASY DIFFICULTY (YELLOW)
-- Puzzle 1
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (1,1,2,2,0);

-- Puzzle 2
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (2,7,2,3,0);

-- Puzzle 3
INSERT INTO puzzles(difficulty) VALUES (0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (3,7,1,3,0);

-- Puzzle 73
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,7,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (73,7,1,3,0);

-- Puzzle 74
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,7,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (74,7,1,3,0);

-- Puzzle 75
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,7,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (75,7,4,3,0);

-- Puzzle 76
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,7,3,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (76,7,4,3,0);

-- Puzzle 77
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,7,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (77,7,3,2,0);

-- Puzzle 78
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (78,7,1,3,0);

-- Puzzle 79
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (79,7,3,3,0);

-- Puzzle 80
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (80,7,3,3,0);

-- Puzzle 81
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (81,7,4,3,0);

-- Puzzle 82
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (82,7,4,3,0);

-- Puzzle 83
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (83,7,1,3,0);

-- Puzzle 84
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (84,7,0,3,0);

-- Puzzle 85
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (85,7,4,2,0);

-- Puzzle 86
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,7,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (86,7,4,2,0);

-- Puzzle 87
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (87,7,3,3,0);

-- Puzzle 88
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (88,7,3,2,0);

-- Puzzle 89
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (89,7,2,3,0);

-- Puzzle 90
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,3,3,0);

-- Puzzle 91
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (90,7,1,3,0);

-- Puzzle 92
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (92,7,2,3,0);

-- Puzzle 93
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (93,7,4,3,0);

-- Puzzle 94
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (94,7,3,2,0);

-- Puzzle 95
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (95,7,1,2,0);

-- Puzzle 96
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,7,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (96,7,0,2,0);

-- Puzzle 97
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,7,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (97,7,3,3,0);

-- Puzzle 98
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,7,0,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (98,7,3,2,0);

-- Puzzle 99
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,7,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (99,7,3,2,0);

-- Puzzle 100
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,7,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,7,4,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (100,7,3,2,0);

-- Puzzle 101
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (101,7,1,3,0);

-- Puzzle 102
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (102,7,2,3,0);

-- Puzzle 103
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (103,7,2,3,0);

-- Puzzle 104
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (104,7,3,3,0);

-- Puzzle 105
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (105,7,3,3,0);

-- Puzzle 106
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (106,7,0,3,0);

-- Puzzle 107
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (107,7,4,3,0);

-- Puzzle 108
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (108,7,4,2,0);

-- Puzzle 109
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (109,7,3,3,0);

-- Puzzle 110
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (110,7,3,2,0);

-- Puzzle 111
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (111,7,3,2,0);

-- Puzzle 112
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (112,7,2,3,0);

-- Puzzle 113
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (113,7,3,3,0);

-- Puzzle 114
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (114,7,1,3,0);

-- Puzzle 115
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,7,4,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (115,7,2,3,0);

-- Puzzle 116
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (116,7,1,2,0);

-- Puzzle 117
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (117,7,1,3,0);

-- Puzzle 118 (Puzzle 008)
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,7,3,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (118,7,1,3,0);

-- Puzzle 119
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (119,7,3,3,0);

-- Puzzle 120
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,7,4,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (120,7,3,2,0);

-- Puzzle 121
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (121,7,3,2,0);

-- Puzzle 122
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,7,0,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (122,7,3,1,0);

-- Puzzle 123
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (123,7,4,1,0);

-- Puzzle 124
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,7,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (124,7,2,3,0);

-- Puzzle 125
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,7,0,0,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (125,7,3,3,0);

-- Puzzle 126
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,1,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,4,0,0);

-- Puzzle 127
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,2,3,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (126,7,4,0,0);

-- Puzzle 128
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (128,7,4,2,0);

-- Puzzle 129
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,7,1,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,7,3,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (129,7,4,2,0);

-- Puzzle 130
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (130,7,2,2,0);

-- Puzzle 131
INSERT INTO puzzles(difficulty) VALUES (2);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,1,2,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,7,0,2,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,7,1,1,0);
INSERT INTO puzzle_cards(puzzle_id,card_id,x,y,rotation) VALUES (131,7,3,1,0);

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



