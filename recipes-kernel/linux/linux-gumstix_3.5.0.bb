require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.5.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=omap-3.5
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.5:"
#PR = "r0"

S = "${WORKDIR}/git"

# v3.5 = 28a33cbc24e4256c143dce96c7d93bf423229f92
SRCREV = "28a33cbc24e4256c143dce96c7d93bf423229f92"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.5.y \
    file://0001-Revert-omap2_mcspi-Flush-posted-writes.patch \
    file://0002-mtd-nand-Eliminate-noisey-uncorrectable-error-messag.patch \
    file://0003-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
    file://0004-video-add-timings-for-hd720.patch \
    file://0005-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
    file://0006-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
    file://0007-rtc-twl-add-support-for-backup-battery-recharge.patch \
    file://0008-soc-codecs-Enable-audio-capture-by-default-for-twl40.patch \
    file://0009-soc-codecs-twl4030-Turn-on-mic-bias-by-default.patch \
    file://0010-Add-power-off-support-for-the-TWL4030-companion.patch \
    file://0011-Enabling-Hwmon-driver-for-twl4030-madc.patch \
    file://0012-omap-overo-Add-twl4030-madc-support.patch \
    file://0013-omap-overo-Add-support-for-spidev.patch \
    file://0014-omap-overo-Add-opp-init.patch \
    file://0015-omap3-Add-basic-support-for-720MHz-part.patch \
    file://0016-omap-overo-Add-support-for-Caspa-camera-module.patch \
    file://0017-mfd-twl4030-madc-Enable-ADC-channels-3-6.patch \
    file://0018-omap-overo-Restructure-code-to-allow-customization-v.patch \
    file://0019-omap-beagle-Don-t-register-madc-twice.patch \
    file://0020-omap-overo-don-t-overwrite-sdrc-setup-from-u-boot-sp.patch \
    file://0021-mmc-omap-add-sdio-interrupt-support.patch \
    file://0022-v4l2-ctrls-Add-v4l2_ctrl_-gs-_ctrl_int64.patch \
    file://0023-mt9v032-Provide-pixel-rate-control.patch \
    file://0024-mt9v032-Provide-link-frequency-control.patch \
    file://0025-mt9v032-Export-horizontal-and-vertical-blanking-as-V.patch \
    file://0026-board-overo-Add-Caspa-camera-link-frequencies.patch \
    file://0027-ARM-OMAP-USB-Fixup-ehci_hcd_omap_probe-error-path.patch \
    file://0028-ARM-OMAP-USB-Fix-omap3xxx-EHCI-regression-caused-by-.patch \
    file://0029-drivers-rtc-rtc-twl.c-ensure-all-interrupts-are-disa.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"

