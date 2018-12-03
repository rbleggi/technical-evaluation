var gulp = require("gulp");
var requireDir = require("require-dir");
var runSequence = require("run-sequence");
var config = require("./gulp/config");
requireDir("gulp");

gulp.task("dev", function() {
  return runSequence(
    "devCss",
    "jsLibConcat",
    "jsAppConcat",
    "browserSync",
    "watch"
  );
});

gulp.task("build", function() {
  return runSequence(
    "clean",
    "devCss",
    "buildCss",
    "jsBuild",
    "html",
    "fonts",
    "images",
    "files"
  );
});
