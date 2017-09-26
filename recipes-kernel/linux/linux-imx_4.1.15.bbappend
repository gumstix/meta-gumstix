FILESEXTRAPATHS_append := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://defconfig \
    file://0001-Changes-made-to-support-the-Gumstix-NXP-SCM-board.patch \
"

do_copy_defconfig_prepend () {
    cp ${WORKDIR}/defconfig ${B}/.config
    cp ${WORKDIR}/defconfig ${S}/arch/arm/configs/imx_v7_defconfig
}
