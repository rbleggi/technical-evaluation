(function() {
  "use strict";

  angular.module("calcard", []);
})();

(function() {
  "use strict";

  angular.module("calcard").controller("CalcardController", CalcardController);

  CalcardController.$inject = [];

  function CalcardController() {
    var vm = this;

    init();

    function init() {
      console.log("aaaaaaaaa");
    }
  }
})();
