ALTER TABLE identity.user_addresses
    ADD COLUMN district VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN neighborhood VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN building_number VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN door_number VARCHAR(255) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN floor INTEGER,
    ADD COLUMN address_instructions VARCHAR(500),
    ADD COLUMN contact_first_name VARCHAR(50) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN contact_last_name VARCHAR(50) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN contact_phone VARCHAR(20) NOT NULL DEFAULT 'Unknown',
    ADD COLUMN latitude DOUBLE PRECISION,
    ADD COLUMN longitude DOUBLE PRECISION,
    ADD COLUMN is_default BOOLEAN NOT NULL DEFAULT FALSE;

-- After setting defaults to handle existing data, we can drop the defaults if we want, but it's optional
-- ALTER TABLE identity.user_addresses ALTER COLUMN district DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN neighborhood DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN building_number DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN door_number DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN contact_first_name DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN contact_last_name DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN contact_phone DROP DEFAULT;
-- ALTER TABLE identity.user_addresses ALTER COLUMN is_default DROP DEFAULT;
