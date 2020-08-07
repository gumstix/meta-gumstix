FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = " file://git/themes/ambiance/wallpaper.png"

do_compile_prepend(){
    # change wallpaper to gumstix themed wallpaper
    sed -i     -e 's,^wallpapers/1/file=.*,wallpapers/1/file=wallpaper.png,g' \
        ${S}/themes/ambiance/wallpaper.cfg
    rm ${S}/themes/ambiance/Butterfly-Kenneth-Wimer.jpg
    # rename ambiance theme to gumstix-ambiance theme, includes wallpaper
    mv ${S}/themes/ambiance ${S}/themes/gumstix-ambiance
}
