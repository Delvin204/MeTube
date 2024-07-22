<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
        <title>MeTube</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
        <link rel="icon" href="image/logo/YouTube_Logo_.png">
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/detail.css">
    </head>

    <body>
	<div class="col-12">
		<a href="./detail?id=${param.id}" class="text-decoration-none">
			<div class="card bg-black text-light" style="max-width: 90%;">
				<div class="row g-0">
					<div class="col-md-5">
						<img src="${param.poster}" class="img-fluid rounded-3"
							alt="...">
					</div>
					<div class="col-md-7">
						<div class="content ms-3">
							<h6 class="card-title" style="font-size: 17px;">${param.title}</h6>
							<p class="card-text mb-0">
								<small class="text-light opacity-50"> ${param.owner} <svg
										xmlns="http://www.w3.org/2000/svg" height="12" width="12"
										viewBox="0 0 512 512">
										<!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
										<path fill="#ffffff"
											d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM369 209L241 337c-9.4 9.4-24.6 9.4-33.9 0l-64-64c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.4 33.9 0l47 47L335 175c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9z" /></svg>
								</small>
							</p>
							<p class="card-text">
								<small class="text-light opacity-50">${param.views} lượt xem</small>
							</p>
						</div>
					</div>
				</div>
			</div>
		</a>
	</div>
        <!-- Bootstrap JavaScript Libraries -->
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
        <script src="js/index.js"></script>
        <script src="js/video.js"></script>
    </body>
</html>