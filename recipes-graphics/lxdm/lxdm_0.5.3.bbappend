do_compile_prepend(){
    # set default session to lxqt, autologin as gumstix user, and set theme to gumstix theme
    sed -i     -e 's,# session=.*,session=/usr/bin/startlxqt,g' \
        -e 's,# autologin.*,autologin=gumstix,g' \
	-e 's,^theme=.*,theme=Gumstix,g' \
        ${S}/data/lxdm.conf.in
}
