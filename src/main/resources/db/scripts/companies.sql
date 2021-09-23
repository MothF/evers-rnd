INSERT INTO companies (id, name)
VALUES (1, 'Main Company')
ON CONFLICT (id) DO NOTHING ;

INSERT INTO companies (id, name)
VALUES (2, 'Another Company')
ON CONFLICT (id) DO NOTHING;
