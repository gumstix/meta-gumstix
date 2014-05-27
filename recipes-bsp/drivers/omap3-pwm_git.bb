DESCRIPTION = "PWM drivers for omap3 processors"
HOMEPAGE = "https://github.com/scottellis/omap3-pwm"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

COMPATIBLE_MACHINE = "omap3"

SRCREV = "ccee3524b0bc063f968eef3d7963e613dd0beb1b"
SRC_URI = " \
    git://github.com/scottellis/omap3-pwm.git;protocol=git \
    file://0001-Add-include-path-for-dmtimer.h.patch \
"

S = "${WORKDIR}/git"

do_compile() {
  unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
  oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}'
}

do_install() {
  install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/${PN}
  install -m 0644 pwm${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/${PN}
}
