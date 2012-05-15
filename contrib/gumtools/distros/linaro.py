from distros import Distro
from tools import prompt
from os import path
from tools.utils import get_temp_path, http_download
from flash import dd

class Linaro(Distro):
	def get_name(self):
		return 'Linaro'
	def get_description(self):
		return 'Linaro'
	def files_needed(self):
		return ['image']
	def can_download(self):
		return True
	def download(self, files):
		version = prompt.choose('Please select a version', ['12.03', '12.02', '12.01'])
		flavour = prompt.choose('Please select a flavour', ['alip', 'nano', 'ubuntu-desktop'])
		server = path.join('http://releases.linaro.org/images', version, 'oneiric', flavour)
		file = 'overo-' + flavour + '.img.gz'
		remote = path.join(server, file)
		local = path.join(get_temp_path(), file)
		http_download(remote, local)
		files['image']=local
		return files

	def do_install(self, files, sdcard):
		flasher = dd.Standard()
		flasher.sdcard=sdcard
		flasher.prepare()
		flasher.flash(files['image'])
		
