/**
 * Creates a Command data structure
 * A Command can be null (empty), just a Command, or a Command with arguments
 */
data class Command(var commandType: CommandType? = null, var args: List<String>? = null)
