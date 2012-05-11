DESCRIPTION = "Firmware for libertas_sdio"
LICENSE = "unknown"
LIC_FILES_CHKSUM = "file://license.txt;md5=9ddea1734a4baf3c78d845151f42a37a"


SRC_URI = "file://sd8686.bin \
           file://sd8686_helper.bin \
					 file://license.txt \
          "

S = "${WORKDIR}"

do_install() {
	install -d ${D}/${base_libdir}/firmware
	install -m 0644 ${S}/sd8686.bin ${D}/${base_libdir}/firmware/
	install -m 0644 ${S}/sd8686_helper.bin ${D}/${base_libdir}/firmware/
}

FILES_${PN} = "${base_libdir}/firmware/"
PACKAGE_ARCH = "all"
