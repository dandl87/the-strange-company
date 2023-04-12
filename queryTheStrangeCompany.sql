/* CRUD the strange company */

/* C -> create */
INSERT INTO employee ( name, surname, role ) values ('Ilaria','Franceschini','Sistemista');
INSERT INTO employee ( name, surname, role ) values ('Mario','Finelli','Sistemista');
INSERT INTO employee ( name, surname, role ) values ('Marta','Borzillo','Developer');
INSERT INTO employee ( name, surname, role ) values ('Nicola','Milani','Developer');
INSERT INTO employee ( name, surname, role) values ('Giacomo','Romano','Quality Assurance');
INSERT INTO employee ( name, surname, role) values ('Stefano','Ucci','Quality Assurance');

/* R -> read */
SELECT * FROM employee;

/* U -> update */
Update employee set project_code ='Pj001' Where id=8;

/* D -> Delete */

Delete FROM employee WHERE id='1';
Delete FROM employee WHERE id='1';


/* C -> create */
INSERT INTO project ( code, name, ambito ) values ('Pj001','CodeForBreakfast','Blog Dinamico per sviluppatori');
INSERT INTO project ( code, name, ambito ) values ('Pj002','askFreddy','chatBot che simula il filosofo Nietzsche');

/* R -> read */
SELECT * FROM project;

/* U -> update */
Update project set titolo ='' Where code='';

/* D -> Delete */

Delete FROM project WHERE code=''; 