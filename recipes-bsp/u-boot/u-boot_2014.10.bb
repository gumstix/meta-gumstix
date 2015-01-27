require u-boot.inc

PV = "2014.10"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2014.10 = c43fd23cf619856b0763a64a6a3bcf3663058c49
SRCREV = "c43fd23cf619856b0763a64a6a3bcf3663058c49"
SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=master \
	file://0001-omap3-overo-Set-the-Arbor43C-expansionname.patch \
	file://0002-pepper-Add-support-for-DDR3-variants.patch \
"
