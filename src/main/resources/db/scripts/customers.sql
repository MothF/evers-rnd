INSERT INTO customers (id, name, company_id, address_street, address_home_number)
VALUES (1, 'First Customer', 1, 'Backer Street', 221)
ON CONFLICT (id) DO NOTHING;

INSERT INTO customers (id, name, company_id, address_street, address_home_number)
VALUES (2, 'Second Customer', 1, 'Backer st.', 221)
ON CONFLICT (id) DO NOTHING;

INSERT INTO customers (id, name, company_id, address_street, address_home_number)
VALUES (3, 'Third Customer', 1, 'Bleecker Street', 177)
ON CONFLICT (id) DO NOTHING;

INSERT INTO customers (id, name, company_id, address_street, address_home_number)
VALUES (4, 'Fourth Customer', 2, 'Another st.', 142)
ON CONFLICT (id) DO NOTHING;

INSERT INTO customers (id, name, company_id, address_street, address_home_number)
VALUES (5, 'Fifth Customer', 2, 'Another st.', 15)
ON CONFLICT (id) DO NOTHING;
