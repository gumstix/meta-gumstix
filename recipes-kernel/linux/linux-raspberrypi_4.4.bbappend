FILESEXTRAPATHS_append := "${THISDIR}/linux-raspberrypi-4.4:"

SRC_URI += "file://config.cfg"

# Append configuration fragment to the upstream config file
do_kernel_configme_append () {
    cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}
