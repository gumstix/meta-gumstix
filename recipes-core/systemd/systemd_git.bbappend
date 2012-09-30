FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0-volatile.conf"

do_install_append() {
	install -d ${D}${libdir}/tmpfiles.d
	install -m 0644 ${WORKDIR}/0-volatile.conf ${D}${libdir}/tmpfiles.d/
}

FILES_${PN} += "${libdir}/tmpfiles.d/0-volatile.conf"
