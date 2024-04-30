INSERT INTO person (id, email, document_number, document_type, active)
VALUES (10, 'test1@test.com', 'PP123456', 'PASSPORT', true);

INSERT INTO person (id, email, document_number, document_type, active)
    VALUES (11, 'test3@test.com', '9877655', 'DRIVER_LICENSE', true);

INSERT INTO account (id, currency, person_id, number) VALUES (10, 'USD', 10, '11111');
INSERT INTO account (id, currency, person_id, number) VALUES (11, 'BYN', 10, '11112');
INSERT INTO account (id, currency, person_id, number) VALUES (12, 'USD', 11, '11113');
INSERT INTO account (id, currency, person_id, number) VALUES (13, 'BYN', 11, '11114');

INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (10, 'DEPOSITING', 99.99, 'USD', 10);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (11, 'WITHDRAWAL', 9.99, 'USD', 10);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (12, 'DEPOSITING', 12.95, 'BYN', 11);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (13, 'WITHDRAWAL', 3.59, 'BYN', 11);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (14, 'DEPOSITING', 100.99, 'USD', 12);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (15, 'WITHDRAWAL', 10, 'USD', 12);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (16, 'DEPOSITING', 16.32, 'BYN', 13);
INSERT INTO operation (id, opertype, amount, currency, account_id)
VALUES (17, 'WITHDRAWAL', 9.99, 'BYN', 13);


