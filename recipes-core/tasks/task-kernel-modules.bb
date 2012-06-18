DESCRIPTION = "Kernel Modules"
PR = "r1"

inherit gumstix-task

RDEPENDS_${PN} = "\
  kernel-module-libertas-sdio \
  kernel-module-usb8xxx \
  kernel-module-mac80211 \
  kernel-module-lib80211 \
  omap3-pwm \
 "
