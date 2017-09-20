FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.4:"

SRC_URI += "file://defconfig"

# Overwritting the defconf from our own one
# Original configme function in linux-raspberrypi.inc

do_kernel_configme_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}

