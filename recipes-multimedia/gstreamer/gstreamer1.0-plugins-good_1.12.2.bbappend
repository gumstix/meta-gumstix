FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
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
