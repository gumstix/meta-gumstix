from tools.menu import Menu, MenuItem
from tools import prompt
from os import path

def select():
	distro_list = ['gumstix', 'linaro', 'arch', 'angstrom']
	m = Menu()
	m.query = 'Which distro would you like to install'
	for distro in distro_list:
		klass_name = distro[0].upper()+distro[1:]
		klass = getattr(__import__(__name__ + '.' + distro, fromlist=[klass_name]), klass_name)()
		m.items.append(MenuItem(klass.get_name(), klass))
	return m.show()

class Distro:
	def get_name(self):
		return ''
	def get_description(self):
		return ''
	def do_install(self, files, sdcard):
		pass
	def files_needed(self):
		return []
	def can_download(self):
		return False
	def download(self, files):
		pass

	def install(self, sdcard):
		files = dict.fromkeys(self.files_needed())
		if not self.can_download() or prompt.ask_yes_no('Do you already have the OS files?', False):
			for key, file in files.iteritems():
				files[key] = self.get_file(key)
		else:
			files = self.download(files)
		self.do_install(files, sdcard)

	def get_file(self, name):
		while True:
			img_path = prompt.ask('Where is the ' + name + ' file located?')
			if path.isfile(img_path):
				break
			print 'The selected file does not exist'
		return img_path

class FlashedDistro(Distro):
	def files_needed(self):
		return ['image']
	def do_install(self, files, sdcard):
		self.flasher.sdcard = sdcard
		self.flasher.prepare()
		self.flasher.flash(files['image'], files['uImage'])

class StandardDistro(FlashedDistro):
	def files_needed(self):
		return ['uImage', 'image']
	def __init__(self):
		from flash.standard import Standard
		self.flasher = Standard()
	def do_install(self, files, sdcard):
		FlashedDistro.do_install(self, files, sdcard)

