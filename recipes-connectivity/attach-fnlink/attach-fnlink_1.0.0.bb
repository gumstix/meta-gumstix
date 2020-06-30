SUMMARY = "Adds bluetooth-ttyAMA0-fnlink service to initialize Bluetooth on boot if the FnLink chip is detected"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit update-rc.d systemd

SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('PACKAGECONFIG', 'systemd', 'bluetooth.service', '', d)}"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "bluetooth"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "bluetooth-ttyAMA0-fnlink.service"

SRC_URI = "file://bluetooth-ttyAMA0-fnlink.service \
           file://99-bluetooth-via-ttyAMA0-rpicm3.rules \
           file://LICENSE \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/bluetooth-ttyAMA0-fnlink.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/99-bluetooth-via-ttyAMA0-rpicm3.rules ${D}${sysconfdir}/udev/rules.d
}

REQUIRED_DISTRO_FEATURES= "systemd"
