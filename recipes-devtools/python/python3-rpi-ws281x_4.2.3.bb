SUMMARY = "Userspace Raspberry Pi PWM/PCM/SPI library for SK6812 and WS281X LEDs."
DESCRIPTION = "\
Userspace Raspberry Pi library for controlling WS281X LEDs. This includes WS2812 and SK6812RGB RGB LEDs Preliminary support is now included for SK6812RGBW LEDs (yes, RGB + W) The LEDs can be controlled by either the PWM (2 independent channels) or PCM controller (1 channel) or the SPI interface (1 channel)."
HOMEPAGE = "https://github.com/rpi-ws281x/rpi-ws281x-python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9dcf340793a1d73c5211edc8238767dc"

SRC_URI[md5sum] = "17a714941043621e81f592e6a137dd92"
SRC_URI[sha256sum] = "265a395410cc7199f779c4209ca3970b7211896b86dbaa4731bdc3569d2e595f"

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
