-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'scooby_doo_tcg';

DROP DATABASE scooby_doo_tcg;

DROP USER scooby_doo_tcg_owner;
DROP USER scooby_doo_tcg_appuser;
