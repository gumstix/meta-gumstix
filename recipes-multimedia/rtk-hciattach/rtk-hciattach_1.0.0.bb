SUMMARY = "Realtek hciattach tool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

FILESEXTRAPATHS_prepend := "${THISDIR}:${THISDIR}/files/rtk_hciattach:"

SRC_URI = "file://Makefile \
           file://hciattach.c \
           file://hciattach.h \
           file://hciattach_h4.c \
           file://hciattach_h4.h \
           file://hciattach_rtk.c \
           file://rtb_fwc.c \
           file://rtb_fwc.h \
           file://8822CS/Makefile \
           file://8822CS/rtl8822cs_config \
           file://8822CS/rtl8822cs_fw \
           file://LICENSE \
"
S = "${WORKDIR}"

do_install(){
	install -d ${D}/usr/sbin
	install -m 755 ${WORKDIR}/rtk_hciattach ${D}/usr/sbin
	install -d 755 ${D}/lib/firmware/rtlbt
	install -m 755 ${WORKDIR}/8822CS/rtl8822cs_fw ${D}/lib/firmware/rtlbt/
	install -m 755 ${WORKDIR}/8822CS/rtl8822cs_config ${D}/lib/firmware/rtlbt/
}

FILES_${PN} += "/lib/firmware/rtlbt /usr/sbin"
TARGET_CC_ARCH += "${LDFLAGS}"
