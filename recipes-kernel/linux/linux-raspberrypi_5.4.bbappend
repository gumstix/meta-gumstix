FILESEXTRAPATHS_prepend := "${THISDIR}:${THISDIR}/${PN}-5.4:"

SRC_URI += " \
    file://0001-Add-OV5640-camera-support.patch
    file://0002-Updated-wilink8-support.patch
    file://0003-Update-overlay-support-for-the-tlv320aic3x-audio-cod.patch
    file://0004-Update-sdio-wlink8-for-rpi-cm.patch
    file://0005-Add-support-for-ST-L3GD20H-and-LSM303D-input-drivers.patch
    file://0006-Add-support-for-IMU-over-SPI.patch
    file://0007-Update-mmc-frequency-for-wilink8-overlay.patch
    file://0008-Add-wlink8-and-sound-codec-overlays-to-the-default-b.patch
    file://0009-Add-property-to-sdio-wlink8-to-make-wifi-work.patch
    file://0010-Add-driver-for-Fn-Link-6222D-UUB.patch
    file://0011-Adding-RTL8822CS-Driver.patch
    file://0012-Changing-boot-raspberries-to-gumstix-gears.patch
    file://fragment.cfg \
    file://fragments \
"

do_configure_append() {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${B} ${B}/.config ${WORKDIR}/fragment.cfg
    ${S}/scripts/kconfig/merge_config.sh -m -O ${B} ${B}/.config ${WORKDIR}/fragments/*.cfg
}
