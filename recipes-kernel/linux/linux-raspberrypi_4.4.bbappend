FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.4:"

SRC_URI += " \
    file://fragment.cfg \
    file://0001-Updated-wlink8-support.patch \
"

# use serial0 for console, the wlink8 patch will change the alias if needed
CMDLINE_raspberrypi-cm3 = "dwc_otg.lpm_enable=0 console=serial0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait"

# Adding configuration fragments into the defconf
# Then rpi layer will merge the defconfig with the machine config
# Original configme function in linux-raspberrypi.inc

do_kernel_configme_append () {
    cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}
