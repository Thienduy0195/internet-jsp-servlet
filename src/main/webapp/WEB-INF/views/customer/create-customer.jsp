<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create customer</title>
<style type="text/css">
 <%@include file="/resources/css/bootstrap.min.css"%>
 <%@include file="/resources/css/create-customer.css"%>
</style>

</head>
<body style="background-color: #121212;">

	<%@ include file="../commons/header.jsp"%>

	<div class="container-fluid d-flex justify-content-center">
		<div class="login-form">
			<h3 class="text-center text-white">ADD NEW CUSTOMER</h3>
			<form
				action="${pageContext.request.contextPath}/customer/create"
				method="post" modelAttribute="customer">
				<div class="row my-4">
					<div class="col-md-3" style="padding-right: 15px">
						<div class="form-floating textbox mb-4">

							<input path="customerId" type="text"
								class="form-control input" id="full-name"
								placeholder="Họ và tên" autocomplete="off" />
							<label for="full-name" style="color: white"> Code
								(CUSxxxxx) <span class="text-danger">*</span>
							</label>
						</div>
					</div>
					<div class="col-md-6" style="padding-right: 15px">
						<div class="form-floating textbox mb-4">

							<input path="name" type="text" class="form-control input"
								id="full-name" placeholder="Họ và tên" autocomplete="off" />
							<label for="full-name" style="color: white"> Full name <span
								class="text-danger">*</span>
							</label>
						</div>
					</div>

					<div class="col-md-3" style="padding-right: 15px">
						<div class="form-floating textbox mb-4">
							<input path="phoneNumber" type="text"
								class="form-control input" id="phone-number"
								placeholder="Họ và tên" autocomplete="off" />
							<label for="phone-number" style="color: white"> Phone <span
								class="text-danger">*</span>
							</label>
						</div>
					</div>


				</div>
				<div class="row my-4">
					<div class="col-md-6" style="padding-right: 15px">
						<div class="form-floating textbox mb-4">
							<input path="email" type="email" class="form-control input"
								id="email" placeholder="example@gmail.com" autocomplete="off" />
							<label for="email" style="color: white"> Email <span
								class="text-danger">*</span>
							</label>
						</div>
					</div>

					<div class="col-md-6" style="padding-right: 15px">
						<div class="form-floating textbox mb-4">
							<input path="address" type="text" class="form-control input"
								id="address" placeholder="Họ và tên" autocomplete="off" />
							<label for="address" style="color: white"> Address <span
								class="text-danger">*</span>
							</label>
						</div>
					</div>
				</div>

				<div class="row my-4">
					<div class="col-md-4 my-4"></div>
					<div class="col-md-4" style="text-align: center; width: 100%">
						<button type="submit" name="button"
							class="btn btn-primary btn-responsive w-25" style="height: 40px">Add
							new</button>

						<a href="${pageContext.request.contextPath}/customer/list"
							class="w-25 btn btn-outline-light btn-responsive
        w-25 ms-3"
							style="height: 40px"> Cancel </a>

					</div>
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="../commons/footer.jsp"%>
</body>


</html>