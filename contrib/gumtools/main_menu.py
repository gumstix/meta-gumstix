from tools.menu import Menu, MenuItem
from tools import sdcard
from tools.prompt import ask_yes_no
from flash.standard import Standard
import distros
from tools.command_line import CommandLine

m = Menu()
m.query = 'Please choose a task'
m.items.append(MenuItem('Install a distro to Micro SD', 'install'))
m.items.append(MenuItem('Exit', ''))
option = m.show()
if option == 'install':
  while True:
    distro = distros.select()
    if CommandLine.peek_next():
      break
    print distro.get_description()
    print 'There is an option to download this distro' if distro.can_download() else 'You must have already downloaded an image in order to install this distro.'
    print '\n',
    if ask_yes_no('Would you like to install ' + distro.get_name() + '?', True):
      break
  distro.install(sdcard.select_card())
