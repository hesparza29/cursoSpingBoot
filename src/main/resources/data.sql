INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('Sherk', 90, 'ANIMADA', NULL, '2001-05-18', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('Inception', 148, 'CIENCIA_FICCION', NULL, '2010-07-16', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('Titanic', 195, 'DRAMA', 4.6, '1997-12-19', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('John Wick', 101, 'ACCION', NULL, '2014-10-24', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('El Conjuro', 112, 'TERROR', 3.0, '2013-07-19', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, calificacion, fecha_estreno, estado)
VALUES ('Coco', 105, 'ANIMADA', 4.7, '2017-10-27', 'D')
    ON CONFLICT (titulo) DO NOTHING;