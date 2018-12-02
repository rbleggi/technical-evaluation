var gulp = require("gulp");
var scss = require("gulp-sass");
var wait = require("gulp-wait");
var concat = require("gulp-concat");
var postcss = require("gulp-postcss");
var autoprefixer = require("autoprefixer");
var sorting = require("postcss-sorting");
var discardComments = require("postcss-discard-comments");
var cssnano = require("gulp-cssnano");
var sourcemaps = require("gulp-sourcemaps");
var config = require("./config");

gulp.task("devCss", function() {
  return gulp
    .src(config.path.scss.main)
    .pipe(wait(30))
    .pipe(scss())
    .pipe(postcss([autoprefixer({ browsers: ["last 9 version"] })]))
    .pipe(gulp.dest(config.path.css.dest));
});

gulp.task("buildCss", function() {
  gulp
    .src(config.path.css.destConcat)
    .pipe(sourcemaps.init())
    .pipe(concat("calcard.min.css"))
    .pipe(
      postcss([
        sorting({ "properties-order": "alphabetical" }),
        discardComments({ removeAll: true })
      ])
    )
    .pipe(
      cssnano({
        discardUnused: false,
        autoprefixer: false
      })
    )
    .pipe(sourcemaps.write("./map"))
    .pipe(gulp.dest(config.path.css.build));
});
