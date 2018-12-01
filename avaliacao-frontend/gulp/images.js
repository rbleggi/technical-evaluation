var gulp = require("gulp");
var imageMin = require("gulp-imagemin");
var cache = require("gulp-cache");
var config = require("./config");

gulp.task("images", function() {
  return gulp
    .src(config.path.img.src)
    .pipe(cache(imageMin()))
    .pipe(gulp.dest(config.path.img.dest));
});
