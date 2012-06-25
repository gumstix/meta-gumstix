DESCRIPTION = "The most basic Gumstix image"

inherit gumstix-image

IMAGE_INSTALL += " \
  bash \
  task-proper-tools \
  task-audio \
  kmod \
  task-firmware \
  task-kernel-modules \
 "
