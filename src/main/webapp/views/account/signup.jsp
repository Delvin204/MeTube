<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Sign In</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="icon" href="image/replicate-prediction-6s2bjxbby5oh2woiu7z7zidmsu.png">
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>

<body>
    <div class="d-flex justify-content-center align-middle"
        style="background: linear-gradient(to right, #ffffff 0%, #000000 100%);">
        <div class="card rounded-4" style="max-width: 540px; margin-top: 125px; margin-bottom: 137px;">
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
                        <div class="">
                            <p class="fw-bold">Sign up your accout</p>
                        </div>
                        <form name="myForm" class="needs-validation" method="post" novalidate>
                            <div class="form-floating mb-2">
                                <input type="email" class="form-control" id="floatingInput"
                                    placeholder="user123" name="username" required>
                                <label for="floatingInput">Username</label>
                                <div class="invalid-feedback">Vui lòng nhập username</div>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="password" class="form-control" id="floatingPassword" placeholder="123"
                                    name="password" required>
                                <label for="floatingPassword">Password</label>
                                <div class="invalid-feedback">Vui lòng nhập password</div>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="floatingFullname" placeholder="Nguyễn Văn A"
                                    name="fullname" required>
                                <label for="floatingFullname">Full Name</label>
                                <div class="invalid-feedback">Vui lòng nhập fullname</div>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="email" class="form-control" id="floatingEmail" placeholder="example@gmail.com"
                                    name="email" required>
                                <label for="floatingEmail">Email</label>
                                <div class="invalid-feedback">Vui lòng nhập email</div>
                            </div>
                            <div class="d-grid gap-2 my-2">
                                <button class="btn btn-dark" type="submit">Sign Up</button>
                            </div>
                            <div class="card-text mt-3">
                                <a href="" class="text-decoration-none text-dark">Quên mật khẩu</a>
                            </div>
                            <div class="card-text mt-1 mb-2">
                                <a href="./signin" class="text-decoration-none">Bạn đã có tài khoản? Đăng nhập ngay</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
</body>

</html>