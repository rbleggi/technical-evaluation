module.exports = {
  extends: [
    "stylelint-config-sass-guidelines",
    "stylelint-config-concentric-order"
  ],
  plugins: ["stylelint-order", "stylelint-scss"],
  rules: {
    "max-nesting-depth": 3,
    "order/properties-alphabetical-order": null
  }
};
