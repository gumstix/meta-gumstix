from tools.menu import Menu, MenuItem
from tools import prompt
from os import path
from tools.command_line import CommandLine

def select():
  distro_list = ['gumstix', 'linaro', 'arch', 'angstrom']
  m = Menu()
  m.query = 'Which distro would you like to install'
  for distro in distro_list:
    klass = init_distro(distro)
    m.items.append(MenuItem(klass.get_name(), distro))
  return init_distro(m.show())

def init_distro(distro):
  klass_name = distro[0].upper()+distro[1:]
  return getattr(__import__(__name__ + '.' + distro, fromlist=[klass_name]), klass_name)()

class Distro:
  def get_name(self):
    return ''
  def get_description(self):
    return ''
  def do_install(self, files, sdcard):
    pass
  def files_needed(self):
    return []
  def can_download(self):
    return False
  def download(self, files):
    pass

  def install(self, sdcard):
    params = self.files_needed()
    files = dict.fromkeys(params.values())
    nextCommand = CommandLine.peek_next()
    download = nextCommand and nextCommand[1:] == 'd'
    if not download:
      while CommandLine.peek_next():
        key = params[CommandLine.get_next()[1:]]
        files[key] = CommandLine.get_next()
    if None in files.values():
      if download or (self.can_download() and prompt.ask_yes_no('Do you need to download the OS files?', True)):
        files = self.download(files)
      else:
        for key, file in files.iteritems():
         files[key] = self.get_file(key)
    self.do_install(files, sdcard)

  def get_file(self, name):
    while True:
      img_path = prompt.ask('Where is the ' + name + ' file located?')
      if path.isfile(img_path):
        break
      print 'The selected file does not exist'
    return img_path

class FlashedDistro(Distro):
  def files_needed(self):
    return {'i': 'image'}
  def do_install(self, files, sdcard):
    self.flasher.sdcard = sdcard
    self.flasher.prepare()
    self.flasher.flash(files['filesystem'], files['uImage'])

class StandardDistro(FlashedDistro):
  def files_needed(self):
    return {'u': 'uImage', 'f': 'filesystem'}
  def __init__(self):
    from flash.standard import Standard
    self.flasher = Standard()
  def do_install(self, files, sdcard):
    FlashedDistro.do_install(self, files, sdcard)

