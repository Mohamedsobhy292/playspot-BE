
/* COUNTRY */
INSERT INTO country(name, code, created_at, updated_at) VALUES ('Germany', 'DE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

/* CITY */
INSERT INTO city(name, country_id, created_at, updated_at) VALUES ('Berlin', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO city(name, country_id, created_at, updated_at) VALUES ('Munich', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO city(name, country_id, created_at, updated_at) VALUES ('Dresden', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

/* ADDRESS */
 INSERT INTO address(street, zip_code, city_id, created_at, updated_at) VALUES ('hauptstrasse 14', 14199, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
 INSERT INTO address(street, zip_code, city_id, created_at, updated_at) VALUES ('westkreuz 15', 14199, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
 INSERT INTO address(street, zip_code, city_id, created_at, updated_at) VALUES ('ostkreuz 16', 14199, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO venue( name, city, address_id, created_at, updated_at) VALUES ('Padel berlin', 'berlin', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO venue( name, city, address_id, created_at, updated_at) VALUES ('Padel westkreuz', 'berlin', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO venue( name, city, address_id, created_at, updated_at) VALUES ('Padel ostkreuz', 'berlin', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO court_type(name, created_at, updated_at) VALUES ('FOOTBALL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court_type(name, created_at, updated_at) VALUES ('PADEL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court_type(name, created_at, updated_at) VALUES ('VOLLEY', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO booking_status(name, created_at, updated_at) VALUES ('PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO booking_status(name, created_at, updated_at) VALUES ('CONFIRMED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO booking_status(name, created_at, updated_at) VALUES ('CANCELED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 1, 1, 'hall 1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 1, 1, 'hall 2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 1, 1, 'hall 3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 2, 2, 'hall 1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 2, 2, 'hall 2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 2, 2, 'hall 3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 3, 2, 'hall 1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 3, 2, 'hall 2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO court(venue_id, court_type_id, name, created_at, updated_at) VALUES ( 3, 2, 'hall 3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
