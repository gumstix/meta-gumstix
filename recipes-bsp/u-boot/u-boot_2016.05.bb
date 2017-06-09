require u-boot.inc

PV = "2016.05"

COMPATIBLE_MACHINE = "duovero|overo|pepper|poblano"

# v2016.05 = aeaec0e682f45b9e0c62c522fafea353931f73ed
SRCREV = "aeaec0e682f45b9e0c62c522fafea353931f73ed"
SRC_URI = " \
    git://git.denx.de/u-boot.git;protocol=git;branch=master \
    file://0001-am437x-poblano-Add-a-new-board.patch \
    file://0002-overo-Ensure-ethernet-is-initialized-for-Arbor43C.patch \
    file://0003-overo-Support-Arbor50C-70C-expansion-boards.patch \
    file://0004-pepper-Read-environment-from-EEPROM.patch \
    file://0005-overo-Select-correct-DTB-for-Arbor43Cv1.patch \
    file://0006-duovero-Read-eeprom-over-i2c.patch \
"


