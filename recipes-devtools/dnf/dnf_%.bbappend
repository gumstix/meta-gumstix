# Provide the gumstix.key necessary for gumstix rpm software installation. 
# The service will run on first boot, then disable itself.  cd 

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://gumstix.key \
            file://gumstix-key.service \
            file://gumstix-key.sh"

FILES_${PN} += "${datadir}/gumstixkey/* \
                ${systemd_unitdir}/system/gumstix-key.*"

do_install_append() {
    install -d ${D}${datadir}/gumstixkey
    install -m 0755 ${WORKDIR}/gumstix-key.sh ${D}${datadir}/gumstixkey/
    install -m 0755 ${WORKDIR}/gumstix.key ${D}${datadir}/gumstixkey/
    
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
    install -m 0644 ${WORKDIR}/gumstix-key.service ${D}/${systemd_unitdir}/system/gumstix-key.service
    # create symlink, equivalent to "systemctl enable gumstix-key.service"
    ln -s ${systemd_unitdir}/system/gumstix-key.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/gumstix-key.service
    
}
