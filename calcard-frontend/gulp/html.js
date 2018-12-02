var gulp = require("gulp");
var htmlmin = require("gulp-htmlmin");
var htmlreplace = require("gulp-html-replace");
var inlinesource = require("gulp-inline-source");
var replace = require("gulp-replace");
var config = require("./config");

gulp.task("html", function() {
  return gulp
    .src(config.path.html.src)
    .pipe(htmlmin({ collapseWhitespace: true }))
    .pipe(inlinesource())
    .pipe(
      htmlreplace({
        css: "assets/css/calcard.min.css",
        js: "assets/js/calcard.min.js"
      })
    )
    .pipe(replace("../fonts/", "./assets/fonts/"))
    .pipe(replace("../../assets/", "assets/"))
    .pipe(gulp.dest(config.path.html.dest));
});
