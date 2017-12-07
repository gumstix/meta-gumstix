FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.4:"

SRC_URI += " \
    file://fragment.cfg \
    file://0001-Add-support-for-WiLink8-by-adding-the-sdio-wlink8-co.patch \
"

# Wilink8 Bluetooth occupies the ttyAMA0 port, now use ttyS0 for console
CMDLINE_raspberrypi-cm3 = "dwc_otg.lpm_enable=0 console=ttyS0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait"

# Adding configuration fragments into the defconf
# Then rpi layer will merge the defconfig with the machine config
# Original configme function in linux-raspberrypi.inc

do_kernel_configme_append () {
    cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}
