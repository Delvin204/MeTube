drop database MeTube
create database MeTube
use MeTube

create table videos(
	id char(11),
	title nvarchar(50),
	poster nvarchar(50),
	description nvarchar(max),
	active bit,
	views int,
	owner nvarchar(50),
	url nvarchar(50),
	type nvarchar(20)
);

create table favourites(
	id bigint,
	videoId char(11),
	userId nvarchar(20),
	likeDate date
);

create table users(
	id nvarchar(20),
	password nvarchar(50),
	fullname nvarchar(50),
	email nvarchar(50),
	admin bit
);

INSERT INTO videos (id, title, poster, description, active, views, owner, url, type)
VALUES
  ('v001', N'Gangnam Style - PSY', N'Gangnam Style - PSY.webp', N'MV ca nhạc "Gangnam Style" của PSY', 1, 5000000, N'PSY', N'Gangnam Style - PSY.mp4','KPOP'),
  ('v002', N'Despacito - Luis Fonsi ft. Daddy Yankee', N'Despacito - Luis Fonsi ft. Daddy Yankee.webp', N'Bài hát Despacito của Luis Fonsi ft. Daddy Yankee', 1, 80000000, N'Luis Fonsi', N'Despacito - Luis Fonsi ft. Daddy Yankee.mp4','US-UK'),
  ('v003', N'Shape of You - Ed Sheeran', N'Shape of You - Ed Sheeran.webp', N'Shape of You - Ed Sheeran', 1, 55000000, N'Ed Sheeran', N'Shape of You - Ed Sheeran.mp4','US-UK'),
  ('v004', N'Uptown Funk - Mark Ronson ft. Bruno Mars', N'Uptown Funk - Mark Ronson ft. Bruno Mars.webp', N'Uptown Funk - Mark Ronson ft. Bruno Mars', 1, 42000000, N'Mark Ronson', N'Uptown Funk - Mark Ronson ft. Bruno Mars.mp4','US-UK'),
  ('v005', N'WREN EVANS - Tò Te Tí', N'WREN EVANS - Tò Te Tí.webp', N'WREN EVANS - Tò Te Tí', 1, 8000000, N'WREN EVANS', N'WREN EVANS - Tò Te Tí.mp4','VPOP'),
  ('v006', N'See You Again - Wiz Khalifa ft. Charlie Puth', N'See You Again - Wiz Khalifa ft. Charlie Puth.webp', N'See You Again - Wiz Khalifa ft. Charlie Puth', 1, 35000000, N'Wiz Khalifa', N'See You Again - Wiz Khalifa ft. Charlie Puth.mp4','US-UK'),
  ('v007', N'SƠN TÙNG M-TP - CHÚNG TA CỦA TƯƠNG LAI', N'SƠN TÙNG M-TP - CHÚNG TA CỦA TƯƠNG LAI.webp', N'SƠN TÙNG M-TP - CHÚNG TA CỦA TƯƠNG LAI', 1, 5000000, N'SƠN TÙNG M-TP', N'SƠN TÙNG M-TP - CHÚNG TA CỦA TƯƠNG LAI.mp4','VPOP'),
  ('v008', N'Thinking Out Loud - Ed Sheeran', N'Thinking Out Loud - Ed Sheeran.webp', N'Thinking Out Loud - Ed Sheeran', 1, 30000000, N'Ed Sheeran', N'Thinking Out Loud - Ed Sheeran.mp4','US-UK'),
  ('v009', N'Perfect - Ed Sheeran', N'Perfect - Ed Sheeran.webp', N'Perfect - Ed Sheeran', 1, 28000000, N'Ed Sheeran', N'Perfect - Ed Sheeran.mp4','US-UK'),
  ('v010', N'NHỮNG LỜI HỨA BỎ QUÊN - VŨ x DEAR JANE', N'NHỮNG LỜI HỨA BỎ QUÊN - VŨ x DEAR JANE.webp', N'NHỮNG LỜI HỨA BỎ QUÊN - VŨ x DEAR JANE', 1, 3000000, N'VŨ', N'NHỮNG LỜI HỨA BỎ QUÊN - VŨ x DEAR JANE.mp4','VPOP'),
  ('v011', N'BLACKPINK - DDU-DU DDU-DU', N'BLACKPINK - DDU-DU DDU-DU.webp', N'BLACKPINK - DDU-DU DDU-DU', 1, 21000000, N'BLACKPINK', N'BLACKPINK - DDU-DU DDU-DU.mp4','KPOP'),
  ('v012', N'BTS - IDOL Official MV', N'BTS - IDOL Official MV.webp', N'BTS - IDOL Official MV', 1, 25000000, N'BTS', N'BTS - IDOL Official MV.mp4','KPOP');
  


INSERT INTO users (id, password, fullname, email, admin)
VALUES 
('user1', 'password1', 'John Doe', 'john@example.com', 0),
('user2', 'password2', 'Alice Smith', 'alice@example.com', 0),
('user3', 'password3', 'Bob Johnson', 'bob@example.com', 0),
('user4', 'password4', 'Emily Brown', 'emily@example.com', 0),
('user5', 'password5', 'Michael Wilson', 'michael@example.com', 1),
('user6', 'password6', 'Emma Lee', 'emma@example.com', 0),
('user7', 'password7', 'William Taylor', 'william@example.com', 0),
('user8', 'password8', 'Sophia Martinez', 'sophia@example.com', 0),
('user9', 'password9', 'James Anderson', 'james@example.com', 0),
('user10', 'password10', 'Olivia Garcia', 'olivia@example.com', 1);

INSERT INTO favourites (id, videoId, userId, likeDate)
VALUES
(1, 'v001', 'user1', '2024-04-01'),
(2, 'v001', 'user2', '2023-12-02'),
(3, 'v001', 'user3', '2023-09-03'),
(4, 'v002', 'user4', '2024-01-04'),
(5, 'v003', 'user5', '2024-04-05'),
(6, 'v003', 'user6', '2023-11-06'),
(7, 'v004', 'user7', '2024-04-07'),
(8, 'v004', 'user8', '2024-02-08'),
(9, 'v004', 'user9', '2024-04-09'),
(10, 'v005', 'user10', '2024-03-10');

CREATE TRIGGER InsertLikeDateTrigger
ON favourites
INSTEAD OF INSERT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @RowCount INT;

    -- Đếm số lượng hàng hiện có trong bảng
    SELECT @RowCount = COUNT(*) FROM favourites;

    -- Tăng giá trị biến số lượng hàng lên 1
    SET @RowCount = @RowCount + 1;

    -- Insert dữ liệu mới với cột ID tự tăng
    INSERT INTO favourites (id, videoId, userId, likeDate)
    SELECT 
        @RowCount, videoId, userId, CONVERT(date, GETDATE())
    FROM 
        inserted;
END;

