SUMMARY = "Common CA certificates"
DESCRIPTION = "This package includes PEM files of CA certificates to allow \
SSL-based applications to check for the authenticity of SSL connections. \
This derived from Debian's CA Certificates."
HOMEPAGE = "http://packages.debian.org/sid/ca-certificates"
SECTION = "misc"
LICENSE = "GPL-2.0+ & MPL-2.0"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=48d2baf97986999e776b43c8dd9e0c5a"

# This is needed to ensure we can run the postinst at image creation time
DEPENDS = "ca-certificates-native"
DEPENDS_class-native = ""

# tag: debian/20150426
SRCREV = "651de1c8439c6206ea76b7d502daa9de05b5a461"

SRC_URI = "git://anonscm.debian.org/collab-maint/ca-certificates.git \
    file://0001-Make-paths-relative-to-SYSROOT.patch \
    file://0002-Find-SYSROOT-relative-to-its-own-location.patch \
    file://0003-Alter-the-install-path-for-update-cat-certificates.patch \
"

S = "${WORKDIR}/git"

inherit allarch

EXTRA_OEMAKE = "\
    'CERTSDIR=${datadir}/ca-certificates' \
    'SBINDIR=${sbindir}' \
"

do_compile_prepend() {
    oe_runmake clean
}

do_install () {
    install -d ${D}${datadir}/ca-certificates \
               ${D}${sysconfdir}/ssl/certs \
               ${D}${sysconfdir}/ca-certificates/update.d
    oe_runmake 'DESTDIR=${D}' install

    install -d ${D}${mandir}/man8
    install -m 0644 sbin/update-ca-certificates.8 ${D}${mandir}/man8/

    install -d ${D}${sysconfdir}
    {
        echo "# Lines starting with # will be ignored"
        echo "# Lines starting with ! will remove certificate on next update"
        echo "#"
        find ${D}${datadir}/ca-certificates -type f -name '*.crt' | \
            sed 's,^${D}${datadir}/ca-certificates/,,'
    } >${D}${sysconfdir}/ca-certificates.conf
}

do_install_append_class-target () {
    sed -i -e 's,/etc/,${sysconfdir}/,' \
           -e 's,/usr/share/,${datadir}/,' \
           -e 's,/usr/local,${prefix}/local,' \
        ${D}${sbindir}/update-ca-certificates \
        ${D}${mandir}/man8/update-ca-certificates.8
}

pkg_postinst_${PN} () {
    SYSROOT="$D" update-ca-certificates
}

CONFFILES_${PN} += "${sysconfdir}/ca-certificates.conf"

# Postinsts don't seem to be run for nativesdk packages when populating SDKs.
CONFFILES_${PN}_append_class-nativesdk = " ${sysconfdir}/ssl/certs/ca-certificates.crt"
do_install_append_class-nativesdk () {
    SYSROOT="${D}${SDKPATHNATIVE}" update-ca-certificates
}

do_install_append_class-native () {
    SYSROOT="${D}${base_prefix}" ${D}${sbindir}/update-ca-certificates
}

BBCLASSEXTEND += "native nativesdk"
