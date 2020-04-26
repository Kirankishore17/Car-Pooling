use carpooling;
CREATE TABLE user (
	`id` int not null PRIMARY KEY,
	`time` VARCHAR(20) NOT NULL,
	`sourcepoint` VARCHAR(10) NOT NULL,
	`destinationpoint` VARCHAR(50) NOT NULL,
    `date` VARCHAR(50) NOT NULL
);