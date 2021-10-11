package at.htl.controller;

import at.htl.entity.JobOffer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class JobOfferRepository implements PanacheRepository<JobOffer> {

    @Transactional
    public void save(JobOffer jobOffer) {
        if (jobOffer != null) {
            if (jobOffer.isPersistent()) {
                this.remove(jobOffer);
            }
            persist(jobOffer);
        }
    }

    private void remove(JobOffer jobOffer) {
        delete(jobOffer);
    }

    public List<JobOffer> getJobOffersByCompanyId(Long id) {
        Query query = getEntityManager().createQuery("select j from JobOffer j where j.companyId=?1", JobOffer.class);
        query.setParameter(1, id);

        return (List<JobOffer>) query.getResultList().stream().collect(Collectors.toList());
    }
}
