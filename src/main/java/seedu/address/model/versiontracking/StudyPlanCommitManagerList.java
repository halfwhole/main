package seedu.address.model.versiontracking;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.studyplan.StudyPlan;
import seedu.address.model.versiontracking.exception.StudyPlanCommitManagerNotFoundException;

/**
 * Represents a list of {@code StudyPlanCommitManager}.
 */
public class StudyPlanCommitManagerList {
    private List<StudyPlanCommitManager> studyPlanCommitManagers;

    public StudyPlanCommitManagerList() {
        studyPlanCommitManagers = new ArrayList<>();
    }

    public StudyPlanCommitManagerList(List<StudyPlanCommitManager> managers) {
        studyPlanCommitManagers = managers;
    }

    public List<StudyPlanCommitManager> getStudyPlanCommitManagers() {
        return studyPlanCommitManagers;
    }

    /**
     * Gets the StudyPlanCommitManager according to its index in studyPlanCommitManagers list.
     */
    public StudyPlanCommitManager get(int index) {
        return studyPlanCommitManagers.get(index);
    }

    /**
     * Deletes the StudyPlanCommitManager according to the index given.
     */
    public void delete(int index) throws StudyPlanCommitManagerNotFoundException {
        boolean managerExists = false;
        for (StudyPlanCommitManager manager : studyPlanCommitManagers) {
            if (manager.getStudyPlanIndex() == index) {
                studyPlanCommitManagers.remove(manager);
                managerExists = true;
            }
        }
        if (!managerExists) {
            throw new StudyPlanCommitManagerNotFoundException();
        }
    }

    /**
     * Gets the StudyPlanCommitManager according to the index of the study plan.
     */
    public StudyPlanCommitManager getManagerByStudyPlan(StudyPlan studyPlan) {
        int studyPlanIndex = studyPlan.getIndex();

        StudyPlanCommitManager managerToReturn = getManagerByStudyPlanIndex(studyPlanIndex);

        if (managerToReturn == null) {
            // TODO: change the commit message.
            managerToReturn = new StudyPlanCommitManager(studyPlan, "empty commit");
        }

        return managerToReturn;
    }

    /**
     * Gets the StudyPlanCommitManager according to the given index. The result can be null.
     */
    public StudyPlanCommitManager getManagerByStudyPlanIndex(int index) {
        StudyPlanCommitManager managerToReturn = null;
        for (StudyPlanCommitManager manager : studyPlanCommitManagers) {
            if (manager.getStudyPlanIndex() == index) {
                managerToReturn = manager;
            }
        }
        return managerToReturn;
    }

    public void add(StudyPlanCommitManager manager) {
        studyPlanCommitManagers.add(manager);
    }

    /**
     * Method to check whether or not the manager already exists
     */
    public boolean managerAlreadyExists(StudyPlan studyPlan) {
        for (StudyPlanCommitManager manager : studyPlanCommitManagers) {
            if (manager.getStudyPlanIndex() == studyPlan.getIndex()) {
                return true;
            }
        }
        return false;
    }
}
