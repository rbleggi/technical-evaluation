var gulp = require("gulp");

var path = {
  root: "./src",
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
    lib: [],
    dest: "./src/assets/css",
    destFile: "./src/assets/css/calcard.css",
    destConcat: "./src/assets/css/calcard.css",
    build: "./dist/assets/css"
  },
  js: {
    main: [
      "./src/calcard.module.js",
      "./src/calcard.controller.js",
      "./src/utils/*.js",
      "./src/services/**/*.service.js",
      "./src/components/**/*.component.js"
    ],
    lib: ["./node_modules/angular/angular.js"],
    dest: "./src/assets/js",
    destConcat: [
      "./src/assets/js/calcard-lib.js",
      "./src/assets/js/calcard.js"
    ],
    destFile: "./src/assets/js/calcard.js",
    build: "./dist/assets/js"
  }
};

module.exports.path = path;
