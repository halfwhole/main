package seedu.address.logic.parser.datamanagement;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.TAG_PATTERN;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import seedu.address.logic.commands.datamanagement.ViewTaggedCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewTaggedCommand object
 */
public class ViewTaggedCommandParser implements Parser<ViewTaggedCommand> {

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Pattern... patterns) {
        return Stream.of(patterns).allMatch(pattern -> argumentMultimap.getValue(pattern).isPresent());
    }

    /**
     * Parses the given {@code String} of arguments in the context of the ViewTaggedCommand
     * and returns an ViewTaggedCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewTaggedCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, TAG_PATTERN);

        if (!arePrefixesPresent(argMultimap, TAG_PATTERN)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewTaggedCommand.MESSAGE_USAGE));
        }
        String module = ParserUtil.parseModule(argMultimap.getValue(TAG_PATTERN).get());
        return new ViewTaggedCommand(module);
    }

}
