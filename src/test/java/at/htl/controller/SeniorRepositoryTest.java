package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.db.api.Assertions.assertThat;


@QuarkusTest
class SeniorRepositoryTest {

    public static Source source = new Source("jdbc:postgresql://localhost:5432/db", "app", "app");

    @Test
    @Transactional
    void t01_Senior_saveToDb() {

        Table table = new Table(source, "senior");
        SeniorRepository seniorRepository = new SeniorRepository();
        Senior senior1 = new Senior();

        senior1.setEmail("gustav.herzog@aon.at");
        senior1.setPassword("roboter123");

        assertThat(table).exists().hasNumberOfRows(0);

        seniorRepository.saveSenior(senior1);

        table = new Table(source, "senior");

        assertThat(table).hasNumberOfRows(1);
        assertThat(table)
                .row(1)
                .column(4)
                .value()
                .isEqualTo("gustav.herzog@aon.at");

    }

}