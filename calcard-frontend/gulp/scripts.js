var gulp = require("gulp");
var concat = require("gulp-concat");
var ngAnnotate = require("gulp-ng-annotate");
var sourcemaps = require("gulp-sourcemaps");
var uglify = require("gulp-uglify");
var replace = require("gulp-replace");
var config = require("./config");

gulp.task("jsAppConcat", function() {
  return gulp
    .src(config.path.js.main)
    .pipe(concat("calcard.js"))
    .pipe(ngAnnotate())
    .pipe(gulp.dest(config.path.js.dest));
});

gulp.task("jsLibConcat", function() {
  return gulp
    .src(config.path.js.lib)
    .pipe(concat("calcard-lib.js"))
    .pipe(gulp.dest(config.path.js.dest));
});

gulp.task("jsBuild", ["jsAppConcat", "jsLibConcat"], function() {
  return gulp
    .src(config.path.js.destConcat)
    .pipe(replace("../components/", "components/"))
    .pipe(replace("../views/", "views/"))
    .pipe(sourcemaps.init())
    .pipe(concat("calcard.min.js"))
    .pipe(uglify())
    .pipe(sourcemaps.write("./map"))
    .pipe(gulp.dest(config.path.js.build));
});
