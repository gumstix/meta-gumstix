require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

PV = "2012.10"
COMPATIBLE_MACHINE = "pepper"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/gumstix/u-boot.git;branch=omap-v2012.10;protocol=git"

SPL_BINARY = "MLO"

UBOOT_FORMAT = "img"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"
