require go.inc

DEPENDS = "go-bootstrap-native"

SSTATE_SCAN_CMD = "true"

SRC_URI = "${SRC_URI_PREFIX}/go${PV}.src.tar.gz;subdir=go-${PV}"
SRC_URI[md5sum] = "19a4e7ce81d67e8d98cf92c3c0b36596"
SRC_URI[sha256sum] = "afc1e12f5fe49a471e3aae7d906c73e9d5b1fdd36d52d72652dde8f6250152fb"


LIC_FILES_CHKSUM = "file://${WORKDIR}/go-${PV}/go/LICENSE;md5=5d4950ecb7b26d2c5e4e7b4e0dd74707"
