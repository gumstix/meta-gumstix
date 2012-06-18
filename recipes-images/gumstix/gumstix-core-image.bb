DESCRIPTION = "The most basic Gumstix image"

inherit core-image

IMAGE_INSTALL += " \
  task-proper-tools \
  task-audio \
  task-firmware \
  task-kernel-modules \
 "
