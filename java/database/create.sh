#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=scooby_doo_tcg
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data-instances.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data-claimed.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
