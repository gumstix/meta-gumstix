# Add required hciattach for optional on-board Wi2Wi bluetooth adapter
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
PRINC := "${@int(PRINC) + 2}"

SRC_URI += " \
  file://bluetooth-ttyO1.service \
  file://bluetooth-ttyO1.conf \
  file://network-fix-network-Connect-method-parameters.patch \
"

SYSTEMD_SERVICE_${PN} += "bluetooth-ttyO1.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/bluetooth-ttyO1.service ${D}${systemd_unitdir}/system
    install -d ${D}${systemd_unitdir}/system/bluetooth.service.d
    install -m 0644 ${WORKDIR}/bluetooth-ttyO1.conf ${D}${systemd_unitdir}/system/bluetooth.service.d
}

