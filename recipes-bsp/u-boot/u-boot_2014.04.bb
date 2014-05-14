require u-boot.inc

PV = "2014.04"

COMPATIBLE_MACHINE = "pepper"

# v2014.04
SRCREV = "dda0dbfc69f3d560c87f5be85f127ed862ea6721"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
           file://0001-omap-overo-allow-the-use-of-a-plain-text-env-file-in.patch \
           file://0002-OMAP3-overo-add-command-support-for-mtd-and-ubi.patch \
           file://0003-OMAP3-overo-increase-linux-partition-to-8-MiB.patch \
           file://0004-OMAP3-overo-eliminate-hard-coded-partition-offsets.patch \
           file://0005-arm-omap3-Fix-omap3_overo-SPL-boot-hangup.patch \
           file://0006-omap3-overo-Add-Board-Revision-for-Wireless-chip.patch \
           file://0007-OMAP3-overo-add-some-Gumstix-expansion-boards.patch \
           file://0008-OMAP3-Overo-Correct-mux-ing-for-Arbor43C-Board.patch \
           file://0009-omap3-overo-Allow-overo-to-boot-with-device-tree.patch \
           file://0010-am335x-pepper-Add-Pepper-AM335x-based-machine.patch \
           file://0011-omap4-duovero-Add-DuoVero-machine.patch \
"

SRC_URI_append_overo = "file://fw_env.config"

SPL_BINARY = "MLO"
