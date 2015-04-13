require u-boot.inc

PV = "2016.01"

COMPATIBLE_MACHINE = "poblano"

# v2016.01 = fa85e826c16b9ce1ad302a57e9c4b24db0d8b930
SRCREV = "fa85e826c16b9ce1ad302a57e9c4b24db0d8b930"
SRC_URI = " \
    git://git.denx.de/u-boot.git;protocol=git;branch=master \
    file://0001-am437x-poblano-Add-a-new-board.patch \
"
