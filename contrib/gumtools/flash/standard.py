from tools import extract
from flash import Flasher, bootloader
from shutil import copyfile

class Standard(Flasher):
	def prepare(self):
		self.sdcard.create()
		self.sdcard.mount()
		bootloader.setup(self.sdcard)

	def flash(self, tar_gz_file, uImage):
		extract.tar_gz(tar_gz_file, self.sdcard.filesystem_dir)
		self.sdcard.copy_to_boot(uImage, 'uImage')
		
