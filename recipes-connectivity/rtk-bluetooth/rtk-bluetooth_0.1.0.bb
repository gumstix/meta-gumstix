DESCRIPTION = "RTK Bluetooth Tools"
LICENSE = "MIT"
SRC_URI = "file://Makefile \
	file://Readme.txt \
	file://8822CS \
	file://rtk_hciattach \
	file://initscript.service \
	file://initscript.sh"
LIC_FILES_CHKSUM = "file://${WORKDIR}/Readme.txt;md5=2fbe0e3cbb491aabe094af8fedb6e6c6"
#LIC_FILES_CHKSUM = "file://Readme.txt;md5=2fbe0e3cbb491aabe094af8fedb6e6c6"
#do_compile[noexec] = "0"

S = "${WORKDIR}"

do_compile() {
   oe_runmake -C rtk_hciattach CC='${CC}'
}

do_install() {
   #oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir} KDIR=${STAGING_KERNEL_DIR} KVER=${LINUX_VERSION}
   install -d -m 755 ${D}/lib/firmware/rtlbt
   install -p -m 755 8822CS/rtl8822cs_fw ${D}/lib/firmware/rtlbt/
   install -p -m 755 8822CS/rtl8822cs_config ${D}/lib/firmware/rtlbt/
   install -d -m 755 ${D}/usr/sbin
   install -p -m 755 rtk_hciattach/rtk_hciattach ${D}/usr/sbin/
}

FILES_${PN} += "/lib/firmware/rtlbt /usr/sbin"
INHIBIT_PACKAGE_STRIP = "1"
TARGET_CC_ARCH += "${LDFLAGS}"
