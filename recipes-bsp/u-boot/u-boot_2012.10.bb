require u-boot.inc

PV = "2012.10"
PR = "r0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/gumstix/u-boot.git;branch=omap-v2012.10;protocol=git \
           file://fw_env.config \
          "
S = "${WORKDIR}/git"
