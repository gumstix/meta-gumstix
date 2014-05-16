require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "pepper"

LINUX_VERSION = "3.14.4"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.14.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=pepper-3.14.4
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.14:"

S = "${WORKDIR}/git"

# v3.14.4 = 7261684765e4411dff5ec5ffbad52f5009a2941b
SRCREV = "7261684765e4411dff5ec5ffbad52f5009a2941b"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;nocheckout=1;branch=linux-3.14.y \
    file://0001-ARM-common-edma-Fix-xbar-mapping.patch \
    file://0002-reset-is_reset-and-clear_reset-api-s.patch \
    file://0003-dt-Fix-binding-typos-in-clock-names-and-interrupt-na.patch \
    file://0004-Add-devicetree-for-Gumstix-Pepper-SBC.patch \
    file://0005-HACK-Invert-the-y-axis-of-the-touchscreen-for-pepper.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
