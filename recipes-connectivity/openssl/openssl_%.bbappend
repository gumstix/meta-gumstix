do_install_append() {
    rm -r ${D}${libdir}/ssl/certs
    ln -sf /etc/ssl/certs ${D}${libdir}/ssl/certs
}
