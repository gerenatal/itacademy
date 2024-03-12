SELECT persona.apellido1, persona.apellido2, persona.nombre FROM persona JOIN alumno_se_matricula_asignatura a ON p.id = a.id_alumno WHERE p.tipo = 'alumno';
