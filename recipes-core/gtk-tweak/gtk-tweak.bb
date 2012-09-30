DESCRIPTION = "Enable clearlooks and gnome-icon-theme in gtkrc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit allarch

RDEPENDS_${PN} = " gnome-icon-theme gtk-theme-clearlooks"

SRC_URI = "file://gtkrc"

do_install() {
        install -d ${D}${sysconfdir}/gtk-2.0/
	install -m 0755 ${WORKDIR}/gtkrc ${D}/${sysconfdir}/gtk-2.0/
}


