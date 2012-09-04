# Hack to satisfy vim rpm package desire for /usr/bin/nawk

PRINC := "${@int(PRINC) + 1}"

do_install_append() {
	install -d ${D}${bindir}
	ln -s gawk ${D}${bindir}/nawk
}

FILES_${PN} += "${bindir}/nawk"


