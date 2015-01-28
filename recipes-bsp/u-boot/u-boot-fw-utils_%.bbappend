FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_overo := " file://fw_env.config"

# override the fw_env.config provided by the default recipe
do_install_append_overo () {
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
