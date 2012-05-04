require u-boot.inc

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

PR = "r2"
PV = "2011.12"

COMPATIBLE_MACHINE = "overo"

SRC_URI = "git://www.denx.de/git/u-boot.git;branch=master;protocol=git \
           file://0001-U-Boot-omap_hsmmc-Wait-for-CMDI-to-be-clear.patch \
           file://0002-cleanup_before_linux-void-Don-t-call-v7_outer_cache_.patch \
           file://0003-config-Always-use-GNU-ld.patch \
           file://0004-overo-fix-crashes-for-boards-revision-1.patch \
          "

SRCREV = "137703b811502dfea364650fb3e17f20b4c21333"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_deploy_append () {
	# ship also a version for good old x-loader
	install ${S}/u-boot.bin ${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}-${PV}-${PR}.bin
	cd ${DEPLOY_DIR_IMAGE}
	ln -sf ${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}-${PV}-${PR}.bin u-boot-${MACHINE}.bin
	ln -sf ${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}-${PV}-${PR}.bin u-boot.bin
}

