SUMMARY = "Userspace Raspberry Pi PWM/PCM/SPI library for SK6812 and WS281X LEDs."
DESCRIPTION = "\
Userspace Raspberry Pi library for controlling WS281X LEDs. This includes WS2812 and SK6812RGB RGB LEDs Preliminary support is now included for SK6812RGBW LEDs (yes, RGB + W) The LEDs can be controlled by either the PWM (2 independent channels) or PCM controller (1 channel) or the SPI interface (1 channel)."
HOMEPAGE = "https://github.com/rpi-ws281x/rpi-ws281x-python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9dcf340793a1d73c5211edc8238767dc"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://Makefile;subdir=rpi_ws281x-${PV} \
            file://Add_CM4_hwver.patch;subdir=rpi_ws281x-${PV};patchdir=lib \
"

SRC_URI[md5sum] = "c93318b33630df8e8bb704de40df76fa"
SRC_URI[sha256sum] = "f025d9d4886d478e8d0167d6abfa49e66119758590822941d9a9afd8d088b153"

PYPI_PACKAGE = "rpi_ws281x"
inherit pypi setuptools3

do_compile_library() {
	SED_COMMAND="/cmdclass/d"
	sed -i "${SED_COMMAND}" ${S}/setup.py
	SED_COMMAND="s#gcc#\$(CC)#g"
	SED_COMMAND="${SED_COMMAND}; s#ar#\$(AR)#g"
	SED_COMMAND="${SED_COMMAND}; s#ranlib#\$(RANLIB)#g"
	sed -i "${SED_COMMAND}" ${S}/Makefile
	cd ${S}
	oe_runmake
}

addtask compile_library after do_configure before do_compile
