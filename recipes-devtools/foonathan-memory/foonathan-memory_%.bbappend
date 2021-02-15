# add nobranch=1 to the memory.git repo, otherwise it gives an error

SRC_URI = "git://github.com/foonathan/memory.git;protocol=https;name=main;nobranch=1 \
    git://github.com/foonathan/compatibility.git;protocol=https;name=comp;destsuffix=git/cmake/comp \
    git://github.com/catchorg/Catch2.git;branch=v2.x;protocol=https;name=catch;destsuffix=git/catch-upstream \
"
