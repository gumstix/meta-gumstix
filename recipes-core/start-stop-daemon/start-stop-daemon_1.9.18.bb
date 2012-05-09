DESCRIPTION = "Debian's start-stop-daemon utility"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://license-destdir/start-stop-daemon/generic_PD;md5=b3597d12946881e13cb3b548d1173851"
PR = "r1"

SRC_URI = "file://start-stop-daemon.c"

S = "${WORKDIR}"

do_configure() {
	:
}

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/start-stop-daemon.c -o start-stop-daemon
}

do_install () {
	install -d ${D}/${base_sbindir}
	install -m 0755 ${S}/start-stop-daemon ${D}/${base_sbindir}/start-stop-daemon.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_sbindir}/start-stop-daemon start-stop-daemon start-stop-daemon.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove start-stop-daemon start-stop-daemon.${PN}
}
