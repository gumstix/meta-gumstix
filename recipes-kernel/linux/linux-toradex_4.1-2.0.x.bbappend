FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://config \
    file://Add-device-tree-gumstix.patch \
"

do_configure_prepend() {
    cp ${WORKDIR}/config ${WORKDIR}/defconfig
    cp ${WORKDIR}/config ${B}/.config
}
