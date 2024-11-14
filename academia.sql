CREATE TABLE profesor(dni varchar(9) PRIMARY KEY NOT NULL,nombre varchar(16), apellidos varchar(32),direccion varchar(64), nacimiento date,CP vachar(5),telefono varchar(12));
CREATE TABLE alumno(dni varchar(9) PRIMARY KEY NOT NULL,nombre varchar(16), apellidos varchar(32),direccion varchar(64), nacimiento date,CP vachar(5),telefono varchar(12));
CREATE TABLE curso(cod_curso INTEGER PRIMARY KEY NOT NULL);
CREATE TABLE asignatura(cod_asignatura INTEGER PRIMARY KEY NOT NULL, nombre varchar(16), horas int, cod_curso INTEGER references curso, cod_profesor varchar(9) references profesor);
CREATE TABLE incidencia(cod_incidencia INTEGER PRIMARY KEY NOT NULL, descripcion text);
CREATE TABLE reporte(cod_asignatura INTEGER NOT NULL references asignatura, dni_alumno varchar(9) NOT NULL references alumno, cod_incidencia INTEGER NOT NULL references incidencia, PRIMARY KEY (cod_asignatura,dni_alumno,cod_incidencia));
CREATE TABLE aula(cod_aula INTEGER PRIMARY KEY NOT NULL, piso INTEGER, capacidad INTEGER);
CREATE TABLE matricula(dni_alumno varchar(9) NOT NULL references alumno, cod_asignatura INTEGER NOT NULL references asignatura, calificacion INTEGER,  PRIMARY KEY (dni_alumno, cod_asignatura));
CREATE TABLE asignacion(cod_aula INTEGER NOT NULL references aula, cod_asignatura INTEGER NOT NULL references asignatura, fecha date);

