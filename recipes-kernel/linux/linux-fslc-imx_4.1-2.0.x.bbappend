FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Changes-made-to-support-the-Gumstix-NXP-SCM-board.patch \
    file://0002-Add-support-ov5640-device-tree.patch \
    file://defconfig \
"

do_copy_defconfig_prepend () {
    cp ${WORKDIR}/defconfig ${B}/.config
    cp ${WORKDIR}/defconfig ${S}/arch/arm/configs/imx_v7_defconfig
}
