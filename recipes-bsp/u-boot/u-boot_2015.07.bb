require u-boot.inc

PV = "2015.07"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2015.07-rc2 = 3d0158ae18bef2ac89979f4c90419d3add436c71
SRCREV = "3d0158ae18bef2ac89979f4c90419d3add436c71"
SRC_URI = " \
	git://git.denx.de/u-boot.git;protocol=git;branch=master \
        file://0001-Update-the-rootfs-type-to-ext4-for-Overo-and-Pepper.patch \
        file://0002-Update-rootfs-type-to-ext4-for-DuoVero.patch \
"
