SUMMARY = "Bluetooth Audio ALSA Backend"
HOMEPAGE = "https://github.com/Arkq/bluez-alsa"
SECTION = "devel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=906d8abc7352458738c136e5977b483e"

DEPENDS = "alsa-lib bluez5 glib-2.0 sbc"

SRCREV = "36c4b51ea717c1f8bfa1dd57d1e3f565734a13ac"
SRC_URI = "git://github.com/Arkq/bluez-alsa.git;branch=master;protocol=https \
           file://bluez-alsa.service"

FILESEXTRAPATHS_append := "${THISDIR}/files:"

S = "${WORKDIR}/git"

inherit systemd pkgconfig autotools

do_install () {
    autotools_do_install
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/bluez-alsa.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "${libdir}/alsa-lib/lib*.so ${datadir}/alsa"
FILES_${PN}-dev += "${libdir}/alsa-lib/*.la"
FILES_${PN}-staticdev += "${libdir}/alsa-lib/lib*.a"
FILES_${PN}-dbg += "${libdir}/alsa-lib/.debug/*.so"

SYSTEMD_SERVICE_${PN} = "bluez-alsa.service"

