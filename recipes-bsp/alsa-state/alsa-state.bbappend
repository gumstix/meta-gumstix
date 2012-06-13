FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
    install -m 0644 ${WORKDIR}/asound.state ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/asound.state"
