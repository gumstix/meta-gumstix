# Add required hciattach for optional on-board Wi2Wi bluetooth adapter
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
  file://99-bluetooth-via-uart.rules \
  file://bluetooth-ttyO1-csr.service \
  file://bluetooth-ttyO1-wilink.service \
"

SYSTEMD_SERVICE_${PN} += "bluetooth-ttyO1-csr.service bluetooth-ttyO1-wilink.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/bluetooth-ttyO1*.service ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-bluetooth-via-uart.rules ${D}${sysconfdir}/udev/rules.d
}
