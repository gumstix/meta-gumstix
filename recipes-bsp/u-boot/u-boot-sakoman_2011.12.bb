require u-boot-sakoman.inc

PV = "2011.12"
PR = "r0"

SRCREV = "${AUTOREV}"
SRC_URI = "git://www.sakoman.com/git/u-boot.git;branch=omap3-v2011.12;protocol=git \
           file://fw_env.config \
          "
S = "${WORKDIR}/git"
