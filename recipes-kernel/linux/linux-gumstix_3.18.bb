require recipes-kernel/linux/linux-yocto.inc

COMPATIBLE_MACHINE = "overo|duovero|pepper"

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
    omap3-overo-storm-palo35.dtb omap3-overo-palo35.dtb \
    omap3-overo-storm-summit.dtb omap3-overo-summit.dtb \
"
KERNEL_DEVICETREE_duovero = "omap4-duovero-parlor.dtb"
KERNEL_DEVICETREE_pepper = "am335x-pepper.dtb \
                            am335x-pepper-dvi.dtb \
"


LINUX_VERSION = "3.18"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.18:"

S = "${WORKDIR}/git"

# v3.18.19 = 22a6cbf9f36ee3ae2878efcbdde33e6ca00b9c4b
SRCREV = "22a6cbf9f36ee3ae2878efcbdde33e6ca00b9c4b"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;nocheckout=1;branch=linux-3.18.y \
    file://0001-omap3isp-Fix-error-handling-in-probe.patch \
    file://0002-omap3isp-Rename-regulators-to-better-suit-the-Device.patch \
    file://0003-omap3isp-Separate-external-link-creation-from-platfo.patch \
    file://0004-omap3isp-Refactor-device-configuration-structs-for-D.patch \
    file://0005-omap3isp-Calculate-vpclk_div-for-CSI-2.patch \
    file://0006-omap3isp-DT-support-for-clocks.patch \
    file://0007-omap3isp-Platform-data-could-be-NULL.patch \
    file://0008-v4l-of-Read-data-lanes-endpoint-property.patch \
    file://0009-omap3isp-Add-support-for-the-Device-Tree.patch \
    file://0010-omap3isp-Add-DT-entry-for-OMAP-3.patch \
    file://0011-dt-bindings-Add-bindings-for-omap3isp.patch \
    file://0012-v4l-async-Call-subdev-driver-s-register-callback-bef.patch \
    file://0013-omap3isp-Correctly-set-QUERYCAP-capabilities.patch \
    file://0014-omap3isp-Add-missing-ioctls.patch \
    file://0015-omap-overo-Add-Caspa-camera-to-device-tree.patch \
    file://0016-ARM-dts-Correct-audio-input-route-set-mic-bias.patch \
    file://0017-ARM-dts-configure-regulators-for-Gumstix-Pepper.patch \
    file://0018-ARM-dts-Fix-frequency-scaling-on-Gumstix-Pepper.patch \
    file://0019-gpio-backlight-Discover-driver-during-boot-time.patch \
    file://0020-deb-pkg-install-dtbs-in-linux-image-package.patch \
    file://0021-ARM-Gumstix-DuoVero-Bind-vdac-regulator-to-hdmi-node.patch \
    file://0022-omap3-overo-Update-LCD-panel-names.patch \
    file://0023-omap3-dts-Add-DTS-for-Gumstix-TobiDuo-expansion-boar.patch \
    file://0024-omap3-overo-Enable-McBSP2-for-all-Overo-COMs.patch \
    file://0025-omap3-overo-Support-PoP-NAND.patch \
    file://0026-omap3-overo-Add-device-tree-for-Palo35-board.patch \
    file://0027-Enable-wilink8-wifi-chip-for-Overo.patch \
    file://0028-Enable-wilink8-bluetooth-chip-for-Overo.patch \
    file://0029-am335x-pepper-Add-support-for-Pepper-DVI.patch \
    file://0030-Do-not-disable-vusb3v1-regulator.patch \
    file://0031-overo-Enable-SDIO-interrupts-for-Wifi-interface.patch \
    file://0032-omap3-overo-Add-device-tree-for-Arbor43C-board.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
