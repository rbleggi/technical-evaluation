(function() {
  "use strict";

  angular.module("calcard").component("calcardFooter", {
    templateUrl: "../components/calcard-footer/calcard-footer.component.html",
    controller: calcardFooterController,
    controllerAs: "vm"
  });

  calcardFooterController.$inject = [];

  function calcardFooterController() {
    var vm = this;

    init();

    function init() {}
  }
})();
