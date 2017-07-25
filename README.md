Yocto BSP layer for Gumstix products. 

This repository is developed in the environment provided by the
[Gumstix Yocto manifest][yocto-manifest] repository.  New code is
developed on the *next* branch corresponding to the *dev* branch of the
manifest and, when appropriate, merged back into the current release
branch called out by the *master* branch of the manifest. Older
releases are tagged by name in the manifest repository and use the
release-specific branches found in this repository.

This repository is discussed on the [Gumstix Mailing List][mailing-list]
and feature-requests/issues can be raised against the top-level
[manifest][yocto-manifest] project.

[yocto-manifest]: https://github.com/gumstix/yocto-manifest
[mailing-list]: https://lists.sourceforge.net/lists/listinfo/gumstix-users

This layer depends on:

URI: git://git.yoctoproject.org/poky.git
branch: fido
revision: 83aa565d93aacae484976562ef1ae8dbbb6b2bc0

Layer maintainer: Arun Bharadwaj <arun@gumstix.com> Jason Liu <jason.liu@gumstix.com> Michael Lew <michael.lew@gumstix.com> for Gumstix, Inc.
