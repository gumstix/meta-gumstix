# Hack to satisfy python rpm package desire for /usr/bin/env

PRINC := "${@int(PRINC) + 1}"

do_install_append() {
	install -d ${D}${bindir}
	ln -s env.${PN} ${D}${bindir}/env
}

