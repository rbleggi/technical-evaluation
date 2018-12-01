var gulp = require("gulp");
var config = require("./config");

gulp.task("fonts", function() {
  return gulp
    .src(config.path.fonts.src)
    .pipe(gulp.dest(config.path.fonts.dest));
});
