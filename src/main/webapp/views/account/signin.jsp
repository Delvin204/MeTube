<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>Login</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />
        <link rel="icon" href="image/logo/YouTube_Logo_.png">
        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
    </head>
<body>
	<div class="d-flex justify-content-center align-middle" style="background: linear-gradient(to right, #ffffff 0%, #000000 100%);">
        <div class="card rounded-4" style="max-width: 540px; margin-top: 136px; margin-bottom: 137px;">
            <div class="row g-0">
                <div class="col-12">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-10">
                                <h3 class="card-title fw-bold">MeTube</h3>
                            </div>
                            <div class="col-2 d-flex justify-content-end">
                                <a href="./index"><img src="image/logo/YouTube_Logo_.png"
                                        alt="" class="w-75"></a>
                            </div>
                        </div>
                        <p class="fw-bold">Sign in to your account</p>
                        <p style="color: red;">${mess}</p>
                        <form action="./signin" name="myForm" class="needs-validation" method="post" novalidate>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingInputUsername"
                                    placeholder="user123" name="username" required>
                                <label for="floatingInputUsername">Email address</label>
                                <div class="invalid-feedback">Vui lòng nhập username</div>
                                <!-- <div style="color:red; font-size: smaller;" ng-if="myForm['account.username'].$touched && myForm['account.username'].$invalid">
                                    <div ng-if="myForm['account.username'].$error.required">Vui lòng nhập email</div>
                                    <div ng-if="myForm['account.username'].$error.email">Vui lòng nhập email hợp lệ
                                </div> -->
                            </div>
                            <div class="form-floating">
                                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
                                <label for="floatingPassword">Password</label>
                                <div class="invalid-feedback">Vui lòng nhập password</div>
                                <!-- <div style="color:red; font-size: smaller;" ng-if="myForm['account.password'].$touched && myForm['account.password'].$invalid">
                                    Vui lòng nhập mật khẩu
                                </div> -->
                            </div>
                            <div class="d-grid gap-2 my-2">
                                <button class="btn btn-dark">Login</button>
                            </div>
                            <div class="row row-cols-1 row-cols-md-2 g-4">
                                <div class="col-6">
                                    <div class="d-grid gap-2">
                                        <button type="button" class="btn border"><img src="image/logo/Google.png" alt=""
                                                style="max-width: 20px;"></button>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="d-grid gap-2">
                                        <button type="button" class="btn border"><img
                                                src="image/logo/Facebook.png" alt=""
                                                style="max-width: 20px;"></button>
                                    </div>
                                </div>
                            </div>
                            <div class="card-text mt-3">
                                <a href="" class="text-decoration-none text-dark">Quên mật khẩu</a>
                            </div>
                            <div class="card-text mt-1 mb-2">
                                <a href="./signup" class="text-decoration-none">Bạn chưa có tài khoản? Đăng ký ngay</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
   <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>
        <script src="js/validate.js"></script>
</body>
</html>