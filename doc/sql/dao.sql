SELECT COUNT(*) FROM notas;

SELECT id, titulo, contenido, creado, modificado FROM notas ORDER BY id DESC LIMIT ? OFFSET ?;

SELECT id, titulo, contenido, creado, modificado FROM notas WHERE id = ? ORDER BY id DESC LIMIT 1;

INSERT INTO notas (titulo, contenido, creado, modificado) VALUES (?, ?, ?, ?);

UPDATE notas SET titulo = ?, contenido = ?, modificado = ? WHERE id = ?;

DELETE FROM notas WHERE id = ?;