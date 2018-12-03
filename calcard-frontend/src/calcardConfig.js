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
