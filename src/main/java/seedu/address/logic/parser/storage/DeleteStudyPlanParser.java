package seedu.address.logic.parser.storage;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.storage.DeleteCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteStudyPlanParser object.
 */
public class DeleteStudyPlanParser implements Parser<DeleteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the
     * DeleteStudyPlanCommand and returns an DeleteStudyPlanCommand object for
     * execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (!trimmedArgs.matches("-?\\d+")) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }
        Index studyPlanIndex = Index.fromZeroBased(Integer.parseInt(trimmedArgs));
        return new DeleteCommand(studyPlanIndex);
    }
}
