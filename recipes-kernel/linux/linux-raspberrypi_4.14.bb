FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.14:"

require linux-raspberrypi.inc

LINUX_VERSION = "4.14"
LINUX_RPI_DEV_BRANCH = "rpi-4.14.y"

SRCREV = "${AUTOREV}"
SRC_URI += " \
    git://github.com/raspberrypi/linux.git;protocol=git;branch=${LINUX_RPI_DEV_BRANCH} \
    file://0001-build-arm64-Add-rules-for-.dtbo-files-for-dts-overla.patch \
    file://0002-Updated-wlink8-support.patch \
    file://0003-Add-bcm2835-unicam-driver.patch \
    file://0004-Add-devicetree-support-for-ov5640.patch \
    file://0005-Add-enable-bcm2835driver-ov5640driver.patch
    file://0006-Add-v4l2-support-functions-for-bcm2835-unicam.patch \
    file://0007-Fix-connected-active-CSI-2-lane-reporting.patch \
    file://0008-ov5640-assign-xclk-to-GPCLK2.patch \
    file://0009-Fix-ov5640-driver-480p-and-720p-flickering-video.patch \
    file://fragment.cfg \
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
