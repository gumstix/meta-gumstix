require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "duovero"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.6.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=omap-3.6
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.6:"

S = "${WORKDIR}/git"

# v3.6.11 = b2824f4e0990716407b0c0e7acee75bb6353febf
SRCREV = "b2824f4e0990716407b0c0e7acee75bb6353febf"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.6.y \
    file://0001-omap4-add-duovero-support.patch \
    file://0002-HACK-temporary-hack-to-use-cold-sw-reset-instead-of-.patch \
    file://0003-duovero-add-back-omap4_mux_init.patch \
    file://0004-perf-hard-code-NO_LIBPERL-NO_LIBPYTHON.patch \
    file://0005-duovero-invert-sense-of-card-detect-signal.patch \
    file://0006-Add-delay-to-the-smsc911x-driver.patch \
    file://0007-Support-duovero-zephyr.patch \
    file://0008-Pull-in-some-HDMI-mux-fixes-from-Panda.patch \
    file://0009-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch \
    file://0010-ARM-7670-1-fix-the-memset-fix.patch \
    file://0011-duovero-disable-uAP.patch \
    file://0012-Power-off-routines-for-the-TWL6030.patch \
    file://0013-Bluetooth-btmrvl-release-lock-while-waiting-for-fw.patch \
    file://0014-Bluetooth-btmrvl-report-error-if-verify_fw_download.patch \
    file://0015-ARM-OMAP4-TWL-mux-sys_drm_msecure-as-output-for-PMIC.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
