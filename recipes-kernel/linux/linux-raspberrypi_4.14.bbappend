FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.14:"

SRC_URI += " \
    file://0002-Add-OV5640-camera-support-with-devicetree-and-driver.patch \
    file://0003-Updated-wlink8-support.patch \
    file://0004-Update-overlay-support-for-the-tlv320aic3x-audio-cod.patch \
    file://0005-Update-sdio-wlink8-for-rpi-cm.patch \
    file://0006-Add-IMU-sensor-drivers.patch \
    file://0007-Add-support-for-IMU-over-SPI.patch \
    file://0008-Update-mmc-frequency-for-wilink8-overlay.patch \
    file://fragment.cfg \
"

do_kernel_configme_append () {
    cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}

# Set contiguous memory allocation size for video streaming
PITFT_PARAMS_append = "\n# Uncomment and add inline to optimize memory for streaming video\n# cma=64M"
