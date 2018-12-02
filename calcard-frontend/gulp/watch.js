var gulp = require("gulp");
var watch = require("gulp-watch");
var config = require("./config");

gulp.task("watch", function() {
  gulp.watch(
    [config.path.scss.glob, config.path.js.main],
    ["devCss", "jsAppConcat"]
  );
});
