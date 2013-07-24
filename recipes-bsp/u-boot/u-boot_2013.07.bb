require u-boot.inc

PV = "2013.07"
PR = "r0"

COMPATIBLE_MACHINE = "overo"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/gumstix/u-boot.git;branch=v2013.07;protocol=git \
           file://fw_env.config \
          "
SPL_BINARY = "MLO"
