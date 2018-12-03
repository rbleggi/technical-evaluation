var gulp = require("gulp");
var gulpCopy = require("gulp-copy");
var config = require("./config");

gulp.task("files", function() {
  return gulp
    .src(config.path.files.sassdoc)
    .pipe(gulpCopy(config.path.dest))
    .pipe(gulp.dest(config.path.dest));
});
