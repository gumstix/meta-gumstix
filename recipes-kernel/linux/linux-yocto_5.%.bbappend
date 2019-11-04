COMPATIBLE_MACHINE += "poblano|overo|duovero|pepper|"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

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
    omap3-overo-storm-swd-jtag.dtb \
    omap3-overo-storm-thumbo.dtb omap3-overo-thumbo.dtb \
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

LINUX_VERSION_EXTENSION = "-custom"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto-5.0:${THISDIR}/files:"

SRC_URI += " \
    file://0001-Add-V4L2-ioctls-for-the-OMAP3-ISP-to-report-the-vide.patch \
    file://0002-omap-overo-Add-Caspa-camera-to-device-tree.patch \
    file://0003-Add-a-working-defconfig-for-overo.patch \
    file://0004-omap3-overo-Add-device-tree-for-Arbor43C-board.patch \
    file://0005-omap3-overo-Add-device-tree-for-Arbor50C-and-70C.patch \
    file://0006-omap3-overo-Update-device-tree-for-Arbor-expansion-b.patch \
    file://0007-Add-power-off-support-for-the-TWL4030-6030.patch \
    file://0008-Add-swd-jtag-device-tree-for-overo-storm.patch  \
    file://0009-Add-device-tree-for-thumbo.patch  \
    file://0010-Add-pepper-duovero-garret50c-poblano-dtb-files.patch \
    file://0011-overo-Enable-SDIO-interrupts-for-Wifi-interface.patch \
    file://0012-Overo-Fix-up-WiLink-Support.patch \
    file://0013-Add-dts-for-pepper-devices.patch \
    file://0014-Fix-duovero-and-add-support-for-duovero-garret50c.patch \
    file://0015-Add-Overo-support-for-Tiny-Caspa-and-fix-dts-for-ove.patch \
    file://0016-Fix-whoami-registers-for-the-st-mag-and-accel-sensor.patch \
    file://0017-Add-input-driver-for-accel-mag-and-gryo-sensors.patch \
    file://0018-Add-ov7692-camera-driver-support.patch \
    file://0019-tfp410-RGB888-not-RGB565-color-mapping-for-botball.patch \
    file://0020-Garret50C-Add-correct-edid-settings-for-800x480-disp.patch \
    file://0021-parlor-fix-HDMI-color-reverse-problem.patch \
    file://0022-Add-IMU-SPI-support-for-Arbor.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
