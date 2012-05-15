from distros import StandardDistro
from tools import prompt
from os import path
from tools.utils import get_temp_path, http_download

class Gumstix(StandardDistro):
	def get_name(self):
		return 'Gumstix'
	def get_description(self):
		return 'This is the linux build released by Gumstix'
	def can_download(self):
		return True
	def download(self, files):
		build = 'current'
		flavour = prompt.choose('Please select a flavour', ['console', 'desktop', 'palmtop'])
		server = path.join('http://cumulus.gumstix.org/images/angstrom/developer/', build)
		file = 'omap3-' + flavour + '-image-overo.tar.bz2'
		remote = path.join(server, file)
		local = path.join(get_temp_path(), file)
		files['image'] = file
		http_download(remote, local)
		return files
