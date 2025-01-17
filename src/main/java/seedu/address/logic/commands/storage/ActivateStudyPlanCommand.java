package seedu.address.logic.commands.storage;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.studyplan.exceptions.StudyPlanNotFoundException;

/**
 * Represents the command to activate a study plan of a given index.
 */
public class ActivateStudyPlanCommand extends Command {
    public static final String COMMAND_WORD = "activate";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Activates the study plan with the given index. "
            + "Parameters: "
            + "PLAN_INDEX \n"
            + "Example: " + COMMAND_WORD + " "
            + "3";

    public static final String MESSAGE_SUCCESS = "StudyPlan %1$d activated: %2$s";
    //todo: this?
    public static final String MESSAGE_NO_SUCH_STUDYPLAN = "The Study Plan with this index does not exists!";

    private final int studyPlanIndex;

    /**
     * Creates an ActivateStudyPlanCommand to activate the specified {@code StudyPlan} with the given index.
     */
    public ActivateStudyPlanCommand(int studyPlanIndex) {
        this.studyPlanIndex = studyPlanIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        try {
            model.activateStudyPlan(studyPlanIndex);
        } catch (StudyPlanNotFoundException e) {
            return new CommandResult(MESSAGE_NO_SUCH_STUDYPLAN);
        }

        String studyPlanName = model.getActiveStudyPlan().getTitle().toString();
        return new CommandResult(String.format(MESSAGE_SUCCESS, studyPlanIndex, studyPlanName),
                true, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ActivateStudyPlanCommand // instanceof handles nulls
                && studyPlanIndex == ((ActivateStudyPlanCommand) other).studyPlanIndex);
    }
}
