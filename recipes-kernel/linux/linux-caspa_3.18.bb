require recipes-kernel/linux/linux-yocto.inc

# This is an experimental kernel to support the Caspa camera on a
# devicetree-enabled kernel.  Note: it is necessary to manually
#  $ modprobe omap3-isp

COMPATIBLE_MACHINE = "overo"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_overo = " \
    omap3-overo-storm-tobi.dtb omap3-overo-tobi.dtb \
    omap3-overo-storm-tobiduo.dtb omap3-overo-tobiduo.dtb \
    omap3-overo-storm-chestnut43.dtb omap3-overo-chestnut43.dtb \
    omap3-overo-storm-alto35.dtb omap3-overo-alto35.dtb \
    omap3-overo-storm-arbor43c.dtb omap3-overo-arbor43c.dtb \
    omap3-overo-storm-gallop43.dtb omap3-overo-gallop43.dtb \
    omap3-overo-storm-palo43.dtb omap3-overo-palo43.dtb \
    omap3-overo-storm-summit.dtb omap3-overo-summit.dtb \
"

LINUX_VERSION = "3.18"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-caspa-3.18:"

S = "${WORKDIR}/git"

# Based on v3.18.0-rc4 (f175bb6e91680eb92616bb7ec3ef151a3af2f026)
# from [1] as discussed [2].  Hosted on github with gumstix-specifc
# patches added.
#
# [1] git://vihersipuli.retiisi.org.uk/~sailus/linux.git
# [2] http://www.spinics.net/lists/linux-omap/msg114378.html
SRCREV = "9b020581e49139d26e798cdb3762b0f05fbf764a"
SRC_URI = " \
    git://github.com/gumstix/linux.git;nocheckout=1;branch=v3.18-caspa-wip \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
