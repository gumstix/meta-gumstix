FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex_4.9:"

SRC_URI += " \
    file://fragment.cfg \
    file://0001-Add-device-tree-gumstix.patch \
    file://0002-Add-device-tree-gumstix.patch \
    file://0003-Fix-iMX-7-audio-problem-on-Alexa-board.patch \
    file://0004-Fix-iMX-7-alexa-board-USB-problem.patch \
"

do_configure_append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/*.cfg
    yes '' | make oldconfig
}
