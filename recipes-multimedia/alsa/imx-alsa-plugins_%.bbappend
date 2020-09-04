do_compile_prepend(){
     # add input_format and output_format to mxc_asrc.h
     sed -i '/unsigned int output_sample_rate;$/ a\\tunsigned int input_format;\n\tunsigned int output_format;' \
          ${STAGING_DIR_TARGET}/usr/include/imx/linux/mxc_asrc.h
}
