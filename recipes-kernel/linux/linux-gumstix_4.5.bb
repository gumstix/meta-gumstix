require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "poblano|overo|duovero|pepper"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_overo = " \
    omap3-overo-storm-tobi.dtb omap3-overo-tobi.dtb \
    omap3-overo-storm-tobiduo.dtb omap3-overo-tobiduo.dtb \
    omap3-overo-storm-chestnut43.dtb omap3-overo-chestnut43.dtb \
    omap3-overo-storm-alto35.dtb omap3-overo-alto35.dtb \
    omap3-overo-storm-arbor43c.dtb omap3-overo-arbor43c.dtb \
    omap3-overo-storm-arbor43c1.dtb omap3-overo-arbor43c1.dtb \
    omap3-overo-storm-arbor50c.dtb omap3-overo-arbor50c.dtb \
    omap3-overo-storm-arbor70c.dtb omap3-overo-arbor70c.dtb \
    omap3-overo-storm-gallop43.dtb omap3-overo-gallop43.dtb \
    omap3-overo-storm-palo43.dtb omap3-overo-palo43.dtb \
    omap3-overo-storm-palo35.dtb omap3-overo-palo35.dtb \
    omap3-overo-storm-summit.dtb omap3-overo-summit.dtb \
"
KERNEL_DEVICETREE_duovero = "omap4-duovero-parlor.dtb \
                             omap4-duovero-garret50c.dtb \
"
KERNEL_DEVICETREE_pepper = "am335x-pepper.dtb \
                            am335x-pepper-43r.dtb \
                            am335x-pepper-43c.dtb \
                            am335x-pepper-dvi.dtb \
"

KERNEL_DEVICETREE_poblano = "am437x-poblano.dtb"

LINUX_VERSION = "4.5"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-4.5:"

S = "${WORKDIR}/git"

# v4.4.y = b562e44f507e863c6792946e4e1b1449fbbac85d
SRCREV = "b53c4395fc43952cc0280d26ecbcc6a49015efa1"
SRC_URI = " \
    git://github.com/gumstix/linux.git;protocol=git;branch=yocto-v4.5.y \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
