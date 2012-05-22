from distros import StandardDistro
from os import path
from tools.utils import get_temp_path, http_download

class Arch(StandardDistro):
	def get_name(self):
		return 'Arch'
	def get_description(self):
		return 'A very basic but extendable linux distro'
	def can_download(self):
		return True
	def download(self, files):
		server = 'http://archlinuxarm.org/os'
		file = 'ArchLinuxARM-omap-smp-latest.tar.gz'
		remote = path.join(server, file)
		local = path.join(get_temp_path(), file)
		http_download(remote, local)
		files['image'] = local
		return files

	def files_needed(self):
		return {'i': 'image'}

	def do_install(self, files, sdcard):
		files['uImage'] = path.join(sdcard.get_boot_dir(), 'boot/uImage')
		super(Arch, self).do_install(files, sdcard)
		
