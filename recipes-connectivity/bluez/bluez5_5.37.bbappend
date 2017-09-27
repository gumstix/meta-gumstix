# Add required hciattach for optional on-board Wi2Wi bluetooth adapter
FILESEXTRAPATHS_prepend := "${THISDIR}/bluez5-5.37:"

SRC_URI += " \
  file://99-bluetooth-via-uart.rules \
  file://99-bluetooth-via-uart-poblano.rules \
  file://99-bluetooth-via-uart-scm.rules \
  file://bluetooth-ttyO1-csr.service \
  file://bluetooth-ttyO1-wilink.service \
  file://bluetooth-ttyO3-wilink.service \
  file://bluetooth-ttymxc4-wilink.service \
"

def get_service(machine):
  if machine == 'poblano':
    return "bluetooth-ttyO3-wilink.service"
  elif machine == 'imx6dqscm-1gb-gumstix':
    return "bluetooth-ttymxc4-wilink.service"
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

    "imx6dqscm-1gb-gumstix")
      install -m 0644 ${WORKDIR}/bluetooth-ttymxc4-wilink.service ${D}${systemd_unitdir}/system
      install -m 0644 ${WORKDIR}/99-bluetooth-via-uart-scm.rules ${D}${sysconfdir}/udev/rules.d ;;

    *)

      install -m 0644 ${WORKDIR}/bluetooth-ttyO1*.service ${D}${systemd_unitdir}/system
      install -m 0644 ${WORKDIR}/99-bluetooth-via-uart.rules ${D}${sysconfdir}/udev/rules.d ;;
  esac
}
