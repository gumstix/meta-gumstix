FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Support additional firmware for WiLink8 modules
#  TIInit_11.8.32.bts is required for bluetooth support but this particular
#  version is not available in the linux-firmware repository.
#
#  The wl1271-nvs.bin firmware provides the MAC address for WiLink8 modules.
#  The version available in the linux-firmware sets the MAC address to
#  "DE:AD:BE:EF:00:00".  Here, we ship one with a zeroed-out MAC address so
#  the module uses the unique MAC burned into its ROM; see [1] for more
#  details.
#
#  [1] http://processors.wiki.ti.com/index.php/WL18xx_Writing_MAC_address
SRC_URI += "\
    file://TIInit_11.8.32.bts \
    file://wl1271-nvs.bin  \
"

do_install_prepend() {
	cp ${WORKDIR}/TIInit_11.8.32.bts ${S}/ti-connectivity/
	cp ${WORKDIR}/wl1271-nvs.bin ${S}/ti-connectivity/
}
