<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/profile.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="max-width: 80%">
		<div class="row gutters">
			<div class="col-3">
				<div class="card h-100">
					<div class="card-body">
						<div class="account-settings">
							<div class="user-profile">
								<div class="user-avatar">
									<img src="image/352b03faa5630e37e1efbb9798b633e1.jpg"
										alt="Maxwell Admin">
								</div>
								<h5 class="user-name">${param.fullname}</h5>
								<h6 class="user-email">${param.email}</h6>
							</div>
							<div class="about">
								<h5>About</h5>
								<p>User of MeTube</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-9">
				<div class="card h-100">
					<div class="card-body">
						<div class="">
							<form action="./profile" method="post" class="row gutters">
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
									<h6 class="mb-2 text-primary">Personal Details</h6>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
									<div class="form-group">
										<label for="username">Username</label> <input type="text"
											class="form-control" id="username" name="id"
											placeholder="Username" value="${param.id}" readonly>
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
									<div class="form-group">
										<label for="password">Password</label> <input type="password"
											class="form-control" id="password" name="password" placeholder="Password" value="${param.password}">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
									<div class="form-group">
										<label for="fullName">Full Name</label> <input type="text"
											class="form-control" id="fullName" name="fullname"
											placeholder="Full Name" value="${param.fullname}">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6">
									<div class="form-group">
										<label for="eMail">Email</label> <input type="email"
											class="form-control" id="eMail" name="email" placeholder="Email" value="${param.email}">
									</div>
								</div>
								<div class="row gutters mt-4">
									<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
										<div class="text-right">
											<button type="submit" id="submit" name="submit"
												class="btn btn-primary">Update</button>
										</div>
										${messProfile}
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>