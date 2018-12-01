var gulp = require("gulp");
var browserSync = require("browser-sync");
var config = require("./config");

gulp.task("browserSync", function() {
  return browserSync.init(
    [config.path.html.src, config.path.css.destFile, config.path.js.destFile],
    {
      port: 9090,
      server: {
        baseDir: config.path.root
      }
    }
  );
});
