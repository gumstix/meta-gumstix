require u-boot.inc

PV = "2015.07"

COMPATIBLE_MACHINE = "overo|duovero|pepper"

# v2015.07 = 33711bdd4a4dce942fb5ae85a68899a8357bdd94
SRCREV = "33711bdd4a4dce942fb5ae85a68899a8357bdd94"
SRC_URI = " \
    git://git.denx.de/u-boot.git;protocol=git;branch=master \
    file://0001-Update-the-rootfs-type-to-ext4-for-Overo-and-Pepper.patch \
    file://0002-Update-rootfs-type-to-ext4-for-DuoVero.patch \
    file://0003-Revert-ti-armv7-enable-EXT-support-in-SPL-using-ti_a.patch \
    file://0004-overo-Ensure-ethernet-is-initialized-for-Arbor43C.patch \
    file://0005-overo-Support-Arbor50C-70C-expansion-boards.patch \
    file://0006-pepper-Read-environment-from-EEPROM.patch \
    file://0001-overo-Select-correct-DTB-for-Arbor43Cv1.patch \
    file://0007-duovero-Read-eeprom-over-i2c.patch \
"
