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
KERNEL_DEVICETREE_pepper = "am335x-pepper.dtb"


LINUX_VERSION = "3.17"
LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.17:"

S = "${WORKDIR}/git"

# v3.17.8 = bc15d4627aa8f562a1c5ec9d84076b8db25bab31
SRCREV = "bc15d4627aa8f562a1c5ec9d84076b8db25bab31"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;nocheckout=1;branch=linux-3.17.y \
    file://0001-ARM-Gumstix-DuoVero-Bind-vdac-regulator-to-hdmi-node.patch \
    file://0002-ARM-dts-configure-regulators-for-Gumstix-Pepper.patch \
    file://0003-Invert-the-y-axis-of-the-touchscreen-for-pepper.patch \
    file://0004-Add-driver-for-Newhaven-FT5X0X-multitouch-controller.patch \
    file://0005-Gumstix-Overo-Arbor43C-Device-Tree.patch \
    file://0006-ARM-dts-Improve-U-Boot-and-DTS-compatibility-for-LCD.patch \
    file://0007-ARM-dts-Correct-maximum-SPI-clock-speed-for-lcd35.patch \
    file://0008-Enable-wilink8-wifi-chip-for-Overo.patch \
    file://0009-Enable-wilink8-bluetooth-chip-for-Overo.patch \
    file://0010-omap3-dts-Add-DTS-for-Gumstix-TobiDuo-expansion-boar.patch \
    file://0011-Set-status-of-MCBSP2-for-audio-on-Overo-Storm.patch \
    file://0012-omap3-overo-Support-PoP-NAND.patch \
    file://0013-arm-DTS-Correct-audio-input-route-set-mic-bias.patch \
    file://0014-omap3-overo-Add-device-tree-for-Palo35-board.patch \
    file://0015-gpio-backlight-Discover-driver-during-boot-time.patch \
    file://0016-Fix-frequency-scaling-on-Gumstix-Pepper.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
