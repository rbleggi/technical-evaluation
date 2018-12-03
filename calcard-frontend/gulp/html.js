var gulp = require("gulp");
var htmlmin = require("gulp-htmlmin");
var htmlreplace = require("gulp-html-replace");
var bom = require("gulp-bom");
var config = require("./config");

gulp.task("html", function() {
  return gulp
    .src(config.path.html.src)
    .pipe(htmlmin({ collapseWhitespace: true }))
    .pipe(
      htmlreplace({
        css: "assets/css/calcard.min.css",
        js: "assets/js/calcard.min.js"
      })
    )
    .pipe(bom())
    .pipe(gulp.dest(config.path.html.dest));
});
