<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>User Management</title>
  <link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script type="text/javascript"></script>
	<script src="resources/js/mask.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="https://www.google.com/recaptcha/api.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
	<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>
<body data-ng-app="myapp" data-ng-controller="myappcontroller">
 <div class="container">

   <form name="userForm" data-ng-submit="addUser()" id="dialog-add">
    <div class="table-responsive">
      <table class="table table-bordered" style="width: 600px">
        <tr>
          <td>First name</td>
          <td><input class="form-control" type="text" name="firstName" id="firstName" data-ng-model="userform.firstName" 
          size="30" required />
          <span style="color:red" data-ng-show="userForm.firstName.$dirty && userForm.firstName.$invalid">*The name is required.</span>
          </td>
        </tr>
        <tr>
          <td>Last name</td>
          <td><input class="form-control" type="text" name="lastName" id="lastName" data-ng-model="userform.lastName" 
             size="30" required />
             <span style="color:red" data-ng-show="userForm.lastName.$dirty && userForm.lastName.$invalid">*The last name is required.</span>
             </td>
       </tr>
       <tr>
          <td>Phone Number</td>
          <td><input type="text" class="form-control"  name="phoneNumber" id="phoneNumber" data-ng-minlength="10"
           data-ng-model="userform.phoneNumber"
             size="30" required />
             <span style="color:red" data-ng-show="userForm.phoneNumber.$dirty && userForm.phoneNumber.$invalid">*The phone number is required.</span>
             </td>
       </tr>
       <tr>
       <td>
       <div class="g-recaptcha"
			data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"></div>
		</td>
       <td><input type="submit" value="Save" class="btn btn-primary btn-sm"
       id="invokesToastMessage"
       data-ng-disabled="userForm.firstName.$invalid || userForm.lastName.$invalid || userForm.phoneNumber.$invalid" />
       </td>
       </tr>
     </table>
   </div>
 </form>
  	
   <div>
   <h3>Registered Users</h3>
     <table class="table table-bordered" style="width: 900px">
       <tr>
         <th>First name	</th>
         <th>Last name</th>
         <th>Phone number</th>
         <th class="text-center">
         <a data-ng-click="openAddPopup()" class="btn btn-success btn-md">Add</a>
         </th>
      </tr>
      <tr data-ng-repeat="user in users">
        <td>{{ user.firstName}}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.phoneNumber }}</td>
        <td class="text-center"><a data-ng-click="openEditPopup(user)" class="btn btn-primary btn-sm">Edit</a>
           | <a data-ng-click="openDeletePopup(user)" class="btn btn-danger btn-sm">Delete</a></td>
      </tr>
    </table>
  </div>
  </div>
 <div id = "dialog-1" 
         title = "Caution!">Are you sure to delete this user permanently?</div>
		
</body>
</html>