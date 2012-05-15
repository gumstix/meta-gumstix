from distros import StandardDistro

class Angstrom(StandardDistro):
	def get_name(self):
		return 'Angstrom'
	def get_description(self):
		return 'Images can be downloaded from http://http://narcissus.angstrom-distribution.org/'
	def can_download(self):
		return False
