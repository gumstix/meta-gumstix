FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.14:"

require linux-raspberrypi.inc

LINUX_VERSION = "4.14"
LINUX_RPI_DEV_BRANCH = "rpi-4.14.y"

SRCREV = "${AUTOREV}"
SRC_URI += " \
    git://github.com/raspberrypi/linux.git;protocol=git;branch=${LINUX_RPI_DEV_BRANCH} \
    file://0001-build-arm64-Add-rules-for-.dtbo-files-for-dts-overla.patch \
    file://fragment.cfg \
    file://0001-Updated-wlink8-support.patch \
    file://0002-Add-bcm2835-unicam-driver.patch \
    file://0002-Add-devicetree-support-for-ov5640.patch \
    file://0002-Add-v4l2-support-functions-for-bcm2835-unicam.patch \
    file://0002-Fix-connected-active-CSI-2-lane-reporting.patch \
"

FILES_${PN} += "${libdir}/*"

# use serial0 for console, the wlink8 patch will change the alias if needed
CMDLINE_raspberrypi-cm3 = "dwc_otg.lpm_enable=0 console=serial0,115200 root=/dev/mmcblk0p2 rootfstype=ext4 rootwait bcm2835_unicam.debug=3 cma=64M"

# Adding configuration fragments into the defconf
# Then rpi layer will merge the defconfig with the machine config
# Original configme function in linux-raspberrypi.inc

do_kernel_configme_append () {
    cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}

# Disable version check so that we don't have to edit this recipe every time
# upstream bumps the version
KERNEL_VERSION_SANITY_SKIP = "1"
