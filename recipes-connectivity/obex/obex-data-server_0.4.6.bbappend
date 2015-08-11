DEPENDS_remove = "bluez4"
RCONFLICTS_${PN} = ""
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES','bluez5','bluez5','bluez4',d)}"
