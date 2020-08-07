
do_compile_prepend(){
    # set default theme to ambiance
    sed -i     -e 's,^theme=.*,theme=gumstix-ambiance,g' \
        ${S}/config/lxqt.conf
    # set window manager to select openbox automatically
    sed -i     -e '/\[General\]/a window_manager=openbox' \
	${S}/config/session.conf
}
