require gumstix-core-image.bb
require gumstix-packages.inc

DESCRIPTION = "The Gumstix console image."

IMAGE_INSTALL += " \
  ${PACKAGE_GROUP_audio} \
  ${PACKAGE_GROUP_firmware} \
  ${PACKAGE_GROUP_kernel_modules} \
  ${PACKAGE_GROUP_gles} \
  ${PACKAGE_GROUP_tools} \
 "
