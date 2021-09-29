package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class SeniorRepository implements PanacheRepository<Senior> {

    @Transactional
    public void saveSenior(Senior senior) {
        if (senior != null && !isPersistent(senior)) {
            senior.persist();
        }
    }
}
