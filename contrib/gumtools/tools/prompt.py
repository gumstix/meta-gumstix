from tools import menu

def ask(question, default=None):
	query = question
	if not default == None:
		query += ' (' + default + ')'
	answer = raw_input(query + ': ')
	return default if answer == '' else answer

def ask_yes_no(question, default=None):
	answer = None
	while (answer == None):
		query = question + ' (' + ('[y]' if default == True else 'y') + '/' + ('[n]' if default == False else 'n') + ')'
		raw = raw_input(query + ': ')
		if raw.lower() == 'y': answer = True
		elif raw.lower() == 'n': answer = False
		elif raw.lower() == '': answer = default
	return answer
			
def choose(question, options):
		m = menu.Menu()
		m.query = question
		for option in options:
			m.items.append(menu.MenuItem(option, option))
		return m.show()
