from shutil import copy
from os import path, mkdir, listdir
from utils import mount, sudo_call
from menu import Menu, MenuItem
from tools.command_line import CommandLine

def select_card(only_valid=False):
  m = Menu()
  m.query = 'Please Select your Micro SD card'
  m.items = []
  cards = detect_cards()
  if CommandLine.peek_next():
    device = CommandLine.get_next()
    return filter(lambda card: card.device == device, cards)[0]
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
    self.boot_name = 'boot'
    self.filesystem_name = 'rootfs'
    self.device = device
    
  def create(self):
    sudo_call('./tools/mkcard.sh', [self.device, self.boot_name, self.filesystem_name])

  def is_created(self):
    return path.exists(self.device+'1') and path.exists(self.device    +'2')

  def mount(self):
    self.boot_dir = mount(self.device + '1', self.boot_name)
    self.filesystem_dir = mount(self.device + '2', self.filesystem_name)

  def copy_to_boot(self, file, location = ''):
    self.copy_helper(file, location, self.boot_dir)

  def copy_to_filesystem(self, file, location = ''):
    self.copy_helper(file, location, self.filesystem_dir)

  def copy_helper(self, file, location, mount_point):
    of = path.join(mount_point, location)
    if path.isdir(file):
      of = path.join(of, path.basename(file))
    copy(file, of)
