DESCRIPTION = "Packages included in the gumstix console image"
PR = "r1"

inherit gumstix-package

INCLUDES = "\
  bzip2 \
  ckermit \
  devmem2 \
  dhcp-client \
  dosfstools \
  fbgrab \
  fbset \
  i2c-tools \
  mkfs-jffs2 \
  mtd-utils \
  nano \
  ntp ntpdate \
  openssh-misc \
  openssh-scp \
  openssh-ssh \
  openssh-sshd \
  omap3-writeprom \
  socat \
  strace \
  sudo \
  wpa-supplicant \
 "
