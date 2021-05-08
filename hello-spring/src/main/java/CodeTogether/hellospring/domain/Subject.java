package CodeTogether.hellospring.domain;

public class Subject {

    private Long subject_id;
    private String subject_name;
    private String subject_pref;
    private String subject_desc;
    private Long subject_circle;

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_pref() {
        return subject_pref;
    }

    public void setSubject_pref(String subject_pref) {
        this.subject_pref = subject_pref;
    }

    public String getSubject_desc() {
        return subject_desc;
    }

    public void setSubject_desc(String subject_desc) {
        this.subject_desc = subject_desc;
    }

    public Long getSubject_circle() {
        return subject_circle;
    }

    public void setSubject_circle(Long subject_circle) {
        this.subject_circle = subject_circle;
    }
}
