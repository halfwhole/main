package seedu.address.model.semester;

import java.util.List;

import seedu.address.model.module.Module;
import seedu.address.model.module.UniqueModuleList;

/**
 * Represents a semester of university for CS Undergraduate Students.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Semester {
    // Identity fields
    private SemesterName semesterName; // removed final keyword for the clone() method below

    // Data fields
    private UniqueModuleList modules = new UniqueModuleList(); // removed final keyword for the clone() method below
    private boolean isBlocked;
    private String reasonForBlocked;
    private boolean isExpanded = false;

    /**
     * SemesterName field must be present and not null.
     */
    public Semester(SemesterName semesterName) {
        this.semesterName = semesterName;
        isBlocked = false;
    }

    /**
     * This constructor is for {@code JsonAdaptedSemester} to create a semester with skeletal modules inside.
     */
    public Semester(SemesterName semesterName, boolean isBlocked,
                    String reasonForBlocked, List<Module> modules) {
        this.semesterName = semesterName;
        this.isBlocked = isBlocked;
        this.reasonForBlocked = reasonForBlocked;
        for (Module module : modules) {
            this.modules.add(module);
        }
    }

    public SemesterName getSemesterName() {
        return semesterName;
    }

    public UniqueModuleList getModules() {
        return modules;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getReasonForBlocked() {
        return reasonForBlocked;
    }

    public void setReasonForBlocked(String reasonForBlocked) {
        this.reasonForBlocked = reasonForBlocked;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public int getMcCount() {
        return modules.getMcCount();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void removeModule(String module) {
        modules.remove(module);
    }

    public boolean hasModule(String module) {
        return this.modules.contains(module);
    }

    // NOTE: this is for the GUI to use for Milestone 2
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(semesterName).append(":").append("\n");
        for (Module module : modules) {
            result.append(module.toString()).append("\n");
        }

        return result.toString();
    }

}
