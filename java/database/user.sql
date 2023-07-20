-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER scooby_doo_tcg_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO scooby_doo_tcg_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO scooby_doo_tcg_owner;

CREATE USER scooby_doo_tcg_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO scooby_doo_tcg_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO scooby_doo_tcg_appuser;
