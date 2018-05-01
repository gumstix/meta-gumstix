FILESEXTRAPATHS_prepend := "${THISDIR}:"
SRC_URI += "file://dt-blob.bin"

do_deploy_prepend() {
    cp ${WORKDIR}/dt-blob.bin ${S}/
}
