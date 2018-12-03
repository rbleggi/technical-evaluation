(function() {
  "use strict";

  angular.module("calcard").component("calcardHeader", {
    templateUrl: "../components/calcard-header/calcard-header.component.html",
    controller: calcardHeaderController,
    controllerAs: "vm"
  });

  calcardHeaderController.$inject = ["$state"];

  function calcardHeaderController($state) {
    var vm = this;
    vm.buttonToogle = false;

    init();

    function init() {
      onStateChange($state);
    }

    function onStateChange(state) {
      if (state.current.name === "cadastro") vm.buttonShow = true;
    }
  }
})();
