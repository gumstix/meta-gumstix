FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://config \
    file://Add-device-tree-gumstix.patch \
"

KERNEL_DEVICETREE_colibri_imx6 = "imx6dl-colibri-gumstix.dtb"

do_configure_prepend() {
    cp ${WORKDIR}/config ${WORKDIR}/defconfig
    cp ${WORKDIR}/config ${B}/.config
}
