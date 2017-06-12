# Add required hciattach for optional on-board Wi2Wi bluetooth adapter
FILESEXTRAPATHS_prepend := "${THISDIR}/bluez5-5.%:"

SRC_URI += " \
  file://99-bluetooth-via-uart.rules \
  file://99-bluetooth-via-uart-poblano.rules \
  file://bluetooth-ttyO1-csr.service \
  file://bluetooth-ttyO1-wilink.service \
  file://bluetooth-ttyO3-wilink.service \
"

def get_service(machine):
  if machine is 'poblano':
    return "bluetooth-ttyO3-wilink.service"
  else:
    return "bluetooth-ttyO1-csr.service bluetooth-ttyO1-wilink.service"

SYSTEMD_SERVICE_${PN} += "${@get_service("${MACHINE}")}"

SYSTEMD_AUTO_ENABLE = "enable"

do_install_append() {
  install -d ${D}${systemd_unitdir}/system
  install -d ${D}${sysconfdir}/udev/rules.d
  case "${MACHINE}" in
    "poblano")
      install -m 0644 ${WORKDIR}/bluetooth-ttyO3-wilink.service ${D}${systemd_unitdir}/system
      install -m 0644 ${WORKDIR}/99-bluetooth-via-uart-poblano.rules ${D}${sysconfdir}/udev/rules.d ;;

    *)
      install -m 0644 ${WORKDIR}/bluetooth-ttyO1*.service ${D}${systemd_unitdir}/system
      install -m 0644 ${WORKDIR}/99-bluetooth-via-uart.rules ${D}${sysconfdir}/udev/rules.d ;;
  esac
}
