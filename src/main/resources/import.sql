
/* COUNTRY */
INSERT INTO country(name, code) VALUES ('Germany', 'DE');

/* CITY */
INSERT INTO city(name, country_id) VALUES ('Berlin', 1);
INSERT INTO city(name, country_id) VALUES ('Munich', 1);
INSERT INTO city(name, country_id) VALUES ('Dresden', 1);

/* ADDRESS */
 INSERT INTO address(street, zip_code, city_id) VALUES ('hauptstrasse 14', 14199, 1);
 INSERT INTO address(street, zip_code, city_id) VALUES ('hauptstrasse 15', 14199, 1);
 INSERT INTO address(street, zip_code, city_id) VALUES ('hauptstrasse 16', 14199, 1);


INSERT INTO venue( name, city, address_id) VALUES ('Padel berlin', 'berlin', 1);


INSERT INTO court_type(name) VALUES ('FOOTBALL');
INSERT INTO court_type(name) VALUES ('PADEL');
INSERT INTO court_type(name) VALUES ('VOLLEY');

INSERT INTO booking_status(name) VALUES ('PENDING');
INSERT INTO booking_status(name) VALUES ('CONFIRMED');
INSERT INTO booking_status(name) VALUES ('CANCELED');


INSERT INTO court(id, venue_id, court_type_id, name) VALUES (1, 1, 1, 'hall 1');
