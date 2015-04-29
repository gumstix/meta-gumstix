require u-boot.inc

PV = "2015.04"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2015.04 = f33cdaa4c3da4a8fd35aa2f9a3172f31cc887b35
SRCREV = "f33cdaa4c3da4a8fd35aa2f9a3172f31cc887b35"
SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=master \
	file://0001-This-separates-the-SPL-specific-code-from-the-u-boot.patch \
	file://0002-u-boot-breaks-for-the-Overo-boards-since-the-followi.patch \
	file://0003-omap3-overo-Set-the-Arbor43C-expansionname.patch \
	file://0004-pepper-Add-support-for-DDR3-variants.patch \
	file://0005-omap3-overo-Add-DTS-support-for-TobiDuo-expansion.patch \
	file://0006-omap3-overo-Use-software-BCH8-ECC-for-NAND.patch \
	file://0007-omap3-overo-Allow-boot-with-kernel-in-UBI-rootfs.patch \
	file://0008-overo-Override-RAM-setup-for-rev.-0-boards.patch \
	file://0009-overo-Add-support-for-Palo35-expansion-board.patch \
	file://0010-pepper-support-DDR3-variants-with-pepper_ddr3_defcon.patch \
"
