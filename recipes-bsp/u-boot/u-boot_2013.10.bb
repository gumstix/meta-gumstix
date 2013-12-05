require u-boot.inc

PV = "2013.10"
PR = "r1"

LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git \
          file://0001-omap-overo-allow-the-use-of-a-plain-text-env-file-in.patch \
          file://0002-OMAP3-overo-add-command-support-for-mtd-and-ubi.patch \
          file://0003-OMAP3-overo-increase-linux-partition-to-8-MiB.patch \
          file://0004-OMAP3-overo-eliminate-hard-coded-partition-offsets.patch \
          file://0005-OMAP3-overo-add-some-Gumstix-expansion-boards.patch \
          file://0006-omap4-duovero-Add-DuoVero-machine.patch \
          file://0007-am335x-pepper-Add-Pepper-AM335x-based-machine.patch \
          file://0008-OMAP3-overo-Work-around-HW-ECC-error.patch \
          file://0009-Pepper-may-still-pass-ATAGS-to-the-kernel.patch \
          file://0010-arm-omap-i2c-don-t-zero-cnt-in-i2c_write.patch \
          "
SRC_URI_append_overo = "file://fw_env.config"

SPL_BINARY = "MLO"
