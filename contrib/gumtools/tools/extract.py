from utils import sudo_call, clear_dir
from os import path

def tar_gz(in_file, out_dir, clear=True):
	if clear: clear_dir(out_dir)
	sudo_call('tar', ['xaf', path.expanduser(in_file), '-C', path.abspath(out_dir)])
	sudo_call('sync')

def gz(in_file):
	sudo_call('gunzip', [in_file])
	return in_file[:-3]
