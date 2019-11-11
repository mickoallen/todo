CREATE TABLE todo."todo"
(
    id int auto_increment
	chore varchar(255) NOT NULL,
    priority numeric(5) NOT NULL,
    finished boolean default false,
)