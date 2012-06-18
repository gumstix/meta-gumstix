DESCRIPTION = "Audio support"
PR = "r1"

inherit gumstix-task

RDEPENDS_${PN} = "\
  alsa-state \
  alsa-utils \
  alsa-utils-aplay \
  alsa-utils-amixer \
 "
