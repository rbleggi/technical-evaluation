(function() {
  "use strict";

  angular.module("calcard", ["ui.router", "ui.utils.masks"]);
})();

(function() {
  "use strict";

  angular.module("calcard").controller("CalcardController", CalcardController);

  CalcardController.$inject = [];

  function CalcardController() {
    var vm = this;

    init();

    function init() {}
  }
})();

(function() {
  "use strict";

  angular.module("calcard").config(ConfigProvider);

  ConfigProvider.$inject = [
    "$locationProvider",
    "$stateProvider",
    "$urlRouterProvider"
  ];

  function ConfigProvider(
    $locationProvider,
    $stateProvider,
    $urlRouterProvider
  ) {
    //$locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/");

    $stateProvider
      .state("home", {
        url: "/",
        views: {
          header: {
            template: "<calcard-header></calcard-header>"
          },
          main: {
            template: "<home></home>"
          },
          footer: {
            template: "<calcard-footer></calcard-footer>"
          }
        }
      })
      .state("cadastro", {
        url: "/cadastro",
        views: {
          header: {
            template: "<calcard-header></calcard-headero>"
          },
          main: {
            template: "<cadastro></cadastro>"
          },
          footer: {
            template: "<calcard-footer></calcard-footer>"
          }
        }
      });
  }
})();

angular
  .module("calcard")
  .factory("analisecreditoservice", analisecreditoservice);

analisecreditoservice.$inject = ["$http"];
var basePath = "http://localhost:8080/api/v1";

function analisecreditoservice($http) {
  return {
    createAnaliseCredito: createAnaliseCredito
  };

  function createAnaliseCredito(cliente) {
    return $http
      .post(basePath + "/analisecredito?cpf=" + cliente.cpf)
      .then(createAnaliseCreditoComplete);

    function createAnaliseCreditoComplete(response) {
      return response.data;
    }
  }
}

angular.module("calcard").factory("clientesservice", clientesservice);

clientesservice.$inject = ["$http"];
var basePath = "http://localhost:8080/api/v1";

function clientesservice($http) {
  return {
    getClientes: getClientes,
    createCliente: createCliente,
    updateCliente: updateCliente
  };

  function getClientes() {
    return $http.get(basePath + "/clientes").then(getClientesComplete);

    function getClientesComplete(response) {
      return response.data;
    }
  }

  function createCliente(cliente) {
    return $http
      .post(basePath + "/clientes", cliente)
      .then(createClientesComplete);

    function createClientesComplete(response) {
      return response.data;
    }
  }

  function updateCliente(cliente) {
    return $http
      .put(basePath + "/clientes/" + cliente.id, cliente)
      .then(createClientesComplete);

    function createClientesComplete(response) {
      return response.data;
    }
  }
}

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
