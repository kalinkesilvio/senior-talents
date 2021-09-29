package at.htl.controller;

import at.htl.entity.Senior;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Senior> listAll() {
        return findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public Senior getSeniorById(Long id) {
        return findById(id);
    }

    public void remove(Senior senior) {
        delete(senior);
    }

    public Senior getSeniorWithEmailPassword(String email, String password) {

        Query query = getEntityManager().createQuery("select s from Senior s where s.email=?1 and s.password=?2", Senior.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        return (Senior) query.getSingleResult();
    }
}
