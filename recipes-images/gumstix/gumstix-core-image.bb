DESCRIPTION = "The most basic Gumstix image"

inherit image

IMAGE_INSTALL += " \
  bash \
  task-proper-tools \
  task-audio \
  kmod \
  task-firmware \
  task-kernel-modules \
 "
