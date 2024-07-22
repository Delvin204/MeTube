<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-xs-6 video">
		<a href="./detail?id=${param.id}" class="text-decoration-none">
			<div class="card bg-black border-0 text-light">
				<img src="${param.poster}"
					class="card-img-top rounded-3" alt="...">
				<!-- <video class="rounded-4" src="video/GENSHIN IMPACT BENNETT.EXE (video-converter.com).mp4" controls autoplay muted style="width: 100%;"></video> -->
				<div class="card-text mt-3 fw-bold text-light">${param.title}</div>
				<div class="card-text text-light opacity-50">
					<small> ${param.owner} <svg xmlns="http://www.w3.org/2000/svg"
							height="12" width="12" viewBox="0 0 512 512">
							<!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
							<path fill="#ffffff"
								d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM369 209L241 337c-9.4 9.4-24.6 9.4-33.9 0l-64-64c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.4 33.9 0l47 47L335 175c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9z" /></svg>
					</small>
				</div>
			</div>
		</a>
	</div>
</body>
</html>