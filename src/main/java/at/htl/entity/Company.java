package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Company extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    private String email;
    private String password;
    private String companyName;
    private String websiteUrl;
    private String branche;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private JobOffer jobOffer;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private ContactPerson contactPerson;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    public Company() {}

    public Company(String email, String password, String companyName) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
    }

    public Company(String email,
                   String password,
                   String companyName,
                   String websiteUrl,
                   String branche,
                   JobOffer jobOffer,
                   ContactPerson contactPerson,
                   Address address) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.websiteUrl = websiteUrl;
        this.branche = branche;
        this.jobOffer = jobOffer;
        this.contactPerson = contactPerson;
        this.address = address;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", branche='" + branche + '\'' +
                ", jobOffer=" + jobOffer +
                ", contactPerson=" + contactPerson +
                ", address=" + address +
                '}';
    }
}
