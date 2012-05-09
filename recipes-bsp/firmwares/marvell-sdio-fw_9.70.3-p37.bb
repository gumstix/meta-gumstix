DESCRIPTION = "Firmware for Marvel 8686 gspi wifi chipset"
LICENSE = "closed"
LIC_FILES_CHKSUM = "file://Marvell-Licence.txt;md5=4725db20ee6d3466bfc15f27076df560"

SRC_URI = "file://${PV}.tar.gz \
           file://Marvell-Licence.txt"

PR = "r1"

inherit allarch

do_unpack_append() {
	bb.build.exec_func('do_cp_lic', d)

}

do_cp_lic() {
        cp ${WORKDIR}/Marvell-Licence.txt ${S}
}

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 sd8686.bin sd8686_helper.bin ${D}${base_libdir}/firmware
}

S = "${WORKDIR}/${PV}/FwImage"

FILES_${PN} += "${base_libdir}/firmware"
