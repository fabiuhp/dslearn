INSERT INTO user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO user (name, email, password) VALUES ('Fabio', 'fabio@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp', 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg');
INSERT INTO offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z', 1);
INSERT INTO offer (edition, start_Moment, end_Moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2023-07-13T20:50:07.12345Z', 1);

INSERT INTO resource (title, description, position, img_Uri, resource_Type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 1, 1);
INSERT INTO resource (title, description, position, img_Uri, resource_Type, offer_id) VALUES ('Forum', 'Tire suas duvidas', 2, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 2, 1);
INSERT INTO resource (title, description, position, img_Uri, resource_Type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 0, 1);

INSERT INTO section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 1', 'Neste capitulo bla bla bla', 1, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 1, null);
INSERT INTO section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 2', 'Neste capitulo 2 bla bla bla', 1, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 1, 1);
INSERT INTO section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Capitulo 3', 'Neste capitulo 3 bla bla bla', 1, 'https://pessoascomdeficiencia.com.br/wp-content/uploads/2013/04/cursos-profissionalizantes-capacita%C3%A7%C3%A3o.jpg', 1, 2);

INSERT INTO enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2020-07-13T22:50:07.12345Z', null, true, false);
INSERT INTO enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, only_Update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2020-07-13T22:50:07.12345Z', null, true, false);

INSERT INTO lesson (title, position, section_id) VALUES ('Aula 01 do Capitulo 01', 1, 1);
INSERT INTO content (id, text_Content, video_Uri) VALUES (1, 'Texto de apoio', 'www.google.com');

INSERT INTO lesson (title, position, section_id) VALUES ('Aula 02 do Capitulo 01', 2, 1);
INSERT INTO content (id, text_Content, video_Uri) VALUES (2, 'Texto de apoio 2', 'www.google.com');

INSERT INTO lesson (title, position, section_id) VALUES ('Aula 03 do Capitulo 01', 3, 1);
INSERT INTO content (id, text_Content, video_Uri) VALUES (3, 'Texto de apoio 3', 'www.google.com');

INSERT INTO lesson (title, position, section_id) VALUES ('Tarefa 01 do Capitulo 01', 4, 1);
INSERT INTO task (id, description, question_Count, approval_Count, weight, due_Date) VALUES (4, 'Texto da tarefa', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2023-07-13T22:50:07.12345Z');

INSERT INTO lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);