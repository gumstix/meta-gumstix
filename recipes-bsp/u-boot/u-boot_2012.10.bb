require u-boot.inc

PV = "2012.10"
PR = "r1"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/gumstix/u-boot.git;branch=omap-v2012.10;protocol=git \
           file://fw_env.config \
          "
SPL_BINARY = "MLO"
