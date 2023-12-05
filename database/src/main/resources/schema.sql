-- Drop tables if they exist
DROP TABLE IF EXISTS `books`;
DROP TABLE IF EXISTS `authors`;

-- Create authors table
CREATE TABLE `authors` (
    `id` bigint AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `age` integer,
    CONSTRAINT `authors_pk` PRIMARY KEY (`id`)
);

-- Create books table with foreign key constraint
CREATE TABLE `books` (
    `isbn` varchar(255),
    `title` varchar(255) NOT NULL,
    `author_id` bigint NOT NULL,
    CONSTRAINT `books_pk` PRIMARY KEY (`isbn`),
    CONSTRAINT `fk_author_id` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);
