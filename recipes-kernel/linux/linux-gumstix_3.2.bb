require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"

# Patches for all releases in linux-3.2.y but PV specifies upstream base.
# Patches at: git://github.com/gumstix/linux.git;branch=omap-3.2
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-gumstix-3.2:"
PR = "r0"

S = "${WORKDIR}/git"

# v3.2.53 = 66c8d27b7084ecd4d7d17dc7a69e6f993f5a2549
SRCREV = "66c8d27b7084ecd4d7d17dc7a69e6f993f5a2549"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.2.y \
    file://0001-unionfs-Add-support-for-unionfs-2.5.10.patch \
    file://0002-Revert-omap2_mcspi-Flush-posted-writes.patch \
    file://0004-mtd-nand-Eliminate-noisey-uncorrectable-error-messag.patch \
    file://0005-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
    file://0006-video-add-timings-for-hd720.patch \
    file://0007-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
    file://0008-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
    file://0009-rtc-twl-add-support-for-backup-battery-recharge.patch \
    file://0010-soc-codecs-Enable-audio-capture-by-default-for-twl40.patch \
    file://0011-soc-codecs-twl4030-Turn-on-mic-bias-by-default.patch \
    file://0012-omap-mmc-twl4030-move-clock-input-selection-prior-to.patch \
    file://0013-Add-power-off-support-for-the-TWL4030-companion.patch \
    file://0014-Enabling-Hwmon-driver-for-twl4030-madc.patch \
    file://0015-omap-overo-Add-twl4030-madc-support.patch \
    file://0016-UNFINISHED-OMAP3-beagle-add-support-for-expansionboa.patch \
    file://0017-HACK-OMAP3-beagle-switch-to-GPTIMER1.patch \
    file://0018-omap-beagle-Add-support-for-1GHz.patch \
    file://0019-omap-overo-Add-support-for-spidev.patch \
    file://0020-omap-overo-Add-opp-init.patch \
    file://0021-omap3-Add-basic-support-for-720MHz-part.patch \
    file://0022-omap-overo-Add-support-for-Caspa-camera-module.patch \
    file://0023-mfd-twl4030-madc-Enable-ADC-channels-3-6.patch \
    file://0024-omap-overo-Restructure-code-to-allow-customization-v.patch \
    file://0025-omap-beagle-Don-t-register-madc-twice.patch \
    file://0026-ARM-OMAP-hsmmc-Fix-mux-for-non-OMAP-pins.patch \
    file://0027-cpufreq-OMAP-cleanup-for-multi-SoC-support-move-into.patch \
    file://0028-cpufreq-OMAP-Add-SMP-support-for-OMAP4.patch \
    file://0029-cpufreq-OMAP-Enable-all-CPUs-in-shared-policy-mask.patch \
    file://0030-cpufreq-OMAP-notify-even-with-bad-boot-frequency.patch \
    file://0031-cpufreq-OMAP-move-clk-name-decision-to-init.patch \
    file://0032-cpufreq-OMAP-deny-initialization-if-no-mpudev.patch \
    file://0033-cpufreq-OMAP-dont-support-freq_table.patch \
    file://0034-cpufreq-OMAP-only-supports-OPP-library.patch \
    file://0035-cpufreq-OMAP-put-clk-if-cpu_init-failed.patch \
    file://0036-cpufreq-OMAP-fix-freq_table-leak.patch \
    file://0037-cpufreq-OMAP-fixup-for-omap_device-changes-include-l.patch \
    file://0038-ARM-OMAP3-hwmod-data-disable-multiblock-reads-on-MMC.patch \
    file://0039-ARM-OMAP3-hwmod-data-add-the-ES3-MMC-hwmods-to-the-3.patch \
    file://0040-omap-opp-test-for-iva-before-attempting-to-set-iva-o.patch \
    file://0041-omap-mmc-Adjust-dto-to-eliminate-timeout-errors.patch \
    file://0042-omap3-fix-typos-in-Add-basic-support-for-720MHz-part.patch \
    file://0043-omap-dss2-Increase-pixel-clock-for-Samsung-LTE430WQ-.patch \
    file://0044-omap-overo-always-enable-TWL_COMMON_REGULATOR_VPLL2.patch \
    file://0045-omap-overo-don-t-overwrite-sdrc-setup-from-u-boot-sp.patch \
    file://0046-mmc-omap-add-sdio-interrupt-support.patch \
    file://0047-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch \
    file://0048-ARM-7670-1-fix-the-memset-fix.patch \
    file://defconfig \
    file://${BOOT_SPLASH} \
"
