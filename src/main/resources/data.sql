-- システムアクセス可能ユーザーテーブルデータ
INSERT INTO users(memberID, name, role,password) VALUES('1001', '上野イチロー', 1,'1234');
INSERT INTO users(memberID, name, role,password) VALUES('2002', '浅野マナブ', 2,'1234');
INSERT INTO users(memberID, name, role,password) VALUES('3003', '杉野イズミ', 3,'1234');
INSERT INTO users(memberID, name, role,password) VALUES('4004', '前野アサヒ', 4,'1234');

--選手データテーブル
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('1','川島英二','185','75','28','GK','大阪','15');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('2','楢崎正剛','190','86','34','GK','愛媛','12');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('3','小笠原満男','176','72','33','DF','神奈川','12');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('4','秋田豊','180','73','25','DF','北海道','11');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('5','石川直宏','173','66','24','DF','京都','14');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('6','長谷部誠','173','65','19','DF','東京','9');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('7','中田浩二','170','62','29','DF','神奈川','17');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('9','内田篤人','179','73','24','MF','大阪','15');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('10','遠藤保仁','173','70','22','MF','新潟','16');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('12','中田英寿','178','72','27','MF','埼玉','14');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('15','小野信二','169','63','31','MF','埼玉','8');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('17','本田啓介','181','80','20','MF','和歌山','10');
INSERT INTO players(player_id,name,height,weight,age,position,birthplace,body_fat_per) VALUES('18','前田遼一','182','79','19','FW','福岡','12');

--成績データテーブル
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('0','1','2','5','1','1','30','1');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('0','0','3','4','0','0','4','2');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('2','1','5','4','2','0','34','3');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('1','0','0','6','0','1','34','4');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('0','3','6','7','1','0','34','5');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('1','1','4','8','2','0','31','6');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('2','0','4','8','0','0','32','7');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('2','3','8','11','1','2','27','8');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('2','5','1','10','2','0','33','9');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('5','8','4','4','2','0','34','10');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('3','3','0','8','6','0','17','11');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('9','2','2','13','1','0','20','12');
INSERT INTO performance(goals,asists,foul,fouled,yellowcard,redcard,games, player_id) VALUES('15','3','2','7','2','1','34','13');

-- コメントデータテーブル
INSERT INTO comments(title, name, content, createdAt) VALUES('トレーニング','上野イチロー', '明日のトレーニング', '2022/02/02');

-- 健康管理テーブル
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('1','07:30','22:00','1','4','2','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('2','07:30','22:00','2','1','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('3','07:30','22:00','1','1','4','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('4','07:30','22:00','2','1','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('5','07:30','22:00','4','1','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('6','07:30','22:00','1','1','3','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('7','07:30','22:00','1','2','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('8','07:30','22:00','2','1','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('9','07:30','22:00','3','3','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('10','07:30','22:00','4','1','1','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('11','07:30','22:00','1','1','2','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('12','07:30','22:00','1','1','2','2023-06-30');
INSERT INTO health(player_health_id,wakeup_time,bedtime_time,breakfast_id,lunch_id,dinner_id,eat_date) VALUES('13','07:30','22:00','1','3','4','2023-06-30');

-- 料理テーブル
INSERT INTO cook(dish_name,dish_calories) VALUES('豚の生姜焼き','1500');
INSERT INTO cook(dish_name,dish_calories) VALUES('ハンバーグ定食','1300');
INSERT INTO cook(dish_name,dish_calories) VALUES('和風パスタ','1000');
INSERT INTO cook(dish_name,dish_calories) VALUES('うな重','1100');