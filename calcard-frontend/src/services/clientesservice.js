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
