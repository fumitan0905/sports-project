-- テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS players CASCADE;
DROP TABLE IF EXISTS performance ;
DROP TABLE IF EXISTS comments;

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
   birthplace TEXT
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