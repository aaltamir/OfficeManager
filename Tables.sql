CREATE TABLE `OFFICE` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `openFrom` TIME NOT NULL,
    `openUntil` TIME NOT NULL,
    `timeDifference` INT(11) NOT NULL,
    `location` VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
;