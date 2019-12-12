LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} += "already-stripped"

DEPENDS += " dpkg-native "

SRC_URI = "${NVIDIA_DEVNET_MIRROR}/libcudnn7_7.5.0.56-1+cuda10.0_amd64.deb"

do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

inherit native

do_install() {
    install -d ${D}${STAGING_DIR_NATIVE}/usr/lib/x86_64-linux-gnu
    install -m 0755 ${WORKDIR}/usr/lib/x86_64-linux-gnu/libcudnn.so.7 ${D}${STAGING_DIR_NATIVE}/usr/lib/x86_64-linux-gnu/
}
