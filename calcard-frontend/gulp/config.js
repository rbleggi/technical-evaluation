var gulp = require("gulp");

var path = {
  root: "./src",
  dest: "./dist",
  html: {
    src: "./src/**/*.html",
    dest: "./dist"
  },
  img: {
    src: "./src/assets/imagens/**/*",
    dest: "./dist/assets/imagens"
  },
  fonts: {
    css: "./src/assets/scss/base/fonts.scss",
    cssDest: "./src/assets/css",
    src: "./src/assets/fonts/**/*",
    dest: "./dist/assets/fonts"
  },
  scss: {
    main: "./src/assets/scss/calcard.scss",
    glob: "./src/**/*.scss"
  },
  css: {
    dest: "./src/assets/css",
    destFile: "./src/assets/css/calcard.css",
    destConcat: "./src/assets/css/calcard.css",
    build: "./dist/assets/css"
  },
  js: {
    main: [
      "./src/calcard.js",
      "./src/calcardController.js",
      "./src/calcardConfig.js",
      "./src/services/**/*.js",
      "./src/views/**/*.js",
      "./src/components/**/*.js"
    ],
    lib: [
      "./node_modules/angular/angular.js",
      "./node_modules/@uirouter/angularjs/release/angular-ui-router.js",
      "./node_modules/angular-input-masks/releases/angular-input-masks-standalone.js"
    ],
    dest: "./src/assets/js",
    destConcat: [
      "./src/assets/js/calcard-lib.js",
      "./src/assets/js/calcard.js"
    ],
    destFile: "./src/assets/js/calcard.js",
    build: "./dist/assets/js"
  },
  files: {
    sassdoc: "./sassdoc/**/*"
  }
};

module.exports.path = path;
