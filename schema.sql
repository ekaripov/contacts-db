CREATE TABLE photos (
	id serial NOT NULL,
	image bytea NOT NULL
);
ALTER TABLE photos ADD CONSTRAINT ix_photos_primary PRIMARY KEY(id);
CREATE TABLE person_category (
	id serial NOT NULL,
	title character varying(15) NOT NULL
);
ALTER TABLE person_category ADD CONSTRAINT ix_person_category_primary PRIMARY KEY(id);
CREATE TABLE contact_type (
	id serial NOT NULL,
	title character(10) NOT NULL
);
ALTER TABLE contact_type ADD CONSTRAINT ix_contacts_category_primary PRIMARY KEY(id);
CREATE TABLE authorities (
	authority character varying(64) NOT NULL,
	username character varying(50) NOT NULL
);
CREATE UNIQUE INDEX ix_authorities ON authorities (FK_users_username,authorities);
CREATE TABLE users (
	username character varying(50) NOT NULL,
	fullname character varying(64) NOT NULL,
	password character varying(50) NOT NULL,
	enabled boolean NOT NULL
);
ALTER TABLE users ADD CONSTRAINT ix_users_primary PRIMARY KEY(username);
CREATE TABLE person (
	id serial NOT NULL,
	firstname character varying(50),
	middlename character varying(50),
	lastname character varying(50),
	dateofbirth date,
	organization character varying(250),
	position character varying(250),
	created date NOT NULL,
	updated date NOT NULL,
	deleted date,
	comment character varying(250),
	photo_id serial,
	category_id serial NOT NULL
);
ALTER TABLE person ADD CONSTRAINT ix_contacts_primary PRIMARY KEY(id);
CREATE UNIQUE INDEX ix_person_photo ON person (id,fk_photos_id);
CREATE TABLE contacts (
	id serial NOT NULL,
	text character varying(64) NOT NULL,
	comment character varying(64),
	type_id serial NOT NULL,
	person_id serial NOT NULL
);
ALTER TABLE contacts ADD CONSTRAINT ix_contacts_primary PRIMARY KEY(id);
CREATE TABLE event_types (
	id serial NOT NULL,
	title character varying(50) NOT NULL,
	history_id serial
);
ALTER TABLE event_types ADD CONSTRAINT ix_event_types_primary PRIMARY KEY(id);
CREATE TABLE history_types (
	id serial NOT NULL,
	title character varying(50) NOT NULL,
	show_in_list boolean NOT NULL
);
ALTER TABLE history_types ADD CONSTRAINT ix_history_types_primary PRIMARY KEY(id);
CREATE TABLE events (
	id serial NOT NULL,
	person_id serial,
	username character varying(50) NOT NULL,
	description character varying(250),
	eventdate date NOT NULL,
	type_id serial NOT NULL
);
ALTER TABLE events ADD CONSTRAINT ix_events_primary PRIMARY KEY(id);
CREATE TABLE history (
	id serial NOT NULL,
	username character varying(50),
	person_id serial NOT NULL,
	type_id serial NOT NULL,
	description character varying(250),
	date date NOT NULL
);
ALTER TABLE history ADD CONSTRAINT ix_history_primary PRIMARY KEY(id);
CREATE TABLE tags (
	person_id serial NOT NULL,
	title character varying(50) NOT NULL
);
CREATE UNIQUE INDEX ix_tags_id ON tags (person_id);
ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_photos_person FOREIGN KEY (photo_id) REFERENCES photos(id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_category_person FOREIGN KEY (category_id) REFERENCES person_category(id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE contacts ADD CONSTRAINT fk_cotact_type FOREIGN KEY (type_id) REFERENCES contact_type(id) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE contacts ADD CONSTRAINT fk_person_contacts FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE event_types ADD CONSTRAINT fk_history_event_types FOREIGN KEY (history_id) REFERENCES history_types(id) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE events ADD CONSTRAINT fk_event_type FOREIGN KEY (type_id) REFERENCES event_types(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE events ADD CONSTRAINT fk_events_users FOREIGN KEY (username) REFERENCES users(username) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE events ADD CONSTRAINT fk_events_person FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE history ADD CONSTRAINT fk_history_type FOREIGN KEY (type_id) REFERENCES history_types(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE history ADD CONSTRAINT fk_history_person FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE history ADD CONSTRAINT fk_history_users FOREIGN KEY (username) REFERENCES users(username) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE tags ADD CONSTRAINT fk_person_tag FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ON UPDATE CASCADE;
