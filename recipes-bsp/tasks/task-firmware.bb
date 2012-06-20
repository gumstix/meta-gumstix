DESCRIPTION = "Firmware for attached devices"
PR = "r1"

inherit gumstix-package

PACKAGE_ARCH = "all"

INCLUDES = "\
  kmod \
  marvell-sdio-fw \
  rt73-firmware \
  zd1211-firmware \
  linux-firmware \
 "
