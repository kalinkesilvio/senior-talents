package at.htl.entity;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
public class Senior {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seniorId;

    private String email;
    private String password;
    private File resume;
    private String descr;
    private String skillDescr;
    private String interestDescr;
    private String jobField;
    private String jobBranche;
    private String preferableWork;
    private Date retirement;
    private int hoursPerWeek;
    private boolean commute;

    @JoinColumn
    @ManyToOne
    private Address address;

    public Senior() {}

    public Senior(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Senior(Long seniorId, String email, String password, File resume, String descr, String skillDescr, String interestDescr, String jobField, String jobBranche, String preferableWork, Date retirement, int hoursPerWeek, boolean commute) {
        this.seniorId = seniorId;
        this.email = email;
        this.password = password;
        this.resume = resume;
        this.descr = descr;
        this.skillDescr = skillDescr;
        this.interestDescr = interestDescr;
        this.jobField = jobField;
        this.jobBranche = jobBranche;
        this.preferableWork = preferableWork;
        this.retirement = retirement;
        this.hoursPerWeek = hoursPerWeek;
        this.commute = commute;
    }

    @Override
    public String toString() {
        String seniorBuilder = "{ ";

        seniorBuilder += "seniorId: " + seniorId;

        if (email != null) {
            seniorBuilder += ", email: " + email;
        } else if (password != null) {
            seniorBuilder += ", password: " + password;
        } else if (resume != null) {
            seniorBuilder += ", resume: " + resume;
        } else if (descr != null) {
            seniorBuilder += ", descr: " + descr;
        } else if (skillDescr != null) {
            seniorBuilder += ", skillDescr: " + skillDescr;
        } else if (interestDescr != null) {
            seniorBuilder += ", interestDescr: " + interestDescr;
        } else if (jobField != null) {
            seniorBuilder += ", jobField: " + jobField;
        } else if (jobBranche != null) {
            seniorBuilder += ", jobBranche: " + jobBranche;
        } else if (preferableWork != null) {
            seniorBuilder += ", preferableWork: " + preferableWork;
        } else if (retirement != null) {
            seniorBuilder += ", retirement: " + retirement;
        } else if (hoursPerWeek != 0) {
            seniorBuilder += ", hoursPerWeek: " + hoursPerWeek;
        }

        seniorBuilder += ", " + commute + " }";

        return seniorBuilder;
    }
}
