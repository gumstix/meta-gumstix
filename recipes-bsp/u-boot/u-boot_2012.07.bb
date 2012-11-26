require u-boot.inc

PV = "2012.07"
PR = "r0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/adam-lee/u-boot.git;branch=omap-v2012.07;protocol=git \
           file://fw_env.config \
          "
S = "${WORKDIR}/git"
