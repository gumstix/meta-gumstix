# Adapted from the version in meta-ti
SUMMARY = "Shared Transport Line Discipline User Mode initialisation Manager Daemon"
HOEMPAGE = "http://omappedia.org/wiki/Device_Driver_Interface_of_WiLink_Solution#User_Space_components"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://uim.c;beginline=1;endline=18;md5=9f0bbfbc10c67689e81a523e2976c31e"

inherit systemd update-rc.d

# Follow the Arch Linux name 'ti-uim' [1].  Systemd will prefer native
# service files over initscripts of the same name.
# [1] https://github.com/archlinuxarm/PKGBUILDs/pull/680/files
SYSTEMD_SERVICE_${PN} = "ti-uim.service"
SYSTEMD_AUTO_ENABLE = "disable"
INITSCRIPT_NAME = "ti-uim"
INITSCRIPT_PARAMS = "defaults 03"

SRC_URI[md5sum] = "369b15488303682ea86bca5345b1641d"
SRC_URI[sha256sum] = "ca8c8420f71eb2524c69cf2713dba637e5e36000cff9c22f0f2ac449ead2c420"

SRC_URI = " \
    https://s3.amazonaws.com/gumstix-misc/uim.tar.gz \
    file://0001-uim-Add-command-line-args-for-passing-sysfs-node-pat.patch \
    file://ti-uim \
    file://ti-uim.service \
"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 uim ${D}${bindir}

	# install a classic init script
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/ti-uim ${D}${sysconfdir}/init.d

	# install systemd service
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/ti-uim.service ${D}${systemd_unitdir}/system
}
