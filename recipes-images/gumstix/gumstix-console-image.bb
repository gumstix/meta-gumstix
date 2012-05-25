DESCRIPTION = "The Gumstix console image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

EXTRA_IMAGE_FEATURES += "package-management"

IMAGE_INSTALL = "task-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_EXTRA_INSTALL ?= ""

AUDIO_INSTALL = " \
  alsa-utils \
  alsa-utils-aplay \
  alsa-utils-amixer \
 "
#  angstrom-zeroconf-audio \

FIRMWARE_INSTALL = " \
  kmod \
  marvell-sdio-fw \
  rt73-firmware \
  zd1211-firmware \
  linux-firmware \
 "

KERNEL_MODULE = " \
  kernel-module-libertas-sdio \
  kernel-module-usb8xxx \
  kernel-module-mac80211 \
  kernel-module-lib80211 \
 "

GLES_INSTALL = " \
 "
#  libgles-omap3 \

TOOLS_INSTALL = " \
  bash \
  bzip2 \
  ckermit \
  devmem2 \
  dhcp-client \
  dosfstools \
  fbgrab \
  fbset \
  fbset-modes \
  i2c-tools \
  mkfs-jffs2 \
  mtd-utils \
  nano \
  ntp ntpdate \
  openssh-misc \
  openssh-scp \
  openssh-ssh \
  omap3-writeprom \
  procps \
  socat \
  strace \
  sudo \
  syslog-ng \
  task-proper-tools \
  u-boot-utils \
  wpa-supplicant \
 "

IMAGE_INSTALL += " \
  ${AUDIO_INSTALL} \
  ${FIRMWARE_INSTALL} \
  ${KERNEL_MODULE} \
  ${GLES_INSTALL} \
  ${IMAGE_EXTRA_INSTALL} \
  ${TOOLS_INSTALL} \
 "
