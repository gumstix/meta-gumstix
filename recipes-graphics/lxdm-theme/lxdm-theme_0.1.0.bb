SUMMARY = "Gumstix LXDM theme based off of Industrial"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/index.theme;md5=c8f97b1be7c4c52fafd2be28df71327f"

SRC_URI = "file://background.png \
           file://lang.png \
           file://greeter.ui \
           file://greeter-gtk3.ui \
           file://gtk.css \
           file://gtkrc \
           file://index.theme \
           file://logo.png \
           file://nobody.png \
           file://session.png \
           file://shade.png"
S = "${WORKDIR}"

do_install(){
	install -d ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/background.png ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/lang.png ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/greeter.ui ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/greeter-gtk3.ui ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/gtk.css ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/gtkrc ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/index.theme ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/logo.png ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/nobody.png ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/session.png ${D}/usr/share/lxdm/themes/Gumstix
	install -m 755 ${WORKDIR}/shade.png ${D}/usr/share/lxdm/themes/Gumstix

}

FILES_${PN} += "/usr/share/lxdm/themes/Gumstix"
