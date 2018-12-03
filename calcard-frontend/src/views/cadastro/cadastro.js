(function() {
  "use strict";

  angular.module("calcard").component("cadastro", {
    templateUrl: "../views/cadastro/cadastro.component.html",
    controller: cadastroController,
    controllerAs: "vm"
  });

  cadastroController.$inject = ["clientesservice", "analisecreditoservice"];

  function cadastroController(clientesservice, analisecreditoservice) {
    var vm = this;

    vm.submit = submit;

    init();

    function init() {}

    function submit(cliente) {
      if (cliente.id) updateCliente(cliente);
      else createCliente(cliente);
    }

    function updateCliente(cliente) {
      clientesservice.updateCliente(cliente).then(function(data) {
        if (data) analisarCredito(data);
      });
    }

    function createCliente(cliente) {
      clientesservice.createCliente(cliente).then(function(data) {
        if (data) {
          cliente.id = data.id;
          analisarCredito(data);
        }
      });
    }

    function analisarCredito(data) {
      analisecreditoservice.createAnaliseCredito(data).then(function(data) {
        vm.data = data;
      });
    }
  }
})();
