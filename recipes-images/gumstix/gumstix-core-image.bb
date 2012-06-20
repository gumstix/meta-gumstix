DESCRIPTION = "The most basic Gumstix image"

inherit gumstix-image

IMAGE_INSTALL += " \
  bash \
  task-proper-tools \
 "
#  task-audio \
#  task-firmware \
#  task-kernel-modules \
