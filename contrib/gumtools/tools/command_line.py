from sys import argv

class CommandLine:
  params=argv[1:]
  current=0
  @staticmethod
  def peek_next():
    if len(CommandLine.params) > CommandLine.current:
      return CommandLine.params[CommandLine.current]
    else:
      return None
  @staticmethod
  def get_next():
    value = CommandLine.peek_next()
    CommandLine.current += 1
    return value
