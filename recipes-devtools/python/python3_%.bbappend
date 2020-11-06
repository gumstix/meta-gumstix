# Extra configuration for valgrind
#
# For example of how to use valgrind with your python app see
# http://pythonextensionpatterns.readthedocs.io/en/latest/debugging/leak_newrefs_vg.html#finding-where-the-leak-is-with-valgrind
#
# For complete doc see http://pythonextensionpatterns.readthedocs.io/en/latest/debugging/valgrind.html
#
EXTRA_OECONF_append_classes-populate_sdk_base = " \
    --with-pydebug \
    --without-pymalloc \
    --with-valgrind \
"
