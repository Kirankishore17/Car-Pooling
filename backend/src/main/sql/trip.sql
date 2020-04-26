use carpooling;
CREATE TABLE trip (
	`id` int not null PRIMARY KEY AUTO_INCREMENT,
	`driverid` int not null ,
	`userid` int not null ,	
    `date` VARCHAR(50) NOT NULL
);