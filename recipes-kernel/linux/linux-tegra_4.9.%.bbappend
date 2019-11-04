FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/fragments:"

#LINUX_VERSION ?= "4.9"

#inherit kernel
#include linux-yocto.inc

#inherit kernel
#require recipes-kernel/linux/linux-yocto.inc
#inherit kernel-yocto

#SRCREV_machine = "${SRCREV}"

SRC_URI += " \
    file://0001-Add-USB-wireless-driver-for-RTL8822BU-Fn-Link-6222D-.patch \
    file://0002-Add-gasket-and-apex-drivers-for-the-Google-Coral-TPU.patch \
"

SRC_URI_append = " \
    file://enable_gasket.cfg \
    file://enable_6222D-UUB.cfg \
"

#KERNEL_VERSION_SANITY_SKIP="1"

do_configure_append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/*.cfg
    yes '' | make oldconfig
}

