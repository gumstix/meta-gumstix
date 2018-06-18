FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Changes-made-to-support-the-Gumstix-NXP-SCM-board.patch \
    file://0002-Add-support-ov5640-device-tree.patch \
    file://0003-Add-device-tree-for-Gumstix-Zircon.patch \
    file://0004-Add-device-tree-for-Gumstix-Zircon-2GB-version.patch \
    file://0005-IMU-ST-driver-patches-for-accel-mag-gyro.patch \
    file://frag_zircon.cfg \
    file://frag_imx6dqscm.cfg \
"

do_configure_append () {
   case "${MACHINE}" in
       "imx6dqscm-1gb-zircon")
        ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/frag_zircon.cfg
        yes '' | make oldconfig ;;
        
               "imx6dqscm-2gb-zircon")
        ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/frag_zircon.cfg
        yes '' | make oldconfig ;;

       "imx6dqscm-1gb-gumstix")
        ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/frag_imx6dqscm.cfg
        yes '' | make oldconfig ;;
   esac
}
