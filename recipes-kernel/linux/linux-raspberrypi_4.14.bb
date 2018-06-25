FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.14:"

require linux-raspberrypi.inc

LINUX_VERSION = "4.14"
LINUX_RPI_DEV_BRANCH = "rpi-4.14.y"

SRCREV = "${AUTOREV}"
SRC_URI += " \
    git://github.com/raspberrypi/linux.git;protocol=git;branch=${LINUX_RPI_DEV_BRANCH} \
    file://0001-Add-unicam-driver-for-custom-camera-modules.patch \
    file://0002-Add-OV5640-camera-support-with-devicetree-and-driver.patch \
    file://0003-Updated-wlink8-support.patch \
    file://0004-Update-overlay-support-for-the-tlv320aic3x-audio-cod.patch \
    file://0005-Update-sdio-wlink8-for-rpi-cm.patch \
    file://0006-Add-IMU-sensor-drivers.patch \
    file://0007-Add-support-for-IMU-over-SPI.patch \
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


