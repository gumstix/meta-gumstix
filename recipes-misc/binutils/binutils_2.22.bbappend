FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append := "file://binutils-check-size-before-memset.patch"
