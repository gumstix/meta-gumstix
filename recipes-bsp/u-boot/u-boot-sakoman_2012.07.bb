require u-boot-sakoman.inc

PV = "2012.07"
PR = "r0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/u-boot.git;branch=omap-v2012.07;protocol=git \
           file://fw_env.config \
          "
S = "${WORKDIR}/git"
