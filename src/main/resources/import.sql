INSERT INTO venue(address, name, city) VALUES ('hauptstrasse 14', 'Padel berlin', 'berlin');
INSERT INTO venue(address, name, city) VALUES ( 'kreuzberg 14', 'beach mitte', 'berlin');
INSERT INTO venue(address, name, city) VALUES ('OstKreuz 200', 'field kreuzberg', 'berlin');

INSERT INTO court_type(name) VALUES ('FOOTBALL');
INSERT INTO court_type(name) VALUES ('PADEL');
INSERT INTO court_type(name) VALUES ('VOLLEY');

INSERT INTO booking_status(name) VALUES ('PENDING');
INSERT INTO booking_status(name) VALUES ('CONFIRMED');
INSERT INTO booking_status(name) VALUES ('CANCELED');


INSERT INTO court(id, venue_id, court_type_id, name) VALUES (1, 1, 1, 'hall 1');

