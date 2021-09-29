package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.db.api.Assertions.assertThat;

class SeniorRepositoryTest {

    public static Source source = new Source("jdbc:postgresql://localhost:5433/db", "app", "app");

    @Test
    @Transactional
    void t01_Senior_saveToDb() {

        Table table = new Table(source, "senior");
        SeniorRepository seniorRepository = new SeniorRepository();
        Senior senior1 = new Senior("gustav.herzog@aon.at","asdf12");
        Senior senior2 = new Senior("jörg.kompost@gmail.com", "nagel");

        assertThat(table).exists().hasNumberOfRows(0);

        seniorRepository.saveSenior(senior1);
        seniorRepository.saveSenior(senior2);

        table = new Table(source, "senior");

        assertThat(table).hasNumberOfRows(1);
        assertThat(table)
                .row(1)
                .column(4)
                .value()
                .isEqualTo("gustav.herzog@aon.at");
    }
}