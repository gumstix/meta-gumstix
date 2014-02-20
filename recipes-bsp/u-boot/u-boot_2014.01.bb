require u-boot.inc

PV = "2014.01"

COMPATIBLE_MACHINE = "overo|duovero"

# v2014.01
SRCREV = "b44bd2c73c4cfb6e3b9e7f8cf987e8e39aa74a0b"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
           file://0001-omap-overo-allow-the-use-of-a-plain-text-env-file-in.patch \
           file://0002-OMAP3-overo-add-command-support-for-mtd-and-ubi.patch \
           file://0003-OMAP3-overo-increase-linux-partition-to-8-MiB.patch \
           file://0004-OMAP3-overo-eliminate-hard-coded-partition-offsets.patch \
           file://0005-OMAP3-overo-add-some-Gumstix-expansion-boards.patch \
           file://0006-arm-omap3-Fix-omap3_overo-SPL-boot-hangup.patch \
           file://0007-omap4-duovero-Add-DuoVero-machine.patch \
           file://0008-omap3-overo-Add-Board-Revision-for-Wireless-chip.patch \
"

SRC_URI_append_overo = "file://fw_env.config"

SPL_BINARY = "MLO"
