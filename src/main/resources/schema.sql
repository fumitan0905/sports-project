-- テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS players CASCADE;
DROP TABLE IF EXISTS performance ;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS health;
DROP TABLE IF EXISTS cook;

-- カテゴリーテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   memberID TEXT,
   name TEXT,
   role INTEGER,
   password TEXT
);
-- カテゴリーテーブル
CREATE TABLE players
(
   id SERIAL PRIMARY KEY,
   player_Id INTEGER,
   name TEXT,
   height INTEGER,
   weight INTEGER,
   age INTEGER,
   position TEXT,
   birthplace TEXT,
   body_fat_per INTEGER
);
--成績テーブル
CREATE TABLE performance
(
   id SERIAL PRIMARY KEY,
   
   goals INTEGER,
   asists INTEGER,
   foul INTEGER,
   fouled INTEGER,
   yellowcard INTEGER,
   redcard INTEGER,
   games INTEGER,
   player_id INTEGER REFERENCES Players(id)
);

-- コメントテーブル
CREATE TABLE comments
(
   id SERIAL PRIMARY KEY,
   title TEXT,
   name TEXT,
   content TEXT,
   createdAt TIMESTAMP
);

-- 健康管理テーブル
CREATE TABLE health
(
	id SERIAL PRIMARY KEY,
	player_health_id INTEGER REFERENCES Players(id),
	wakeup_time TIME,
	bedtime_time TIME,
	cooking_id INTEGER,
	eat_date DATE
);

-- 料理テーブル
CREATE TABLE cook
(
	id SERIAL PRIMARY KEY,
	dish_name TEXT,
	dish_calories INTEGER
);