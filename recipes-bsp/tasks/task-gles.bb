DESCRIPTION = "openGL Embedded Support"
PR = "r1"

inherit gumstix-task

RDEPENDS_${PN} = "\
  libgles-omap3 \
 "
