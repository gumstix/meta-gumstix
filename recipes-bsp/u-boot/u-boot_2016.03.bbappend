FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
    git://git.denx.de/u-boot.git;protocol=git;branch=master \
    file://0001-am437x-poblano-Add-a-new-board.patch \
    file://0002-overo-Ensure-ethernet-is-initialized-for-Arbor43C.patch \
    file://0003-overo-Support-Arbor50C-70C-expansion-boards.patch \
    file://0004-pepper-Read-environment-from-EEPROM.patch \
    file://0005-overo-Select-correct-DTB-for-Arbor43Cv1.patch \
    file://0006-duovero-Read-eeprom-over-i2c.patch \
    file://0007-Add-support-for-the-Atheros-AR8035-Gigabit-Ethernet.patch \
    file://0008-Revert-ti-armv7-enable-EXT-support-in-SPL-using-ti_a.patch \
    file://0009-Update-uboot-config-for-DuoVero.patch \
"


