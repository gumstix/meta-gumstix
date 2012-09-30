FILESEXTRAPATHS := "${THISDIR}/${PN}"
SRC_URI += "file://add-ap-setup-to-systemd-service.patch \
            file://enable-keyfile-plugin.patch \
            file://nm-system-settings.conf \
            file://open-wifi \
            file://ap-setup \
           "

PRINC := "${@int(PRINC) + 2}"

do_install_append () {
	install -d ${D}${sysconfdir}/NetworkManager
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}${sysconfdir}/NetworkManager/

	install -d ${D}${sysconfdir}/NetworkManager/system-connections-templates
	install -m 0600 ${WORKDIR}/open-wifi ${D}${sysconfdir}/NetworkManager/system-connections-templates/

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/ap-setup ${D}${bindir}

	install -d ${D}${libdir}/NetworkManager
	install -m 0755 ${S}/src/settings/plugins/keyfile/.libs/libnm-settings-plugin-keyfile.so* ${D}${libdir}/NetworkManager/
}

FILES_${PN} += "${libdir}/NetworkManager/*.so*"

RDEPENDS_${PN} += "dnsmasq iptables util-linux-uuidgen"

