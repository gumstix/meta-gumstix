require u-boot.inc

PV = "2013.07"
PR = "r10"

COMPATIBLE_MACHINE = "overo"

SRCREV = "62c175fbb8a0f9a926c88294ea9f7e88eb898f6c"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
          file://0001-omap-overo-update-support-for-Micron-1GB-POP.patch \
          file://0002-omap-overo-Use-200MHz-SDRC-timings-for-revision-1-2-.patch \
          file://0003-omap-overo-allow-the-use-of-a-plain-text-env-file-in.patch \
          file://0004-OMAP3-overo-add-command-support-for-mtd-and-ubi.patch \
          file://0005-OMAP3-overo-increase-linux-partition-to-8-MiB.patch \
          file://0006-Correct-typo-in-comment-for-NAND_BLOCK_SIZE.patch \
          file://0007-OMAP3-overo-add-Alto35-expansion-board-support.patch \
          file://0008-OMAP3-overo-add-some-Gumstix-expansion-boards.patch \
          file://0009-OMAP3-overo-Work-around-HW-ECC-error.patch \
          file://0010-OMAP3-overo-eliminate-hard-coded-partition-offsets.patch \
          file://fw_env.config \
          "
SPL_BINARY = "MLO"
