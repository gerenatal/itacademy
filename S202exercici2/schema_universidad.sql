SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1 ASC, apellido2 ASC, nombre ASC;
SELECT nombre, apellido1, apellido2 FROM persona WHERE tipo = 'alumno' AND telefono IS NULL;
SELECT * FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
SELECT * FROM persona WHERE tipo = 'profesor' AND telefono IS NULL AND nif LIKE '%K';
SELECT * FROM asignatura WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS nombre_departamento FROM persona p, departamento d, profesor pr WHERE p.id = pr.id_profesor AND pr.id_departamento = d.id ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;
SELECT a.nombre AS asignatura, ce.anyo_inicio, ce.anyo_fin FROM persona p, alumno_se_matricula_asignatura asma, asignatura a, curso_escolar ce WHERE p.id = asma.id_alumno AND asma.id_asignatura = a.id AND asma.id_curso_escolar = ce.id AND p.nif = '26902806M';
SELECT DISTINCT d.nombre FROM departamento d, profesor pr, asignatura a, grado g WHERE d.id = pr.id_departamento AND pr.id_profesor = a.id_profesor AND a.id_grado = g.id AND g.nombre = '%Ingeniería Informática%';
SELECT DISTINCT d.nombre
FROM departamento d
JOIN profesor pr ON d.id = pr.id_departamento
JOIN asignatura a ON pr.id_profesor = a.id_profesor
JOIN grado g ON a.id_grado = g.id
WHERE g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
