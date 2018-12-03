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
