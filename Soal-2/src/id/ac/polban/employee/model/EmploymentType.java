package id.ac.polban.employee.model;

public class EmploymentType {
    private String type;

    // Static Final (Konstanta)
    public static final EmploymentType FULL_TIME = new EmploymentType("Full-Time");
    public static final EmploymentType PART_TIME = new EmploymentType("Part-Time");
    public static final EmploymentType CONTRACT  = new EmploymentType("Contract");

    public EmploymentType(String type) {
        this.type = type;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() { return type; }
}
