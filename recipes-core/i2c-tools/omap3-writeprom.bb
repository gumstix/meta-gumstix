DESCRIPTION = "Writeprom script for omap3 boards with EEPROM on there expansionboard - see http://www.elinux.org/BeagleBoardPinMux#Vendor_and_Device_IDs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


SRC_URI = "file://writeprom.sh \
	   file://COPYING "

S = "${WORKDIR}"

do_install () {
  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/writeprom.sh ${D}${bindir}/
}

PACKAGE_ARCH = "all"
RDEPENDS_${PN} = "i2c-tools"
FILES_${PN} = "${bindir}"

