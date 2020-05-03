use carpooling;
CREATE TABLE driver (
	`id` int not null,
	`time` VARCHAR(20) NOT NULL,
	`seats` INT NOT NULL,
	`sourcepoint` VARCHAR(50) NOT NULL,
	`destinationpoint` VARCHAR(50) NOT NULL,
	`vehiclenumber` VARCHAR(50) NOT NULL,
    `date` VARCHAR(50) NOT NULL,
    `primarykey` int not null  PRIMARY KEY AUTO_INCREMENT
);