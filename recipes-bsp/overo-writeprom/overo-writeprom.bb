DESCRIPTION = "script for overo to write expansion board contents"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
SRC_URI = "file://overo-writeprom.sh"

COMPATIBLE_MACHINE = "overo"

RDEPENDS_${PN} = "i2c-tools"

do_install () {
	install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/overo-writeprom.sh ${D}${bindir}/
}


