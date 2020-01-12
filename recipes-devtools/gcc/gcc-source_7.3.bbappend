FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
 
SRC_URI_append = "\
    file://0050-fix-libsanitizer-ustat.patch \
"
