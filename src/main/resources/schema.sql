-- テーブル削除
DROP TABLE IF EXISTS users;
-- カテゴリーテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   memberID TEXT,
   name TEXT,
   role INTEGER,
   password TEXT
);