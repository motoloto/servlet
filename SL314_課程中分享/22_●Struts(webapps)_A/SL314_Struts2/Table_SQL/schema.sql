--
-- This is the Database Schema for the Sport League system.
--

-- Clear out the old table, if they existed at all.
DROP TABLE Registration;
DROP TABLE Player;
DROP TABLE League;
DROP TABLE ObjectIDs;


--
-- This table represents the "next" object_ID for a given table.
--
CREATE TABLE ObjectIDs (
-- PRIMARY KEY --
   table_name      VARCHAR(30)    PRIMARY KEY,
-- DATA FIELDS --
   ID_number       INTEGER        NOT NULL
);


--
-- This table represents the League objects
--
CREATE TABLE League (
-- PRIMARY KEY --
   LID             INTEGER        PRIMARY KEY,   -- League's object ID
-- DATA FIELDS --
   year            INTEGER        NOT NULL,      -- year of league
   season          VARCHAR(10)    NOT NULL,      -- season: Spring/Summer/Fall
   title           VARCHAR(30)    NOT NULL       -- the title of the league
);


--
-- This table represents the Player objects
--
CREATE TABLE Player (
-- PRIMARY KEY --
   PID             INTEGER        PRIMARY KEY,   -- Player's object ID
-- DATA FIELDS --
   name            VARCHAR(30)    NOT NULL,      -- the player's full name
   address         VARCHAR(30)    NOT NULL,      -- the player's street addr
   city            VARCHAR(20)    NOT NULL,      -- the player's city
   province        VARCHAR(10)    NOT NULL,      -- the player's province/state
   postal_code     VARCHAR(10)    NOT NULL       -- the player's postal code
);


--
-- This table represents the relationship between leagues and players.
--
CREATE TABLE Registration (
-- PRIMARY KEY --
   LID             INTEGER        NOT NULL,
   PID             INTEGER        NOT NULL,
-- DATA FIELDS --
   division        VARCHAR(20)    NOT NULL
);


COMMIT;
