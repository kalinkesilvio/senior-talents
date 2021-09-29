package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobOffer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobOfferId;

    private String title;
    private String descr;
    private String category;
    private String condition;
    private Double salary;

    public JobOffer() {}

    public JobOffer(Long jobOfferId, String title, String descr, String category, String condition, Double salary) {
        this.jobOfferId = jobOfferId;
        this.title = title;
        this.descr = descr;
        this.category = category;
        this.condition = condition;
        this.salary = salary;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "jobOfferId=" + jobOfferId +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", category='" + category + '\'' +
                ", condition='" + condition + '\'' +
                ", salary=" + salary +
                '}';
    }
}
