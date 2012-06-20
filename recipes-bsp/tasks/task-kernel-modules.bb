DESCRIPTION = "Kernel Modules"
PR = "r1"

inherit gumstix-package

PACKAGE_ARCH = "${MACHINE_ARCH}"

INCLUDES = "\
  kernel-module-libertas-sdio \
  kernel-module-usb8xxx \
  kernel-module-mac80211 \
  kernel-module-lib80211 \
  omap3-pwm \
 "
