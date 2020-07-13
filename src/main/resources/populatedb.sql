SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE  `link`;
TRUNCATE TABLE  `literature`;
TRUNCATE TABLE  `statistic`;
TRUNCATE TABLE  `userRole`;
TRUNCATE TABLE  `role`;
TRUNCATE TABLE  `user`;
TRUNCATE TABLE  `answer`;
TRUNCATE TABLE  `question`;
TRUNCATE TABLE  `test`;
TRUNCATE TABLE  `topic`;
SET FOREIGN_KEY_CHECKS=1;

-- populate topic table
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 1', 'Description Topic 1');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 2', 'Description Topic 2');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 3', 'Description Topic 3');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 4', 'Description Topic 4');
INSERT INTO `topic`(`name`, `description`)
VALUES('Topic 5', 'Description Topic 5');

-- populate test table
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 1', 'Description Test 1', 1);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 2', 'Description Test 2', 2);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 3', 'Description Test 3', 3);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 4', 'Description Test 4', 4);
INSERT INTO `test`(`name`, `description`, `topicId`)
VALUES('Test 5', 'Description Test 5', 5);

-- -- populate question table
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 1', 1);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 2', 2);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 3', 3);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 4', 4);
INSERT INTO `question`(`description`, `testId`)
VALUES('Question 5', 5);

-- populate answer table
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 1', false, 1);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 2', true, 2);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 3', true, 3);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 4', true, 4);
INSERT INTO `answer`(`description`, `correct`, `questionId`)
VALUES('Answer 5', false, 5);

-- populate user table
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
VALUES('Admin', 'Adminovic', 'admin', 'adminPassword');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
VALUES('Tutor', 'Tutorovic', 'tutor', 'tutorPassword');
INSERT INTO `user`(`firstName`, `lastName`, `login`, `password`)
VALUES('User', 'Userovic', 'user', 'userPassword');

-- populate role table
INSERT INTO `role`(`name`)
VALUES('ROLE_ADMIN');
INSERT INTO `role`(`name`)
VALUES('ROLE_TUTOR');
INSERT INTO `role`(`name`)
VALUES('ROLE_USER');

-- populate userRole table
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(1, 1);
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(2, 2);
INSERT INTO `userRole`(`userId`, `roleId`)
VALUES(3, 3);

-- populate statistic table
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12 10:37:22', false, 1, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12 10:38:22', true, 2, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12 10:39:22', false, 3, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12 10:40:22', true, 4, 3);
INSERT INTO `statistic`(`date`, `correct`, `questionId`, `userId`)
VALUES('2020-01-12 10:41:22', false, 5, 3);

-- populate literature table
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 1', 1);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 2', 2);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 3', 3);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 4', 4);
INSERT INTO `literature`(`description`, `questionId`)
VALUES('Literature 4', 5);

-- populate link table
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 1', 1);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 2', 2);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 3', 3);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 4', 4);
INSERT INTO `link`(`link`, `literatureId`)
VALUES('Link 5', 5);

-- update table 'user'

ALTER TABLE `assessment_system`.`user`
ADD COLUMN `nameRole` VARCHAR(255) NULL AFTER `password`;

UPDATE `assessment_system`.`user` SET `nameRole` = 'ROLE_ADMIN' WHERE (`id` = '1');
UPDATE `assessment_system`.`user` SET `nameRole` = 'ROLE_TUTOR' WHERE (`id` = '2');
UPDATE `assessment_system`.`user` SET `nameRole` = 'ROLE_USER' WHERE (`id` = '3');

UPDATE `assessment_system`.`user` SET `password` = '$2y$12$1kXXjK6ZX33hjSHiTsFvpOpgz7cMkAEXSD3GvvourqCLsckjSdA1q' WHERE (`id` = '1');
UPDATE `assessment_system`.`user` SET `password` = '$2y$12$kCo1gPtNdMZ0oYleuRfgxeRe1/qz9zSgUVY.IPFwrxVFJd/TlqOFq' WHERE (`id` = '2');
UPDATE `assessment_system`.`user` SET `password` = '$2y$12$FW178GM7QnkcoBPqdSsSy.foBE2Fmh9wDY/Caj5yQbRuHcplmMwRS' WHERE (`id` = '3');





UPDATE `assessment_system`.`test` SET `name` = 'Уравнения', `description` = 'Алгебраические уравнения' WHERE (`id` = '1');
UPDATE `assessment_system`.`test` SET `name` = 'Комбинаторика', `description` = 'Комбинаторика', `topicId` = '1' WHERE (`id` = '2');
UPDATE `assessment_system`.`test` SET `name` = 'Многопоточность', `description` = 'Многопоточность', `topicId` = '2' WHERE (`id` = '3');
UPDATE `assessment_system`.`test` SET `name` = 'Коллекции', `description` = 'Коллекции', `topicId` = '2' WHERE (`id` = '4');


UPDATE `assessment_system`.`question` SET `description` = 'Какое из приведенных равенств является уравнением?' WHERE (`id` = '1');
UPDATE `assessment_system`.`question` SET `description` = 'Какое из чисел является корнем уравнения y+322=351?', `testId` = '1' WHERE (`id` = '2');
UPDATE `assessment_system`.`question` SET `description` = 'Решите уравнение   x−137=215?', `testId` = '1' WHERE (`id` = '3');
UPDATE `assessment_system`.`question` SET `description` = 'Решите уравнение 400−y=275?', `testId` = '1' WHERE (`id` = '4');
UPDATE `assessment_system`.`question` SET `description` = 'Сколькими способами могут разместиться 7 человек в салоне автобуса на семи свободных местах?', `testId` = '2' WHERE (`id` = '5');
UPDATE `assessment_system`.`question` SET `description` = 'В пассажирском поезде 8 вагонов. Сколькими способами можно рассадить в поезде 3 человека, при условии, что все они должны ехать в различных вагонах?', `testId` = '2' WHERE (`id` = '6');
UPDATE `assessment_system`.`question` SET `description` = 'Сколько существует вариантов выбора двух чисел из восьми?', `testId` = '2' WHERE (`id` = '7');
UPDATE `assessment_system`.`question` SET `description` = 'Сколькими способами можно переставить буквы в слове \"луна\"?', `testId` = '2' WHERE (`id` = '8');
UPDATE `assessment_system`.`question` SET `description` = 'В какое состояние переходит поток после вызова метода start()?', `testId` = '3' WHERE (`id` = '9');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('10', 'В каком состоянии находится поток, если он создан и не запущен?', '3');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('11', 'Какой метод интерфейса Runnable должен быть реализован всеми потоками?', '3');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('12', 'Какой метод надо вызвать, чтобы запустить поток?', '3');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('13', 'Может ли класс из Collection Framework быть неотсортированным и упорядоченным?', '4');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('14', 'Что должно вернуть выражение x.equals(null) в соответствии с контрактом по написанию этого метода?', '4');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('15', 'Какой из следующих методов используется для получения набора, содержащего все ключи, используемые в карте?', '4');
INSERT INTO `assessment_system`.`question` (`id`, `description`, `testId`) VALUES ('16', 'Какой интерфейс предоставляет возможность хранить объекты в виде пар ключ-значение?', '4');

INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('6', 'Literature 6', '6');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('7', 'Literature 7', '7');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('8', 'Literature 8', '8');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('9', 'Literature 9', '9');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('10', 'Literature 10', '10');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('11', 'Literature 11', '11');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('12', 'Literature 12', '12');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('13', 'Literature 13', '13');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('14', 'Literature 14', '14');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('15', 'Literature 15', '15');
INSERT INTO `assessment_system`.`literature` (`id`, `description`, `questionId`) VALUES ('16', 'Literature 16', '16');
UPDATE `assessment_system`.`literature` SET `description` = 'Literature 5' WHERE (`id` = '5');

INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('6', 'Link 6', '6');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('7', 'Link 7', '7');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('8', 'Link 8', '8');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('9', 'Link 9', '9');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('10', 'Link 10', '10');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('11', 'Link 11', '11');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('12', 'Link 12', '12');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('13', 'Link 13', '13');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('14', 'Link 14', '14');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('15', 'Link 15', '15');
INSERT INTO `assessment_system`.`link` (`id`, `link`, `literatureId`) VALUES ('16', 'Link 16', '16');

UPDATE `assessment_system`.`answer` SET `description` = '22+5=27' WHERE (`id` = '1');
UPDATE `assessment_system`.`answer` SET `description` = '27-x=5', `questionId` = '1' WHERE (`id` = '2');
UPDATE `assessment_system`.`answer` SET `description` = '27-5=22', `correct` = '0', `questionId` = '1' WHERE (`id` = '3');
UPDATE `assessment_system`.`answer` SET `description` = '5=27-22', `correct` = '0', `questionId` = '1' WHERE (`id` = '4');
UPDATE `assessment_system`.`answer` SET `description` = '683', `questionId` = '2' WHERE (`id` = '5');
INSERT INTO `assessment_system`.`answer` (`id`, `description`, `correct`, `questionId`) VALUES ('6', '19', '0', '2');
INSERT INTO `assessment_system`.`answer` (`id`, `description`, `correct`, `questionId`) VALUES ('7', '9', '0', '2');
INSERT INTO `assessment_system`.`answer` (`id`, `description`, `correct`, `questionId`) VALUES ('8', '29', '1', '2');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('352', '1', '3');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('362', '0', '3');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('267', '0', '3');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('458', '0', '3');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('655', '0', '4');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('46', '0', '4');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('145', '1', '4');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('245', '0', '4');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('720', '1', '5');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('3600', '0', '5');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('36', '0', '5');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('18', '0', '5');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('1024', '0', '6');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('3096', '0', '6');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('9', '0', '6');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('36', '1', '6');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('28', '1', '7');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('56', '0', '7');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('73', '0', '7');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('23', '0', '7');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('12', '1', '8');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('14', '0', '8');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('6', '0', '8');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('4', '0', '8');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Runnable', '1', '9');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('New ', '0', '9');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Dead', '0', '9');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Runnable', '0', '10');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('New', '1', '10');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Dead', '0', '10');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('start()', '1', '11');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('run()', '0', '11');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('throw()', '0', '11');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('start()', '0', '12');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('run()', '1', '12');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('throw()', '0', '12');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('да', '1', '13');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('нет', '0', '13');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('null', '0', '14');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('NullPointerException', '0', '14');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('не скомпилируется', '0', '14');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('false', '1', '14');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('getAll()', '0', '15');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('getKeys()', '1', '15');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('setKeys()', '0', '15');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('getMap()', '0', '15');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Map', '1', '16');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('Set', '0', '16');
INSERT INTO `assessment_system`.`answer` (`description`, `correct`, `questionId`) VALUES ('List', '0', '16');


DELETE FROM `assessment_system`.`test` WHERE (`id` = '5');
DELETE FROM `assessment_system`.`test` WHERE (`id` = '10');

DELETE FROM `assessment_system`.`topic` WHERE (`id` = '3');
DELETE FROM `assessment_system`.`topic` WHERE (`id` = '4');
DELETE FROM `assessment_system`.`topic` WHERE (`id` = '5');

UPDATE `assessment_system`.`statistic` SET `questionId` = '1' WHERE (`id` = '5');
UPDATE `assessment_system`.`statistic` SET `questionId` = '2' WHERE (`id` = '6');
UPDATE `assessment_system`.`statistic` SET `questionId` = '3' WHERE (`id` = '7');
UPDATE `assessment_system`.`statistic` SET `questionId` = '4', `userId` = '3' WHERE (`id` = '8');
UPDATE `assessment_system`.`statistic` SET `questionId` = '5' WHERE (`id` = '9');
UPDATE `assessment_system`.`statistic` SET `questionId` = '7' WHERE (`id` = '11');
UPDATE `assessment_system`.`statistic` SET `questionId` = '8' WHERE (`id` = '12');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('13', '2020-01-12 10:41:48', '1', '5', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('14', '2020-01-12 10:41:48', '0', '6', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('15', '2020-01-12 10:41:48', '1', '7', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('16', '2020-01-12 10:41:48', '1', '8', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('17', '2020-01-12 10:41:48', '1', '9', '3');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('18', '2020-01-12 10:41:48', '1', '10', '3');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('19', '2020-01-12 10:41:48', '1', '11', '3');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('20', '2020-01-12 10:41:48', '0', '12', '3');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('21', '2020-01-12 10:41:48', '1', '13', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('22', '2020-01-12 10:41:48', '1', '14', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('23', '2020-01-12 10:41:48', '1', '15', '2');
INSERT INTO `assessment_system`.`statistic` (`id`, `date`, `correct`, `questionId`, `userId`) VALUES ('24', '2020-01-12 10:41:48', '1', '16', '2');
