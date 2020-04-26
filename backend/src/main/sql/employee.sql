use carpooling;
CREATE TABLE employee (
	`id` int not null PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`number` VARCHAR(15) NOT NULL,
	`gender` VARCHAR(10) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL
);