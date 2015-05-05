require recipes-kernel/linux/linux-yocto.inc

# This is an experimental kernel to support the Caspa camera on a
# devicetree-enabled kernel.  Note: it is necessary to manually
#  $ modprobe omap3-isp

COMPATIBLE_MACHINE = "overo"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_overo = " \
    omap3-overo-storm-tobi.dtb omap3-overo-tobi.dtb \
    omap3-overo-storm-chestnut43.dtb omap3-overo-chestnut43.dtb \
    omap3-overo-storm-alto35.dtb omap3-overo-alto35.dtb \
    omap3-overo-storm-gallop43.dtb omap3-overo-gallop43.dtb \
    omap3-overo-storm-palo43.dtb omap3-overo-palo43.dtb \
    omap3-overo-storm-summit.dtb omap3-overo-summit.dtb \
"

LINUX_VERSION = "3.18"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-caspa-3.18:"

S = "${WORKDIR}/git"

# v3.18.12 = 43f497a2035f3d4a2f766d20827c68e0437cdd58
SRCREV = "43f497a2035f3d4a2f766d20827c68e0437cdd58"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;nocheckout=1;branch=linux-3.18.y \
    file://0001-of-Add-a-function-to-read-64-bit-arrays.patch \
    file://0002-omap3isp-Fix-error-handling-in-probe.patch \
    file://0003-omap3isp-Rename-regulators-to-better-suit-the-Device.patch \
    file://0004-omap3isp-Separate-external-link-creation-from-platfo.patch \
    file://0005-omap3isp-Refactor-device-configuration-structs-for-D.patch \
    file://0006-omap3isp-Calculate-vpclk_div-for-CSI-2.patch \
    file://0007-omap3isp-DT-support-for-clocks.patch \
    file://0008-omap3isp-Platform-data-could-be-NULL.patch \
    file://0009-v4l-of-Read-data-lanes-endpoint-property.patch \
    file://0010-omap3isp-Add-support-for-the-Device-Tree.patch \
    file://0011-omap3isp-Add-DT-entry-for-OMAP-3.patch \
    file://0012-dt-bindings-Add-bindings-for-omap3isp.patch \
    file://0013-v4l-async-Call-subdev-driver-s-register-callback-bef.patch \
    file://0014-omap3isp-Correctly-set-QUERYCAP-capabilities.patch \
    file://0015-First-cut-at-caspa-support-with-devicetree.patch \
    file://0016-Pulling-in.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
