require gstreamer1.0-plugins-good.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607 \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe"

SRC_URI = " \
    http://gstreamer.freedesktop.org/src/gst-plugins-good/gst-plugins-good-${PV}.tar.xz \
    file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
    file://avoid-including-sys-poll.h-directly.patch \
    file://ensure-valid-sentinel-for-gst_structure_get.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://0001-v4l2-modify-GstV4l2VideoDecCData-to-GstV4l2VideoCDat.patch \
    file://0002-v4l2-add-GstVideoCData-to-v4l2-utils.h.patch \
    file://0003-v4l2-modify-the-max-encoded-size.patch \
    file://0004-v4l2object-fix-size-of-encoder-and-decoder.patch \
    file://0005-v4l2-add-v4l2-video-encoder.patch \
    file://0006-v4l2-add-register-of-gstv4l2videoenc.patch \
    file://0007-v4l2-encoder-class.patch \
    file://0008-v4l2-add-handler-of-Controls-ID.patch \
    file://0009-v4l2-video-encoder-decoder-register.patch \
    file://0010-v4l2-remove-a-deadlock-in-videoenc-framework.patch \
    file://0011-v4l2-Configure-encoder-output-dimension-with-the-sam.patch \
    file://0012-v4l-patch-applied.patch \
"
SRC_URI[md5sum] = "cc0cc13cdb07d4237600b6886b81f31d"
SRC_URI[sha256sum] = "8a86c61434a8c44665365bd0b3557a040937d1f44bf69caee4e9ea816ce74d7e"

S = "${WORKDIR}/gst-plugins-good-${PV}"
