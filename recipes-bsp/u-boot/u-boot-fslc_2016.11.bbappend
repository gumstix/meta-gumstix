FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Add-gumstix-scm-dev-board-config-files.patch \
    file://0002-Add-config-files-for-Gumstix-Zircon.patch \
    file://0003-Add-machine-Gumstix-Zircon-2GB-version.patch \
"
