# Fix ltrace compatible with aarch64 (dragonboard-410c)

PV = "7.91+git${SRCPV}"
SRCREV = "c22d359433b333937ee3d803450dc41998115685"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
	file://0001-Use-correct-enum-type.patch \
	file://0002-Fix-const-qualifier-error.patch \
"
