FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
    file://fragment.cfg \
    file://0001-Add-device-tree-gumstix.patch \
    file://0002-Add-device-tree-gumstix.patch \
    file://0003-Fix-iMX-7-Alexa-board-USB-problem.patch \
    file://0004-IMU-ST-driver-patches-for-accel-mag-gyro.patch \
"

do_configure_append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/*.cfg
    yes '' | make oldconfig
}
