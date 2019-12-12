# need to rename the cudnn header so tensorflow can find it

do_install_append () {
    install -m 0644 ${S}/usr/include/aarch64-linux-gnu/cudnn_v7.h ${D}${includedir}/cudnn.h
}
