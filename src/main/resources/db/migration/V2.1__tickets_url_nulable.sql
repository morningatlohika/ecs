-- alter EVENTS

ALTER TABLE EVENTS ADD COLUMN NEW_TICKETS_URL VARCHAR(2000);
UPDATE EVENTS SET NEW_TICKETS_URL=TICKETS_URL;
ALTER TABLE EVENTS DROP COLUMN TICKETS_URL;
RENAME COLUMN EVENTS.NEW_TICKETS_URL TO TICKETS_URL;