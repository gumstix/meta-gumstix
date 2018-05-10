include u-boot-fslc.inc

PV = "v2016.11+git${SRCPV}"

SRCREV = "c44711d91e32a5738875fe505efc54f6958fd64e"
SRCBRANCH = "2016.11+fslc"

SRC_URI += " \
    file://0001-Add-gumstix-scm-dev-board-config-files.patch \
    file://0002-Add-config-files-for-Gumstix-Zircon.patch \
    file://0003-Add-machine-Gumstix-Zircon-2GB-version.patch \
"
