(function() {
  "use strict";

  angular.module("calcard").component("home", {
    templateUrl: "../views/home/home.component.html",
    controller: homeContoller,
    controllerAs: "vm"
  });

  homeContoller.$inject = ["analisecreditoservice"];

  function homeContoller(analisecreditoservice) {
    var vm = this;

    vm.submit = submit;

    init();

    function init() {}

    function submit(data) {
      vm.error = null;
      vm.data = null;
      analisecreditoservice
        .createAnaliseCredito(data)
        .then(function(data) {
          vm.data = data;
        })
        .catch(function(error) {
          vm.error = error;
        });
    }
  }
})();
