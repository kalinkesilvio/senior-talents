package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class SeniorRepository implements PanacheRepositoryBase<Senior, Long> {

    @Inject
    EntityManager em;

    @Transactional
    public void saveSenior(Senior senior) {
        System.out.println(senior.toString());
        getEntityManager().merge(senior);
        if (senior != null && !isPersistent(senior)) {
            // senior.persist();
        }
    }

}
