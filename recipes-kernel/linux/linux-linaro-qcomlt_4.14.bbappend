FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://fragment.cfg \
    file://Add-ov5640-support-dragonboard.patch \
    file://Add-ov5640-devicetree.patch \
"

do_configure_append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/*.cfg
    yes '' | make oldconfig
}
