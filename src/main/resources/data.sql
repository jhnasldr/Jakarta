INSERT INTO car(daily_cost, brand, model, plate_number) VALUES ('500', 'Volvo', 'V60', 'ABC123');
INSERT INTO car(daily_cost, brand, model, plate_number) VALUES ('500', 'Volkswagen', 'Golf', 'DEF456');
INSERT INTO car(daily_cost, brand, model, plate_number) VALUES ('500', 'Toyota', 'Corolla', 'GHI789');
INSERT INTO car(daily_cost, brand, model, plate_number) VALUES ('500', 'Ford', 'Focus', 'JKL012');
INSERT INTO car(daily_cost, brand, model, plate_number) VALUES ('500', 'Audi', 'A4', 'MNO345');*/

INSERT INTO customers(username, name, address, email, phone_number)
VALUES ('user5678', 'Emma Johnson', '123 Oak Street, Springfield, 98765', 'emma.johnson@email.com', '555-123-4567'),
       ('coolguy91', 'Maxwell Rodriguez', '456 Maple Avenue, Rivertown, 54321', 'max.rodriguez@email.com', '555-987-6543'),
       ('jenny85', 'Jennifer Smith', '789 Pine Road, Hillcrest, 12345', 'j.smith@email.com', '555-555-1234'),
       ('codingmaster22', 'Lucas Nguyen', '321 Elm Drive, Lakeside, 67890', 'l.nguyen@email.com', '555-789-0123'),
       ('techwizard123', 'Sophia Patel', '987 Cedar Lane, Sunnyside, 13579', 'sophia.patel@email.com', '555-321-0987');

INSERT INTO booking(starts, ends, car_id, customer_id) VALUES ('2024-04-15 21:00', '2024-04-16 21:00', 5, 2);
INSERT INTO booking(starts, ends, car_id, customer_id) VALUES ('2024-04-01 12:00', '2024-04-06 12:00', 2, 4);
INSERT INTO booking(starts, ends, car_id, customer_id) VALUES ('2024-04-10 10:00', '2024-04-10 15:00', 1, 5);