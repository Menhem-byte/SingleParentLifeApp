DROP SCHEMA IF EXISTS spldb;
CREATE SCHEMA IF NOT EXISTS spldb DEFAULT CHARACTER SET latin1;
USE spldb;

-- -----------------------------------------------------
-- Table spldb.singleparent
-- 1. This table is used to hold information of the users, namely single parents.
-- 2. When a user for any reason is frozen automatically or manually, including closing the account voluntarily, the is_active attribute will be set false accordingly. Thus the
-- user has no access to this app and invisible to all other users except the admin user, temporarily or permanently.
-- 3. The eamil will be used to perform authentication or receive notifications and should be unique.
-- 4. These information will be created and modified by the users when signing up and later on.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.singleparent (
  email VARCHAR(40)  NOT NULL UNIQUE,
  password VARCHAR(20)  NOT NULL,
  first_name VARCHAR(20) ,
  last_name VARCHAR(20) ,
  date_of_birth date,
  gender char(1) ,
  phone_number VARCHAR(20) ,
  occupation VARCHAR(20) ,
  about_user VARCHAR(500),
  crime_clearance_checked char(1),
  is_active char(1),
  photo longblob,
  PRIMARY KEY (email));

-- -----------------------------------------------------
-- Table spldb.child
-- 1. This table is used to hold information of the children of single parents.
-- 2. Each single parent can have one or more children, while each child can only belong to one single parent.
-- 3. When a child for any reason is no longer a valid child, including being ruling out by their parents, s/he will not be removed from the database, instead, the is_valid
-- attribute will be set to false.
-- 4. If the is_visible attribute is set to false, the child is only visible to the admin user, and invisible to all other users.
-- 5. These information will be created and modified by the parents when signing up and later on.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.child ( 
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  date_of_birth date NOT NULL,
  gender char(1) NOT NULL,
  is_visible char(1) NOT NULL,
  owner VARCHAR(40) NOT NULL,
  PRIMARY KEY (owner, first_name, last_name),
  CONSTRAINT fk_child_singleparent FOREIGN KEY (owner) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION);
  
-- -----------------------------------------------------
-- Table spldb.sma
-- 1. This table is used to hold single parents' social media accounts.
-- 2. Each single parent can have one or more accounts, while each account can only belong to one single parent.
-- 3. When an account is modified, or is not be expected to be seen by other users, it will not be removed, instead, the is_valid attribute will be set to false.
-- 4. If the is_visible attribute is set to false, the account is only visible to the admin user, and invisible to all other users.
-- 5. These accounts will be created and modified by the users when signing up and later on.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.sma (
  sma_category VARCHAR(20) NOT NULL,
  sma_name VARCHAR(40) NOT NULL,
  is_visible char(1) NOT NULL,
  owner VARCHAR(40) NOT NULL,
  PRIMARY KEY (sma_category, owner),
  CONSTRAINT fk_sma_singleparent FOREIGN KEY (owner) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION);
 
-- -----------------------------------------------------
-- Table spldb.organizer
-- 1. This table is used to hold information of the organizers of events.
-- 2. Each organizer can organize one or more event, while each event can only be organized by one major organizer.
-- 3. These information can only be created and modified by the admin user.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.organizer (
 organizer_email VARCHAR(40) NOT NULL,
  organizer_name VARCHAR(50) NOT NULL,
  contact_name VARCHAR(50) NOT NULL,
  organizer_description VARCHAR(500) NOT NULL,
  PRIMARY KEY (organizer_email));

-- -----------------------------------------------------
-- Table spldb.event
-- 1. This table is used to hold information of the events.
-- 2. Each organizer can organize one or more event, while each event can only be organized by one major organizer.
-- 3. If an event is cancelled, it will not be removed, instead, the is_valid attribute will be set to false.
-- 4. If the is_visible attribute is set to false, the event is only visible to the admin user, and invisible to all other users.
-- 5. These information can only be created and modified by the admin user.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.event (
  title VARCHAR(100) NOT NULL UNIQUE,
  start_time date NOT NULL,
  finish_time date NOT NULL,
  event_description VARCHAR(500) NOT NULL,
  owner VARCHAR(40) NOT NULL,
  is_visible char(1) NOT NULL,
  PRIMARY KEY (title),
  CONSTRAINT fk_event_organizer FOREIGN KEY (owner) REFERENCES spldb.organizer (organizer_email) ON DELETE NO ACTION ON UPDATE NO ACTION);
  
-- -----------------------------------------------------
-- Table spldb.message
-- 1. This table is used to hold messages between the users.
-- 2. Messages can only be visible to the users with the receiver_id.
-- 3. Once a message is withdrawn by the sender, no matter it is read or not , it will not be removed from the database, instead, the is_valid attribute will be set to false.
-- 4. If the is_visible attribute is set to false, the event is only visible to the admin user, and invisible to the receiver.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.message (
  sender VARCHAR(40) NOT NULL,
  receiver VARCHAR(40) NOT NULL,
  send_time date NOT NULL,
  content VARCHAR(500) NOT NULL,
  is_visible char(1) NOT NULL,
  PRIMARY KEY (sender, receiver, send_time),
  CONSTRAINT fk_sender_singleparent FOREIGN KEY (sender) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_receiver_singleparent FOREIGN KEY (receiver) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION); 
  
-- -----------------------------------------------------
-- Table spldb.friendship
-- 1. This table is used to hold information of friend relationships between users.
-- 2. When a user send a request to another user to make friends, the sender's id will be stored as owner_id while the opposite user's id as friend_id, and the status attribute 
-- will be set as 1, which means the request can be visible to the opposite user.
-- 3. The opposite has two options, namely refuse or accept, when s/he sees the request. If the request is refused, the status attribute will be turned to 0, which means the 
-- request will not pop up any longer, and if it is accepted, the status attribute will be turned to 2, which means the friendship is eestablished.
-- 4. At the same time when a request is accepted, another record will be stored into the database, in which the friend_id and owner_id swap. This means each friend relationship 
-- has two pieces of records and this way "select" queries may become easier.
-- 5. If anyone of a pair of friends cancells the relationship, the status attributes of the two related records will be turned to 0. 
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.friendship (
  friend VARCHAR(40) NOT NULL,
  owner VARCHAR(40) NOT NULL,
  status char(1) NOT NULL,
  PRIMARY KEY (friend, owner),
  CONSTRAINT fk_friend_singleparent FOREIGN KEY (friend) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_friend_owner_singleparent FOREIGN KEY (owner) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION);
  
-- -----------------------------------------------------
-- Table spldb.interest
-- 1. This table is used to hold interests for single parents.
-- 2. Each single parent can have none, one or multiple interests.
-- 3. These interests can be created and modified by the parents when signing up and later on.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.interest (
  interest_name VARCHAR(20) NOT NULL,
  owner VARCHAR(40) NOT NULL,
  PRIMARY KEY (interest_name, owner),
  CONSTRAINT fk_interest_singleparent FOREIGN KEY (owner) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION);
  
-- -----------------------------------------------------
-- Table spldb.address
-- 1. This table is used to hold addresses for single parents, events, and organizer. Each of them has one address and each address belongs to anyone of them.
-- 2. Once an address is modified, the old address will not be removed, instead, the is_valid attribute of the old one will be set to false.
-- 3. If the is_visible attribute is set to false, the address is only visible to the admin user, and invisible to all other users. 
-- 4. These information can be created and modified by both the regular users and admin user, depending on the types of the owner.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spldb.address (
  owner VARCHAR(40) NOT NULL,
  zipcode VARCHAR(20) NOT NULL,
  city VARCHAR(40) NOT NULL,
  province VARCHAR(40) NOT NULL,
  country VARCHAR(40) NOT NULL,
  is_valid char(1) NOT NULL,
  CONSTRAINT fk_address_singleparent FOREIGN KEY (owner) REFERENCES spldb.singleparent (email) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_address_organizer FOREIGN KEY (owner) REFERENCES spldb.organizer (organizer_email) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_address_event FOREIGN KEY (owner) REFERENCES spldb.event (title) ON DELETE NO ACTION ON UPDATE NO ACTION,
  PRIMARY KEY (owner));
  
INSERT INTO spldb.singleparent (email, password, first_name, last_name, date_of_birth, gender, phone_number, occupation, about_user, 
                                crime_clearance_checked, is_active)
VALUES ("amartinez@yahoo.com", "muygwapo", "Albert", "Martinez", "2000-01-01", "M","(403)123-4567", "Actor", "This is about me", "Y", "Y"); 

INSERT INTO spldb.singleparent (email, password, first_name, last_name, date_of_birth, gender, phone_number, occupation, about_user, 
                                crime_clearance_checked, is_active)
VALUES ("testuser@yahoo.com", "password", "John", "Smith", "1979-04-01", "M","(403)123-4562", "Actor", "This is about me", "Y", "Y"); 


--UPDATE spldb.singleparent SET password='password' where spldb.singleparent.parent_name = 'albmartinez26';
--UPDATE spldb.singleparent SET photo='load_file(C:/Users/815454/Desktop/system/pics/220746.jpg)'where spldb.singleparent.parent_name = 'albmartinez26';

--If Anca prefers name as one field, as in "Antonio Conde", shouldn't the "first_name" and "last_name" fields merge as a "name" instead?
--And I supppose "parent_name" is username, no?    