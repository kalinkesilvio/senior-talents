package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class SeniorRepository implements PanacheRepository<Senior> {

    @Transactional
    public void save(Senior senior) {
        if (senior != null) {
            if (senior.isPersistent()) {
                this.remove(senior);
            }
            persist(senior);
        }
    }

    public void remove(Senior senior) {
        delete(senior);
    }
}
