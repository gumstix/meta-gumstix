from shutil import copy
from os import path, mkdir, listdir
from utils import mount
from menu import Menu, MenuItem

def select_card(only_valid=False):
	m = Menu()
	m.query = 'Please Select your Micro SD card'
	m.items = []
	cards = detect_cards()
	for card in cards:
		if not only_valid or card.is_created():
			m.items.append(MenuItem(card.device, card))
	return m.show()

def detect_cards():
	devices = []
	for device in listdir('/dev/disk/by-id/'):
		if device[:4] == 'usb-' and not device[-5:-1] == 'part':
			devices.append(Sdcard(path.realpath('/dev/disk/by-id/'+device)))
	return sorted(devices, key=lambda device: device.device)

class Sdcard:
	def __init__(self, device):
		self.mount_point = '/media'
		self.boot_name = 'boot'
		self.filesystem_name = 'rootfs'
		self.device = device
		
	def create(self):
		from utils import sudo_call
		sudo_call('./tools/mkcard.sh', [self.device, self.boot_name, self.filesystem_name])

	def is_created(self):
		return path.exists(self.device+'1') and path.exists(self.device		+'2')

	def mount(self):
		mount(self.device + '1', path.join(self.mount_point, self.boot_name))
		mount(self.device + '2', path.join(self.mount_point, self.filesystem_name))

	def copy_to_boot(self, file, location = ''):
		self.copy_helper(file, location, self.boot_name);

	def copy_to_filesystem(self, file, location = ''):
		self.copy_helper(file, location, self.filesystem_name, location);

	def get_boot_dir(self):
		return path.join(self.mount_point, self.boot_name)

	def get_filesystem_dir(self):
		return path.join(self.mount_point, self.filesystem_name)

	def copy_helper(self, file, location, partition):
		of = path.join(self.mount_point, partition, location)
		if path.isdir(file):
			of = path.join(of, path.basename(file))
		copy(file, of)
