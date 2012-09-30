require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

#DEFAULT_PREFERENCE = "-1"

#COMPATIBLE_MACHINE = "omap3-multi"
COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "3.5"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/linux.git;branch=omap-3.5;protocol=git \
	   file://defconfig \
           file://${BOOT_SPLASH} \
           "

