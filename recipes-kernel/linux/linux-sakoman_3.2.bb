require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "omap3-multi"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "3.2"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/linux-omap-2.6.git;branch=omap-3.2;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

