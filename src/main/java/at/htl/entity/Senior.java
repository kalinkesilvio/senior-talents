package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Entity
public class Senior extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    public Senior() {}

    public Senior(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Senior(String email, String password, File resume, String descr, String skillDescr, String interestDescr, String jobField, String jobBranche, String preferableWork, Date retirement, int hoursPerWeek, boolean commute, Address address) {
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
        this.address = address;
    }

    public long getSeniorId() {
        return seniorId;
    }

    public void setSeniorId(long seniorId) {
        this.seniorId = seniorId;
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

    public File getResume() {
        return resume;
    }

    public void setResume(File resume) {
        /*byte[] pdfData = new byte[(int) resume.length()];

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(resume));
            dis.readFully(pdfData);  // read from file into byte[] array
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myConnectionString =
                "jdbc:mysql://localhost:3307/mydb";
        dbConnection = DriverManager.getConnection(myConnectionString, "root", "whatever");
        PreparedStatement ps = dbConnection.prepareStatement(
                "INSERT INTO project (" +
                        "filename, " +
                        "pdf_file " +
                        ") VALUES (?,?)");
        ps.setString(1, "testpdf");
        ps.setBytes(2, pdfData);  // byte[] array
        ps.executeUpdate();
        this.resume = resume;*/
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSkillDescr() {
        return skillDescr;
    }

    public void setSkillDescr(String skillDescr) {
        this.skillDescr = skillDescr;
    }

    public String getInterestDescr() {
        return interestDescr;
    }

    public void setInterestDescr(String interestDescr) {
        this.interestDescr = interestDescr;
    }

    public String getJobField() {
        return jobField;
    }

    public void setJobField(String jobField) {
        this.jobField = jobField;
    }

    public String getJobBranche() {
        return jobBranche;
    }

    public void setJobBranche(String jobBranche) {
        this.jobBranche = jobBranche;
    }

    public String getPreferableWork() {
        return preferableWork;
    }

    public void setPreferableWork(String preferableWork) {
        this.preferableWork = preferableWork;
    }

    public Date getRetirement() {
        return retirement;
    }

    public void setRetirement(Date retirement) {
        this.retirement = retirement;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public boolean isCommute() {
        return commute;
    }

    public void setCommute(boolean commute) {
        this.commute = commute;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Senior{" +
                "seniorId=" + seniorId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", resume=" + resume +
                ", descr='" + descr + '\'' +
                ", skillDescr='" + skillDescr + '\'' +
                ", interestDescr='" + interestDescr + '\'' +
                ", jobField='" + jobField + '\'' +
                ", jobBranche='" + jobBranche + '\'' +
                ", preferableWork='" + preferableWork + '\'' +
                ", retirement=" + retirement +
                ", hoursPerWeek=" + hoursPerWeek +
                ", commute=" + commute +
                ", address=" + address +
                '}';
    }

    /*@Override
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
    }*/
}
