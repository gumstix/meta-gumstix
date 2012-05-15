from tools import extract, utils
from flash import Flasher

class Standard(Flasher):
	def prepare(self):
		pass

	def flash(self, gz_file):
		if gz_file[-3:-1] == '.gz':
			file = extract.gz(gz_file)
		else:
			file = gz_file
		utils.sudo_call('dd', ['bs=64k', 'if='+file, 'of='+self.sdcard.device])
		utils.sudo_call('sync')		
