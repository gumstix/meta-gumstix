class MenuItem:
	def __init__(self, text, value):
		self.text = text
		self.value = value

class Menu:
	def __init__(self):
		self.query = None
		self.items = []

	def show(self):
		print '\n',
		if not self.query == None:
			print self.query+':'
		i = 0
		for item in self.items:
			i += 1
			print '\t' + str(i) + ' - ' + item.text
		value = None
		while value == None or not (value.isdigit() and 0 < int(value) and int(value) < self.items.count):
			value = raw_input("Please select an option: ")
		return self.items[int(value)-1].value
