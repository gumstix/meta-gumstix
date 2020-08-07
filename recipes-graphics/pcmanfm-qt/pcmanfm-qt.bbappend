do_compile_prepend(){
    # change wallpaper to gumstix themed wallpaper
    sed -i     -e 's,^Wallpaper=.*,Wallpaper=/usr/share/lxqt/themes/gumstix-ambiance/wallpaper.png,g' \
        ${S}/config/pcmanfm-qt/lxqt/settings.conf.in
}
