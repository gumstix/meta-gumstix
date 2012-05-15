from os import path
from tools.utils import http_download, get_temp_path, clear_dir

server = 'http://cumulus.gumstix.org/images/angstrom/factory/2011-08-30-1058/'
files = {
	'MLO':'mlo-updated',
	'u-boot.bin':'u-boot.bin',
}

def setup(sdcard):
	aquire()
	copy(sdcard)

def aquire():
	temp = get_temp_path()
	for com_file, serv_file in files.items():
		if not path.isfile(path.join(temp, com_file)):
			http_download(path.join(server, serv_file), path.join(temp, com_file))

def copy(sdcard):
	clear_dir(sdcard.get_boot_dir())
	temp = get_temp_path()
	for file in files:
		sdcard.copy_to_boot(path.join(temp, file))
