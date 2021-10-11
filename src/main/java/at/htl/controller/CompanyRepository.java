package at.htl.controller;

import at.htl.entity.Company;
import at.htl.entity.Senior;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;

import static io.quarkus.hibernate.orm.panache.Panache.getEntityManager;

public class CompanyRepository implements PanacheRepository<Company> {

    @Transactional
    public void save(Company company) {
        if (company != null) {
            if (company.isPersistent()) {
                this.remove(company);
            }
            persist(company);
        }
    }

    private void remove(Company company) {
        delete(company);
    }

    public Company getCompanyByEmailPassword(String email, String password) {
        Query query = getEntityManager().createQuery("select c from Company c where c.email=?1 and c.password=?2", Company.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        return (Company) query.getSingleResult();
    }
}
