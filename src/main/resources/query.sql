INSERT INTO role (id, description, name) 
	VALUES (1, "Administrador", "ADMIN"),
    (2, "Alumno", "STUDENT"), 
    (3, "Maestro", "TEACHER");

INSERT INTO social_service.type (description) VALUES 
( "Maestro General" ) , ( "Maestro Directo" ), ( "Coordinador" );


INSERT INTO user (id, password , username, name, status) VALUES     
(1, "$2a$04$GadYkTevg1barSBvddkGIetxQaWiuJ5wNu2HdjRR8iIgUf4eWUOmK", "admin", "Administrador", 1);

INSERT INTO user_roles (user_id, role_id) Values (1,1);

INSERT INTO user (id, password , username, name, status) VALUES     
(2, "$2a$04$i.oaOtDhKgFtGP9sdA9c6.dyYR0Pp5qU3ESwkjAa.uLDMue10Dsya", "alumno", "Alumno", 1);
INSERT INTO user_roles (user_id, role_id) Values (2,2);
INSERT INTO student (number, user_id) VALUES ("101", 2);

INSERT INTO user (id, password , username, name, status) VALUES     
(4, "$2a$04$i.oaOtDhKgFtGP9sdA9c6.dyYR0Pp5qU3ESwkjAa.uLDMue10Dsya", "alumno2", "Alumno 2", 1);
INSERT INTO user_roles (user_id, role_id) Values (4,2);
INSERT INTO student (number, user_id) VALUES ("174", 4);


INSERT INTO user (id, password , username, name, status) VALUES     
(3, "$2a$04$3.dnYsonIQxM77SgTbatwuKuyDKI/N1UGDKs9dRdVhl0NYwvOy0Ua", "maestro", "Maestro", 1);
INSERT INTO teacher (n_employee, user_id, type_id) VALUES ("10", 3, 1);
INSERT INTO user_roles (user_id, role_id) Values (3,3);

INSERT INTO subject (id, code, name, status)
VALUES (1, "m-1", "Matematicas 1", 1),
(2, "f-1", "Fisica 1", 1);

INSERT INTO school_group (id, status, students_qty, subject_id)
VALUES (1, 1, 1, 1), (2, 1, 5, 1),(3, 1, 10, 2);