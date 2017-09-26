FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://0001-add-defconfig.patch \
    file://0002-u-boot-imx-pin-mux.patch \
    file://0003-mx6dqscm-config-h.patch \
"
