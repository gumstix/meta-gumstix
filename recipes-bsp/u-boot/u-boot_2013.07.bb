require u-boot.inc

PV = "2013.07"
PR = "r4"

COMPATIBLE_MACHINE = "overo"

SRCREV = "62c175fbb8a0f9a926c88294ea9f7e88eb898f6c"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
          file://0001-omap-overo-update-support-for-Micron-1GB-POP.patch \
          file://0002-omap-overo-Use-200MHz-SDRC-timings-for-revision-1-2-.patch \
          file://0003-omap-overo-allow-the-use-of-a-plain-text-env-file-in.patch \
          file://0004-OMAP3-overo-add-command-support-for-mtd-and-ubi.patch \
          file://fw_env.config \
          "
SPL_BINARY = "MLO"
