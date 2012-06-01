DESCRIPTION = "PWM drivers for omap3 processors"
HOMEPAGE = "https://github.com/scottellis/omap3-pwm"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://../git/pwm.c;endline=28;md5=c8448052329697f9239ac2d919535901"
PR="r1"

inherit module

SRCREV = "dc40d9296054e7e26c89586c1bd01199e1593017"
SRC_URI = "git://github.com/scottellis/omap3-pwm.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
  unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
  oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}'
}

do_install() {
  install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/${PN}
  install -m 0644 pwm${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/${PN}
}
