FROM mysql
ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes
ENV MYSQL_DATABASE=tailandczycy

COPY data/db_backup.sql /docker-entrypoint-initdb.d/db_backup.sql