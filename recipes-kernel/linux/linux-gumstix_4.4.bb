require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "poblano"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_poblano = "am437x-poblano.dtb"

LINUX_VERSION = "4.4"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-4.4:"

S = "${WORKDIR}/git"

# v4.4 = afd2ff9b7e1b367172f18ba7f693dfb62bdcb2dc
SRCREV = "afd2ff9b7e1b367172f18ba7f693dfb62bdcb2dc"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;nocheckout=1;branch=linux-4.4.y \
    file://0001-am437x-poblano-Add-a-new-device-tree-for-Poblano.patch \
    file://0002-edt-ft5x06-Add-missing-ids-to-edt_ft5x06-id-table.patch \
    file://0003-am437x-poblano-Add-support-for-accel-magn-gyro.patch \
    file://0004-am437x-poblano-Correct-gpio-pins-for-captouch.patch \
    file://0005-HACK-Correct-the-double-pin-allocation-for-cap.-touc.patch \
    file://0006-am437x-poblano-Add-support-for-OV7692-Tiny-Caspa-cam.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
