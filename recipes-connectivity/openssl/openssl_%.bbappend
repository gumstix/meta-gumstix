do_install_prepend() {
    install -d ${D}${libdir}/ssl/certs
}

do_install_append() {
    rm -r ${D}${libdir}/ssl/certs
    ln -sf /etc/ssl/certs ${D}${libdir}/ssl/certs
}

FILES_${PN} =+ "${libdir}/ssl/*"
