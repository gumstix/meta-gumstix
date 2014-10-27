require u-boot.inc

PV = "2014.10"

COMPATIBLE_MACHINE = "duovero"

# v2014.10
SRCREV = "c43fd23cf619856b0763a64a6a3bcf3663058c49"
SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=master \
"

SRC_URI_append_overo = "file://fw_env.config"

SPL_BINARY = "MLO"
