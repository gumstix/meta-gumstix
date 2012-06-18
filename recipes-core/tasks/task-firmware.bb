DESCRIPTION = "Firmware for attached devices"
PR = "r1"

inherit gumstix-task

RDEPENDS_${PN} = "\
  kmod \
  marvell-sdio-fw \
  rt73-firmware \
  zd1211-firmware \
  linux-firmware \
 "
