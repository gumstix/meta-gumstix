require u-boot.inc

PV = "2014.10"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2014.10 = c43fd23cf619856b0763a64a6a3bcf3663058c49
SRCREV = "c43fd23cf619856b0763a64a6a3bcf3663058c49"
SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=master \
	file://0001-omap3-overo-Set-the-Arbor43C-expansionname.patch \
	file://0002-pepper-Add-support-for-DDR3-variants.patch \
	file://0003-omap3-overo-Add-DTS-support-for-TobiDuo-expansion.patch \
	file://0004-omap-gpmc-nandecc-sw-can-use-HAM1-or-BCH8.patch \
	file://0005-omap3-overo-Use-software-BCH8-ECC-for-NAND.patch \
	file://0006-omap3-overo-Allow-boot-with-kernel-in-UBI-rootfs.patch \
"
