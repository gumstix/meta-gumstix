DESCRIPTION = "Default display timings and resolutions for fbset"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../license-destdir/fbset-modes/generic_MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "0.1.0"
PR = "r5"

SRC_URI = "file://fb.modes"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fb.modes ${D}${sysconfdir}
}

PACKAGE_ARCH = "all"
CONFFILES_${PN} = "${sysconfdir}/fb.modes"

