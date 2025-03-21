insert into member (birth_date, created_at, updated_at, email, first_name, last_name, password, role, username) values
('1990-01-01', current_timestamp, current_timestamp, 'john.doe@example.com', 'john', 'doe', 'password123', 'READER', 'johndoe'),
('1985-05-15', current_timestamp, current_timestamp, 'frau.loli@example.com', 'frau', 'loli', 'password456', 'WRITER', 'frauloli');

insert into genre (description, name) values
('Fiction books', 'Fiction'),
('Non-fiction books', 'Non-fiction');

insert into book (pages, price, added_at, author_id, genre_id, likes, updated_at, description, isbn, title) values
(300, 20, current_timestamp, 2, 1, 1120, current_timestamp, 'A fascinating fiction book', '978-3-16-148410-0', 'The great adventure'),
(150, 15, current_timestamp, 2, 2, 5410, current_timestamp, 'An informative non-fiction book', '978-3-16-148411-7', 'The art of learning');

insert into user_library (book_id, user_id) values
(1, 1),
(2, 1);

