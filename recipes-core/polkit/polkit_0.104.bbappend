PRINC := "${@int(PRINC) + 1}"

# enable systemd
DEPENDS += "systemd"
EXTRA_OECONF += " --enable-systemd"

