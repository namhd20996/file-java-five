const myApp = angular.module('myApp', ['ngRoute']);

myApp.controller('productController', productController);
myApp.controller('loginController', loginController);
myApp.controller('productOneController', productOneController);
myApp.controller('myController', myController);
myApp.controller('cartController', cartController);
myApp.controller('registerController', registerController);
myApp.controller('historyController', historyController);
myApp.controller('userController', userController);
myApp.controller('managerProductController', managerProductController);

myApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: './product-list.html',
            controller: 'productController'
        })
        .when('/product/:id/detail', {
            templateUrl: './product.html',
            controller: 'productOneController'
        })
        .when('/intro', {
            templateUrl: './introduce.html'
        })
        .when('/view-cart/:checkHeader', {
            templateUrl: './cart.html',
            controller: 'cartController'
        })
        .when('/history-cart/:email', {
            templateUrl: './history-cart.html',
            controller: 'historyController'
        })
        .when('/view-cart-total', {
            templateUrl: './cart-total.html',
            controller: 'myController'
        })
        .otherwise({
            redirectTo: '/'
        })
})

function managerProductController($scope, $rootScope, $location, $http, $routeParams) {
    const token = localStorage.getItem('token');
    $scope.begin = 0;
    $scope.limit = 20;
    $scope.productAdd = {};
    $scope.galleries = [];
    $scope.galleryOne = {};
    $scope.galleryTwo = {};
    $scope.galleryThree = {};
    $scope.getAllProductManager = function () {
        $http({
            url: 'https://example-service-three.onrender.com/api/product/all',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "GET",
        })
            .then(function (response) {
                console.log(response);
                $scope.productsManager = response.data;
                $scope.pageCount = Math.ceil($scope.productsManager.length / $scope.limit);
            },
                function (response) {
                    console.log(response);
                });
    }
    $scope.getAllProductManager();

    $scope.getProduct = (product) => {
        $scope.product = product
    };


    $scope.getStatisticCategory = () => {
        $http({
            url: 'https://example-service-three.onrender.com/api/product/statistic/category',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "GET",
        })
            .then(function (response) {
                console.log(response);
                $scope.statisticCategory = response.data;
            },
                function (response) {
                    console.log(response);
                });
    }

    $scope.getStatisticCategory();
    $scope.getStatisticMonth = () => {
        $http({
            url: 'https://example-service-three.onrender.com/api/order/revenue/month',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "GET",
        })
            .then(function (response) {
                console.log(response);
                $scope.statisticMonth = response.data;
            },
                function (response) {
                    console.log(response);
                });
    }

    $scope.getStatisticMonth();

    $scope.deleteProduct = (product) => {
        console.log(product.id);
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                $http({
                    url: `https://example-service-three.onrender.com/api/product/delete/${product.id}`,
                    headers: { 'Authorization': 'Bearer ' + token },
                    method: "DELETE",
                })
                    .then(function (response) {
                        console.log(response);
                        $scope.getAllProductManager();
                    },
                        function (response) {
                            console.log(response);
                        });
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )
            }
        })
    }

    $scope.getCategories = function () {
        $http({
            url: 'https://example-service-three.onrender.com/api/category/get-all',
            method: "GET",
            headers: { 'Authorization': 'Bearer ' + token }
        })
            .then(function (response) {
                console.log(response)
                $scope.categories = response.data;
            },
                function (response) {

                });
    }
    $scope.getValueCategory = '';

    $scope.getCategories();

    $scope.addProduct = () => {
        $scope.galleries.push(angular.copy($scope.galleryOne));
        $scope.galleries.push(angular.copy($scope.galleryTwo));
        $scope.galleries.push(angular.copy($scope.galleryThree));

        let data = {
            ...$scope.productAdd,
            galleries: $scope.galleries
        }

        $http({
            url: `https://example-service-three.onrender.com/api/product/add/${$scope.getValueCategory}`,
            headers: { 'Authorization': 'Bearer ' + token },
            method: "POST",
            data: data
        })
            .then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
    }

    $scope.first = function () {
        $scope.begin = 0;
    }

    $scope.prev = function () {
        if ($scope.begin > 0) {
            $scope.begin -= $scope.limit;
        }
    }

    $scope.next = function () {
        if ($scope.begin < (($scope.pageCount - 1) * $scope.limit)) {
            $scope.begin += $scope.limit;
        }
    }

    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1) * $scope.limit;
    }

}

function userController($scope, $rootScope, $location, $http, $routeParams) {
    $scope.user = {};
    $scope.isRole = true;
    $scope.deleteUser = (user) => {

        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                const token = localStorage.getItem('token');
                $http({
                    url: `https://example-service-three.onrender.com/api/auth/delete/${user.id}`,
                    headers: { 'Authorization': 'Bearer ' + token },
                    method: "DELETE",
                })
                    .then(function (response) {
                        console.log(response);
                        $scope.getAllUser();
                    },
                        function (response) {
                            console.log(response);
                        });
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )
            }
        })

    }

    $scope.updateUser = () => {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/auth/update',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "PUT",
            data: $scope.user
        })
            .then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
    }


    $scope.getAllUser = function () {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/auth/find-all/1',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "GET",
        })
            .then(function (response) {
                console.log(response);
                $scope.users = response.data;
            },
                function (response) {
                    console.log(response);
                });
    }
    $scope.getAllUser();

    $scope.getAllRole = function () {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/v1/role/all',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "GET",
        })
            .then(function (response) {
                console.log(response);
                $scope.roles = response.data;
            },
                function (response) {
                    console.log(response);
                });
    }
    $scope.getAllRole();

    $scope.getUser = (user) => {
        $scope.user = user;
    }

    $scope.getRole = (role) => {
        $scope.role = role;
        $scope.isRole = true;
    }

    $scope.clearRole = () => {
        $scope.role = {};
        $scope.isRole = false;
    }


    $scope.addRole = () => {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/v1/role/add',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "POST",
            data: { 'name': $scope.role.name, 'code': $scope.role.code }
        })
            .then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
    }

    $scope.updateRole = () => {
        console.log($scope.role.id);
        const token = localStorage.getItem('token');
        $http({
            url: `https://example-service-three.onrender.com/api/v1/role/update/${$scope.role.id}`,
            headers: { 'Authorization': 'Bearer ' + token },
            method: "PUT",
            data: { 'name': $scope.role.name, 'code': $scope.role.code }
        })
            .then(function (response) {
                console.log(response);
            },
                function (response) {
                    console.log(response);
                });
    }

    $scope.deleteRole = (role) => {
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                const token = localStorage.getItem('token');

                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )
            }
        })
    }

    $scope.onChangeRole = (id, role) => {
        console.log(id, role.isChecked, role.code);
        const token = localStorage.getItem('token');

        if (role.isChecked) {
            updateRoleUser();
        }

        if (!role.isChecked) {
            deleteRoleUser();
        }

        function updateRoleUser() {
            $http({
                url: `https://example-service-three.onrender.com/api/auth/update/role/${id}/${role.code}`,
                method: "PUT",
                headers: { 'Authorization': 'Bearer ' + token }
            })
                .then(function (response) {
                    console.log(response);
                    $scope.getAllRole();
                },
                    function (response) {
                        console.log(response);
                    });
        }


        function deleteRoleUser() {
            $http({
                url: `https://example-service-three.onrender.com/api/auth/delete/role/${id}/${role.code}`,
                method: "DELETE",
                headers: { 'Authorization': 'Bearer ' + token }
            })
                .then(function (response) {
                    console.log(response);
                    $scope.getAllRole();
                },
                    function (response) {
                        console.log(response);
                    });
        }

    }
}

function historyController($scope, $rootScope, $location, $http, $routeParams) {
    $scope.isHistoryLoading = true;
    $scope.getHistoryCart = (email) => {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/order-detail/get-email?email=' + email,
            method: "POST",
            headers: { 'Authorization': 'Bearer ' + token }
        })
            .then(function (response) {
                $scope.isHistoryLoading = false;
                console.log(response.data)
                console.log(response.data[0].price)
                $scope.data = response.data;
            },
                function (response) {
console.log(response);
                });
    }
    $scope.getHistoryCart($routeParams.email);
}

function myController($scope, $rootScope, $routeParams, $http, $location) {
    $rootScope.onHeader = true;
    $scope.cart = JSON.parse(localStorage.getItem('cart')) || [];
    $scope.cartTotal = JSON.parse(localStorage.getItem('cartTotal')) || [];
    $scope.username = '';
    $scope.email = '';
    $scope.emailForgot = '';
    $scope.checkLogin = false;
    let emailSystem = localStorage.getItem('emailSystem');
    if (emailSystem) {
        let usernameSystem = localStorage.getItem('username');
        $scope.username = usernameSystem || 'Username';
        $scope.email = emailSystem || undefined;
        $scope.checkLogin = true;
    }

    $scope.logOut = function () {
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/auth/logout',
            headers: { 'Authorization': 'Bearer ' + token },
            method: "POST",
        })
            .then(function (response) {
                localStorage.removeItem('emailSystem');
                location.reload();
                $location.path('/');
            },
                function (response) {
                   console.log(response);
                });
    }
    $scope.info = {
        fullName: '',
        phoneNumber: '',
        address: '',
        email: '',
        products: []
    }

    $scope.deleteProductCartTotal = (product) => {
        let index = $scope.cartTotal.findIndex(item => item.id == product.id);
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                $scope.cartTotal.splice(index, 1);
                localStorage.setItem('cartTotal', JSON.stringify($scope.cartTotal));
                $scope.$apply();
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )
            }
        })
    }

    $scope.getTotal = () => {
        let total = 0;
        for (let index = 0; index < $scope.cartTotal.length; index++) {
            const product = $scope.cartTotal[index];
            total += product.quantity * product.price;
        }
        return total;
    }
    $scope.checkOut = () => {
        let data = {
            ...$scope.info,
            products: $scope.cartTotal.map(item => {
                return {
                    id: item.id,
                    name: item.name,
                    price: item.price,
                    quantity: item.quantity
                }
            })
        }
        const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/order/add',
            method: "POST",
            headers: { 'Authorization': 'Bearer ' + token },
            data: data
        })
            .then(function (response) {
                localStorage.removeItem('cartTotal');
                let timerInterval
                Swal.fire({
                    title: 'Order success! Thank You!..',
                    html: '<p style="color:red;">I will switch to the homepage</p> <b></b> milliseconds.',
                    timer: 6000,
                    timerProgressBar: true,
                    didOpen: () => {
                        Swal.showLoading()
                        const b = Swal.getHtmlContainer().querySelector('b')
                        timerInterval = setInterval(() => {
                            b.textContent = Swal.getTimerLeft()
                        }, 100)
                    },
                    willClose: () => {
                        clearInterval(timerInterval)
                    },
                }).then((result) => {
                    if (!result.isConfirmed) {
                        $location.path('/')
                        $scope.$apply();
                    }
                    /* Read more about handling dismissals below */
                    if (result.dismiss === Swal.DismissReason.timer) {
                        console.log('I was closed by the timer')
                    }
                })
            },
                function (response) {
                    console.log(response);
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Oop! Order fail...',
                        showConfirmButton: false,
                        timer: 1500
                    })
                });
    }

    $scope.forgotPassword = () => {
        $http({
            url: 'https://example-service-three.onrender.com/api/order/add' + $scope.emailForgot,
            method: "POST",
        })
            .then((response) => {

            },
                (response) => {

                });
    }
}

function cartController($scope, $rootScope, $routeParams) {
    var checkHeader = Boolean($routeParams.checkHeader);
    $rootScope.onHeader = !checkHeader;
    $scope.onCheckHeader = function () {
        $rootScope.onHeader = true;
    }
}

function productOneController($scope, $rootScope, $http, $location, $routeParams) {
    $scope.isLoading = false;

    $scope.cart = JSON.parse(localStorage.getItem('cart')) || [];

    $scope.getOneProductById = (id) => {
        $scope.product = {};
        // const token = localStorage.getItem('token');
        $http({
            url: 'https://example-service-three.onrender.com/api/product/get-id?id=' + id,
            method: "GET",
            // headers: { 'Authorization': 'Bearer ' + token }
        })
            .then(function (response) {
                $scope.isLoading = true;
                $scope.product = response.data;
            },
                function (response) {

                });
    }
    $scope.getOneProductById($routeParams.id);
    $scope.addToCart = (product) => {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Add to cart success',
            showConfirmButton: false,
            timer: 1500
        })
        let index = $scope.cart.findIndex(item => item.id == product.id);
        if (index == -1) {
            $scope.cart.push({
                ...product,
                quantity: 1
            });
        } else {
            $scope.cart[index].quantity++;
        }
        localStorage.setItem('cart', JSON.stringify($scope.cart));
    }
}

function loginController($scope, $rootScope, $location, $http) {
    $scope.username = 'sellsad';
    $scope.password = '123@bBbb';
    $rootScope.isAdmin = false;
    const token = localStorage.getItem('token');
    if (token) {
        $location.path('/');
    }
    $scope.onLogin = function () {
        $http({
            url: 'https://example-service-three.onrender.com/api/auth/authenticate',
            method: "POST",
            data: { 'username': $scope.username, 'password': $scope.password }
        })
            .then(function (response) {
                console.log(response)
                console.log(response.data.token)
                $rootScope.isAdmin = response.data.roles.some((role, index) => role.name == 'ADMIN')
                console.log($scope.admin);
                localStorage.setItem('username', response.data.username);
                localStorage.setItem('emailSystem', response.data.email);
                localStorage.setItem('token', response.data.token);
                location.reload();
                // $location.path('/');
            },
                function (response) {
                    console.log(response);
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Login faill',
                        showConfirmButton: false,
                        timer: 1500
                    })
                });
    }
}

function registerController($scope, $rootScope, $http, $location) {
    $scope.username = '';
    $scope.email = '';
    $scope.password = '';
    $scope.registerFunction = function () {
        $http({
            url: 'https://example-service-three.onrender.com/api/auth/register',
            method: "POST",
            data: { 'username': $scope.username, 'password': $scope.password, 'email': $scope.email }
        })
            .then(function (response) {
                console.log(response)
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Register success',
                    showConfirmButton: false,
                    timer: 1500
                })
            },
                function (response) {
                    console.log(response)
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Register faill',
                        showConfirmButton: false,
                        timer: 1500
                    })
                });
    }
}

function productController($scope, $rootScope, $location, $http) {
    $scope.products = [];
    $scope.categories = [];
    $scope.begin = 0;
    $scope.limit = 20;
    const token = localStorage.getItem('token');
    var url = '';
    url = 'https://example-service-three.onrender.com/api/product/all';

    $scope.getCategoryUrl = function (value) {
        url = 'https://example-service-three.onrender.com/api/product/all/category?id=' + value;
        $scope.getProduct();
    }

    $scope.getProduct = function () {
        $scope.products = [];
        $http({
            url: url,
            method: "GET",
            // headers: { 'Authorization': 'Bearer ' + token }
        })
            .then(function (response) {
                $scope.products = response.data;
                $scope.pageCount = Math.ceil($scope.products.length / $scope.limit);
            },
                function (response) {

                });
    }

    $scope.getCategories = function () {
        $http({
            url: 'https://example-service-three.onrender.com/api/category/get-all',
            method: "GET",
            // headers: { 'Authorization': 'Bearer ' + token }
        })
            .then(function (response) {
                console.log(response)
                $scope.categories = response.data;
            },
                function (response) {

                });
    }

    $scope.getCategories();
    $scope.getProduct();
    $scope.isLoading = () => $scope.products.length == 0;

    $scope.first = function () {
        $scope.begin = 0;
    }

    $scope.prev = function () {
        if ($scope.begin > 0) {
            $scope.begin -= $scope.limit;
        }
    }

    $scope.next = function () {
        if ($scope.begin < (($scope.pageCount - 1) * $scope.limit)) {
            $scope.begin += $scope.limit;
        }
    }

    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1) * $scope.limit;
    }
}

myApp.directive('cartProduct', function () {
    return {
        restrict: 'AE',
        templateUrl: './cart-list.html',
        scope: {},
        link: function (scope) {
            scope.sortColumn = 'name';
            scope.reverse = false;
            scope.cartTotal = JSON.parse(localStorage.getItem('cartTotal')) || [];
            scope.productss = JSON.parse(localStorage.getItem('cart')) || [];
            scope.onChangeQuantity = (product) => {
                localStorage.setItem('cart', JSON.stringify(scope.productss));
                let index = scope.productss.findIndex(item => item.id == product.id);
                const productTotal = scope.productss[index];
                let indexTotal = scope.cartTotal.findIndex(item => item.id == productTotal.id);
                if (product.buy) {
                    if (indexTotal == -1) {
                        scope.cartTotal.push(productTotal);
                    } else {
                        scope.cartTotal[indexTotal].quantity = product.quantity;
                    }
                }
                localStorage.setItem('cartTotal', JSON.stringify(scope.cartTotal));
            }

            scope.deleteProductCartList = (product) => {
                let index = scope.productss.findIndex(item => item.id == product.id);
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        scope.productss.splice(index, 1);
                        localStorage.setItem('cart', JSON.stringify(scope.productss));
                        scope.$apply();
                        Swal.fire(
                            'Deleted!',
                            'Your product has been deleted.',
                            'success'
                        )
                    }
                })
            }


            scope.sortData = function (column) {
                if (scope.sortColumn == column) {
                    scope.reverse = !scope.reverse;
                } else {
                    scope.reverse = false;
                    scope.sortColumn = column;
                }
            }

            scope.getSortClass = function (column) {
                if (scope.sortColumn == column) {
                    return scope.reverse ? 'arrow-down' : 'arrow-up';
                } else {
                    return '';
                }
            }
        }
    }
})

myApp.filter('formatVND', function () {
    return function (value) {
        return value.toLocaleString('vi-VN', { style: 'currency', currency: 'vnd' })
    }
})

myApp.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart', function () {
        $rootScope.loading = true;
    })
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading = false;
    })
    $rootScope.$on('$routeChangeError', function () {
        $rootScope.loading = false;
    })

})


