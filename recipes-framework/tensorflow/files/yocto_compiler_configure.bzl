# -*- Python -*-
"""Yocto rule for yocto compiler autoconfiguration."""

def _tpl(repository_ctx, tpl, substitutions={}, out=None):
  if not out:
    out = tpl
  repository_ctx.template(
      out,
      Label("//third_party/toolchains/yocto:%s.tpl" % tpl),
      substitutions)


def _yocto_compiler_configure_impl(repository_ctx):
  _tpl(repository_ctx, "CROSSTOOL")
  repository_ctx.symlink(repository_ctx.attr.build_file, "BUILD")


yocto_compiler_configure = repository_rule(
    implementation = _yocto_compiler_configure_impl,
    attrs = {
        "remote_config_repo": attr.string(mandatory = False, default =""),
        "build_file": attr.label(),
    },
)
