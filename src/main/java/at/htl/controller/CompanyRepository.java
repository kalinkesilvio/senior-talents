package at.htl.controller;

import at.htl.entity.Company;
import at.htl.entity.Senior;

import javax.persistence.Query;
import javax.ws.rs.GET;

import static io.quarkus.hibernate.orm.panache.Panache.getEntityManager;

public class CompanyRepository {

    public Company getCompanyByEmailPassword(String email, String password) {
        Query query = getEntityManager().createQuery("select c from Company c where c.email=?1 and c.password=?2", Company.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        return (Company) query.getSingleResult();
    }
}
