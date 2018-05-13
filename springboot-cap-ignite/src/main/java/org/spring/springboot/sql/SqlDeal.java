package org.spring.springboot.sql;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.spring.springboot.entity.City;
import org.spring.springboot.entity.Person;
import org.spring.springboot.entity.PersonKey;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class SqlDeal {
    @Autowired
    private Ignite ignite;

    @PostConstruct
    public void initSql() {

        ddlTest();
        initData();
    }


    public void ddlTest() {
        try {
            // Register JDBC driver.
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            // Open JDBC connection.
            // Create database tables.
            try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
                 Statement stmt = conn.createStatement()) {
                // Create table based on REPLICATED template.
                stmt.executeUpdate("CREATE TABLE City (" +
                        " id LONG PRIMARY KEY, name VARCHAR) " +
                        " WITH \"template=replicated\"");
                // Create table based on PARTITIONED template with one backup.
                stmt.executeUpdate("CREATE TABLE Person (" +
                        " id LONG, name VARCHAR, city_id LONG, " +
                        " PRIMARY KEY (id, city_id)) " +
                        " WITH \"backups=1, affinityKey=city_id\"");
                // Create an index on the City table.
                stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");
                // Create an index on the Person table.
                stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");


            }
        } catch (ClassNotFoundException e) {
            log.error("异常", e);
        } catch (SQLException e) {
            log.error("异常", e);
        } finally {

        }
    }

    public void initData() {
        // Getting a reference to an underlying cache created for City table above.
        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");
        // Getting a reference to an underlying cache created for Person table above.
        IgniteCache<PersonKey, Person> personCache = ignite.cache("SQL_PUBLIC_PERSON");
        // Inserting entries into City.
        SqlFieldsQuery query = new SqlFieldsQuery(
                "INSERT INTO City (id, name) VALUES (?, ?)");
        cityCache.query(query.setArgs(1, "Forest Hill")).getAll();
        cityCache.query(query.setArgs(2, "Denver")).getAll();
        cityCache.query(query.setArgs(3, "St. Petersburg")).getAll();
        // Inserting entries into Person.
        query = new SqlFieldsQuery(
                "INSERT INTO Person (id, name, city_id) VALUES (?, ?, ?)");
        personCache.query(query.setArgs(1, "John Doe", 3)).getAll();
        personCache.query(query.setArgs(2, "Jane Roe", 2)).getAll();
        personCache.query(query.setArgs(3, "Mary Major", 1)).getAll();
        personCache.query(query.setArgs(4, "Richard Miles", 2)).getAll();
    }

    public void queryTest() {
        // Getting a reference to an underlying cache created for City table above.
        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");
        // Querying data from the cluster using a distributed JOIN.
        SqlFieldsQuery query = new SqlFieldsQuery("SELECT p.name, c.name " +
                " FROM Person p, City c WHERE p.city_id = c.id");
        FieldsQueryCursor<List<?>> cursor = cityCache.query(query);
        Iterator<List<?>> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            List<?> row = iterator.next();
            System.out.println(row.get(0) + ", " + row.get(1));
        }
    }


}
