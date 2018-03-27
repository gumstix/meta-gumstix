FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Changes-made-to-support-the-Gumstix-NXP-SCM-board.patch \
    file://0002-Add-support-ov5640-device-tree.patch \
    file://0003-Add-device-tree-for-Gumstix-Zircon.patch \
    file://frag_zircon.cfg \
    file://defconfig_imx6dqscm \
"

do_configure_append () {
    if ["${MACHINE}" -eq "imx6dqscm-1gb-zircon"]; then
        ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/frag_zircon.cfg
        yes '' | make oldconfig
    fi

    if ["${MACHINE}" -eq "imx6dqscm-1gb-gumstix"]; then
        ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/defconfig_imx6dqscm
        yes '' | make oldconfig
    fi
}
