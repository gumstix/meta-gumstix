from os import system, mkdir, path, chmod
import urllib2
import shutil

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

def get_temp_path():
  import os
  temp_path = path.join(os.getenv('HOME'), 'gumstix')
  if not path.isdir(temp_path):
    os.mkdir(temp_path)
  temp_path = path.join(temp_path, 'tmp')
  if not path.isdir(temp_path):
    os.mkdir(temp_path)
  return temp_path

def mount(device, point):
  if path.ismount(point):
    sudo_call('umount', [point])
  if (path.exists(point)):
	  shutil.rmtree(point)
  mkdir(point)
  chmod(point, 0777)
  sudo_call('mount', [device, point])
