package at.htl.controller;

import at.htl.entity.Address;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import static org.assertj.db.output.Outputs.output;

import javax.transaction.Transactional;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
class AddressRepositoryTest {

    final Source source = new Source("jdbc:postgresql://localhost:5433/db", "app", "app");

    @Test
    @Transactional
    void t01_saveAddressToDB() {
        AddressRepository addressRepository = new AddressRepository();
        Table table = new Table(source, "address");
        Address address = new Address("Linzauerstr.", "23", 4002, "Linz", "Austria", "Upperaustria");

        addressRepository.save(address);

        output(table).toConsole();

        assertThat(table)
                .hasNumberOfRows(1)
                .row(0)
                .column("city")
                .value()
                .isEqualTo("Linz");
    }

}