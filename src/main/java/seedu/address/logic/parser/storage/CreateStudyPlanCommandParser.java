package seedu.address.logic.parser.storage;

import seedu.address.logic.commands.storage.CreateStudyPlanCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new CreateStudyPlanCommand object.
 */
public class CreateStudyPlanCommandParser implements Parser<CreateStudyPlanCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the
     * CreateStudyPlanCommand and returns an CreateStudyPlanCommand object for
     * execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public CreateStudyPlanCommand parse(String args) throws ParseException {
        String studyPlanName = args.trim();
        // commented out because we allow study plans with no name?
        /*
        if (studyPlanName.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateStudyPlanCommand.MESSAGE_USAGE));
        }
         */
        return new CreateStudyPlanCommand(studyPlanName);
    }
}
