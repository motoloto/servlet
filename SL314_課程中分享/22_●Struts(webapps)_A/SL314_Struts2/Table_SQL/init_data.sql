--
-- This script populates the Sport League database.
--

-- Insert the basic ObjectID types.
INSERT INTO ObjectIDs (table_name, ID_number)
  VALUES ('League', 7);
INSERT INTO ObjectIDs (table_name, ID_number)
  VALUES ('Player', 1);

-- Create the initial set of leagues.
INSERT INTO League (LID, year, season, title)
  VALUES (1, 2003, 'Spring', 'Soccer League (Spring ''03)');
INSERT INTO League (LID, year, season, title)
  VALUES (2, 2003, 'Summer', 'Summer Soccer Fest 2003');
INSERT INTO League (LID, year, season, title)
  VALUES (3, 2003, 'Fall', 'Fall Soccer League (2003)');
INSERT INTO League (LID, year, season, title)
  VALUES (4, 2004, 'Spring', 'Soccer League (Spring ''04)');
INSERT INTO League (LID, year, season, title)
  VALUES (5, 2004, 'Summer', 'The Summer of Soccer Love 2004');
INSERT INTO League (LID, year, season, title)
  VALUES (6, 2004, 'Fall', 'Fall Soccer League (2004)');

COMMIT;
