SOC_FAMILY = "omap3"
TARGET_ARCH = "arm"

require conf/machine/include/tune-cortexa8.inc

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r1"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"
