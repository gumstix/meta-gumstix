from os import system, mkdir, path, chown, chmod, getenv
import urllib2
import shutil

mount_point = '/media'

def call(cmd, args=[]):
  cmdline = cmd + generate_args_string(args)
  print cmdline
  return system(cmdline)

def sudo_call(cmd, args=[]):
  args.insert(0, cmd)
  cmdline = 'sudo' + generate_args_string(args)
  print cmdline
  return system(cmdline)

def clear_dir(dir):
  sudo_call('rm', ['-r', path.join(dir, '*')])

def generate_args_string(args):
  arg_string = ''
  for arg in args:
    arg_string += ' "' + arg + '"'
  return arg_string

def http_download(webaddr, file, verbose=False):
  webfile = urllib2.urlopen(webaddr)
  output = open(file, 'wb')
  meta = webfile.info()
  file_size = int(meta.getheaders("Content-Length")[0])
  print "Downloading: %s Bytes: %s" % (webaddr, file_size)
  file_size_dl = 0
  block_sz = 8192
  while True:
      buffer = webfile.read(block_sz)
      if not buffer:
          break
      file_size_dl += len(buffer)
      output.write(buffer)
      status = r"%10d  [%3.2f%%]" % (file_size_dl, file_size_dl * 100. / file_size)
      status = status + chr(8)*(len(status)+1)
      print status,
  output.close()
  fix_permissions(file)

def get_save_path():
  save_path = path.join(getenv('HOME'), 'gumstix')
  if not path.isdir(save_path):
    mkdir(save_path)
    fix_permissions(save_path)
  return save_path

def get_temp_path():
  temp_path = path.join(get_save_path(), 'tmp')
  if not path.isdir(temp_path):
    mkdir(temp_path)
    fix_permissions(temp_path)
  return temp_path

def fix_permissions(path):
  import pwd
  pw = pwd.getpwnam(getenv("SUDO_USER"))
  chown(path, pw.pw_uid, pw.pw_gid)

def mount(device, name):
  mount_path = get_mount_dir(device)
  if mount_path: return mount_path
  mount_path = path.join(mount_point, name)
  if (path.exists(mount_path)):
	  shutil.rmtree(mount_path)
  mkdir(mount_path)
  chmod(mount_path, 0777)
  sudo_call('mount', [device, mount_path])
  return mount_path

def get_mount_dir(device):
  path = None
  mounts = open('/proc/mounts', 'r')
  while True:
    mount=mounts.readline()
    if mount == None or mount == '':
      break
    mount_device, mount_path = mount.split()[0:2]
    if device == mount_device:
      path = mount_path
      break
  mounts.close()
  return path
